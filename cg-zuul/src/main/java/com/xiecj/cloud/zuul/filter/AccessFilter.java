package com.xiecj.cloud.zuul.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.xiecj.cloud.common.constants.CommonConstants;
import com.xiecj.cloud.common.exception.auth.ClientInvalidException;
import com.xiecj.cloud.common.util.jwt.IJWTInfo;
import com.xiecj.cloud.common.vo.BaseResponse;
import com.xiecj.cloud.common.vo.ObjectRestResponse;
import com.xiecj.cloud.zuul.jwt.JWTUtil;

import com.xiecj.cloud.zuul.rpc.ClientAuthRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.assertEquals;

@Component
public class AccessFilter extends ZuulFilter {
    @Value("${zuul.prefix}")
    private String zuulPrefix;
    @Value("${jwt.ignore-url")
    private String jwtIgnoreUrl;
    @Value("${jwt.token-header}")
    private String jwtTokenHeader;

    @Value("${client.id}")
    private String clientId;
    @Value("${client.secret}")
    private String clientSecret;
    @Value("${client.token-header}")
    private String clientTokenHeader;
    @Autowired
    private ClientAuthRpc clientAuthRpc;

    @Autowired
    private JWTUtil jwtUtil;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        if (isIgnorePath(request.getRequestURI()))
            return null;
        String token = request.getHeader(jwtTokenHeader);
        try {
            // 验证用户合法性
            IJWTInfo infoFromToken = jwtUtil.getInfoFromToken(token);
            // todo 用户权限
            // 申请客户端密钥头
            BaseResponse resp = clientAuthRpc.getAccessToken(clientId, clientSecret);
            if(resp.getStatus() == 200){
                ObjectRestResponse<String> clientToken = (ObjectRestResponse<String>) resp;
                ctx.addZuulRequestHeader(clientTokenHeader,clientToken.getData());
            }else {
                throw new ClientInvalidException("Gate client secret is Error");
            }
        } catch (ClientInvalidException ex){
            ctx.setResponseBody(JSON.toJSONString(new BaseResponse(ex.getStatus(), ex.getMessage())));

        } catch (Exception e) {
            ctx.setResponseBody(JSON.toJSONString(new BaseResponse(CommonConstants.EX_TOKEN_ERROR_CODE, "Token error or Token is Expired！")));
            e.printStackTrace();
        }
        return null;
    }

    private boolean isIgnorePath(String path) {
        for (String url : jwtIgnoreUrl.split(",")) {
            if (path.substring(zuulPrefix.length()).startsWith(url)) {
                return true;
            }
        }
        return false;
    }
}
