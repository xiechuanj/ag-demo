package com.xiecj.cloud.zuul.rpc;

import com.xiecj.cloud.common.vo.ObjectRestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("ag-auth")
public interface ClientAuthRpc {
    @RequestMapping(value = "/client/token")
    public ObjectRestResponse getAccessToken(@RequestParam("clientId") String clientId, @RequestParam("secret") String secret);
}
