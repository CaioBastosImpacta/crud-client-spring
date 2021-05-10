package com.bastos.app.crudclient.usecase.gateway;

import com.bastos.app.crudclient.usecase.domain.request.ClientDomainRequest;
import com.bastos.app.crudclient.usecase.domain.response.ClientDomainResponse;

import java.util.List;
import java.util.Optional;

/**
 * Interface responsável por conter os contratos que o provider que irá comunicar com o mundo externo
 * que ele deverá assinar para fazer as requisições.
 *
 * @since 09/05/2021
 */
public interface ClientGateway {

    List<ClientDomainResponse> getAllClients();

    Optional<ClientDomainResponse> getByIdClient(Long idClient);

    Optional<ClientDomainResponse> getByNameClient(String name);

    ClientDomainResponse saveClient(ClientDomainRequest clientDomainRequest);

    ClientDomainResponse updateClient(ClientDomainResponse clientNew);

    void deleteClient(Long idClient);


}
