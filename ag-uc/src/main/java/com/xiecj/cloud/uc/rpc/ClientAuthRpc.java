package com.xiecj.cloud.uc.rpc;

import com.xiecj.cloud.common.vo.ObjectRestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("ag-auth")
public interface ClientAuthRpc {
    @RequestMapping(value = "/client/myClient")
    public ObjectRestResponse<List<String>> getAllowedClient(@RequestParam("serviceId") String serviceId, @RequestParam("secret") String secret);
}
