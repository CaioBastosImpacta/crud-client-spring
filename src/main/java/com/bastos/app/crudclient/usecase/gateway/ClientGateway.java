package com.bastos.app.crudclient.usecase.gateway;

import com.bastos.app.crudclient.usecase.domain.request.ClientDomainRequest;
import com.bastos.app.crudclient.usecase.domain.response.ClientDomainResponse;

import java.util.List;
import java.util.Optional;

public interface ClientGateway {

    List<ClientDomainResponse> getAllClients();

    Optional<ClientDomainResponse> getByIdClient(Long idClient);

    Optional<ClientDomainResponse> getByNameClient(String name);

    ClientDomainResponse saveClient(ClientDomainRequest clientDomainRequest);

    ClientDomainResponse updateClient(ClientDomainResponse clientNew);

    void deleteClient(Long idClient);


}
