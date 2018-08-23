package com.xiecj.cloud.uc.interceptor;

import com.xiecj.cloud.common.constants.CommonConstants;
import com.xiecj.cloud.common.exception.auth.ClientForbiddenException;
import com.xiecj.cloud.common.exception.auth.ClientInvalidException;
import com.xiecj.cloud.common.util.jwt.IJWTInfo;
import com.xiecj.cloud.common.vo.BaseResponse;
import com.xiecj.cloud.common.vo.ObjectRestResponse;
import com.xiecj.cloud.uc.jwt.ClientTokenUtil;
import com.xiecj.cloud.uc.rpc.ClientAuthRpc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ClientInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(ClientInterceptor.class);
    @Value("${client.token-header}")
    private String tokenHeader;
    @Autowired
    private ClientTokenUtil clientTokenUtil;
    @Autowired
    private ClientAuthRpc clientAuthRpc;

    @Value("${client.id}")
    private String clientId;
    @Value("${client.secret}")
    private String clientSecret;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("client interceptor...");
        String token = request.getHeader(tokenHeader);
        IJWTInfo infoFromToken = clientTokenUtil.getInfoFromToken(token);
        String uniqueName = infoFromToken.getUniqueName();
        BaseResponse resp = clientAuthRpc.getAllowedClient(clientId, clientSecret);
        if (resp.getStatus() == 200){
            ObjectRestResponse<List<String>> allowedClient = (ObjectRestResponse<List<String>>) resp;
            for(String client:allowedClient.getData()){
                if(client.equals(uniqueName)){
                    return  super.preHandle(request, response, handler);
                }
            }
        }
        throw new ClientForbiddenException("Client is Forbidden!");
    }
}
