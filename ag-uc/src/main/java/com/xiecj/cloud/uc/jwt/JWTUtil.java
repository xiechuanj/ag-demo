package com.xiecj.cloud.uc.jwt;

import com.xiecj.cloud.common.util.jwt.IJWTInfo;
import com.xiecj.cloud.common.util.jwt.JWTHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JWTUtil {
    @Value("${jwt.pub-key.path}")
    private String pubKeyPath;


    public IJWTInfo getInfoFromToken(String token) throws Exception {
        return JWTHelper.getInfoFromToken(token,pubKeyPath);
    }

}
