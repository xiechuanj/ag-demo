package com.xiecj.cloud.zuul.jwt;

import com.xiecj.cloud.common.util.jwt.IJWTInfo;
import com.xiecj.cloud.common.util.jwt.JWTHelper;
import com.xiecj.cloud.common.util.jwt.JWTInfo;
import com.xiecj.cloud.zuul.jwt.BaseUnitTest;
import com.xiecj.cloud.zuul.jwt.JWTUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.assertEquals;


/**
 * Created by ace on 2017/9/10.
 */
public class JwtUtilUnitTest extends BaseUnitTest {
    @Autowired
    private JWTUtil util;
    @Test
    public void testJwt() throws Exception {
        String username = "admin";
        String userId = "1";
        String name = "老A";
        String token = util.generateToken(new JWTInfo(username,userId,name));
        System.out.println(token);
        IJWTInfo infoFromToken = util.getInfoFromToken(token);
        System.out.println(infoFromToken.getUniqueName());
        assertEquals(infoFromToken.getUniqueName(),username);
    }
}
