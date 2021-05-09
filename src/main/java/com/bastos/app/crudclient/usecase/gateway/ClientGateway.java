package com.bastos.app.crudclient.usecase.gateway;

import com.bastos.app.crudclient.entrypoint.model.request.ClientModelRequest;
import com.bastos.app.crudclient.usecase.domain.request.ClientDomainRequest;
import com.bastos.app.crudclient.usecase.domain.response.ClientDomainResponse;

import java.util.List;
import java.util.Optional;

public interface ClientGateway {

    List<ClientDomainResponse> getAllClients();

    Optional<ClientDomainResponse> getByIdClient(Long idClient);

    ClientDomainResponse saveClient(ClientDomainRequest clientDomainRequest);

    ClientDomainResponse updateClient(ClientDomainResponse clientNew);
}
