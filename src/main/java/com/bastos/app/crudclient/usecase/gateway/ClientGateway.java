package com.bastos.app.crudclient.usecase.gateway;

import com.bastos.app.crudclient.usecase.domain.response.ClientDomainResponse;

import java.util.List;

public interface ClientGateway {

    List<ClientDomainResponse> getAllClient();
}
