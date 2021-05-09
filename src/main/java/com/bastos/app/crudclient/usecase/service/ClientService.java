package com.bastos.app.crudclient.usecase.service;

import com.bastos.app.crudclient.usecase.domain.response.ClientDomainResponse;
import com.bastos.app.crudclient.usecase.gateway.ClientGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientService {

    @Autowired
    ClientGateway clientGateway;

    public List<ClientDomainResponse> findAllClients() {
        return clientGateway.getAllClient();
    }
}
