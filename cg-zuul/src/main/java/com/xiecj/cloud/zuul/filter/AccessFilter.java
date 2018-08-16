package com.xiecj.cloud.zuul.filter;

import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.xiecj.cloud.common.constants.CommonConstants;
import com.xiecj.cloud.common.util.jwt.IJWTInfo;
import com.xiecj.cloud.common.vo.BaseResponse;
import com.xiecj.cloud.zuul.jwt.JWTUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.assertEquals;

@Component
public class AccessFilter extends ZuulFilter {
    @Autowired
    private  JWTUtil jwtUtil;
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
        //做检验
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        if (request.getRequestURI().substring("/api".length()).startsWith("/auth/jwt")){
            return  null;
        }
        String token = request.getHeader("access-token");
        try {
            IJWTInfo infoFromToken = jwtUtil.getInfoFromToken(token);
            assertEquals(infoFromToken.getUniqueName(), "admin");
        } catch (Exception e){
            ctx.setResponseBody(JSONObject.toJSONString(new BaseResponse(CommonConstants.EX_TOKEN_ERROR_CODE,"Token error or Token is Expired!")));
            e.printStackTrace();
        }
        return null;
    }

}
