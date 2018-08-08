package com.xiecj.cloud.zuul.jwt;


import com.xiecj.cloud.zuul.ZuulServer;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ace on 2017/9/10.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ZuulServer.class)
@WebMvcTest
public class BaseUnitTest {
}
