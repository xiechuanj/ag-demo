package com.xiecj.cloud.auth.service;

import com.xiecj.cloud.auth.bean.ClientInfo;
import com.xiecj.cloud.auth.entity.Client;
import com.xiecj.cloud.auth.mapper.ClientMapper;
import com.xiecj.cloud.common.exception.auth.ClientInvalidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DBClientService implements ClientService{
    @Autowired
    private ClientMapper clientMapper;
    @Override
    public ClientInfo apply(String clientId, String secret) {
        Client client = new Client();
        client.setCode(clientId);
        client = clientMapper.selectOne(client);
        if (client == null || !client.getSecret().equals(secret)){
            throw new ClientInvalidException("Client not found or Client secret is error!");
        }
        return new ClientInfo(client.getCode(),client.getName(),client.getId().toString());
    }

    @Override
    public List<String> getAllowedClient(String clientId, String secret) {
        ClientInfo info = this.apply(clientId, secret);
        return clientMapper.selectAllowedClient(info.getId());
    }


}
