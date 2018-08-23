package com.xiecj.cloud.auth.service;

import com.xiecj.cloud.auth.bean.ClientInfo;

import java.util.List;

public interface ClientService {
    public ClientInfo apply(String clientId, String secret);
    public List<String> getAllowedClient(String serviceId, String secret);
}
