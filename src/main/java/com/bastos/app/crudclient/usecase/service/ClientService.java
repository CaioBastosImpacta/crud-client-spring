package com.bastos.app.crudclient.usecase.service;

import com.bastos.app.crudclient.entrypoint.controller.constants.CustomizedResponseExceptionConstants;
import com.bastos.app.crudclient.entrypoint.controller.exception.ResourceNotFound;
import com.bastos.app.crudclient.entrypoint.model.request.ClientModelRequest;
import com.bastos.app.crudclient.usecase.domain.request.ClientDomainRequest;
import com.bastos.app.crudclient.usecase.domain.response.ClientDomainResponse;
import com.bastos.app.crudclient.usecase.gateway.ClientGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Classe responsável por conter as regras de negócio para as trasações de serviço
 * do cliente e realizar os devidos tratamentos.
 *
 * @since 09/05/2021
 */
@Component
public class ClientService {

    @Autowired
    ClientGateway clientGateway;

    public List<ClientDomainResponse> getAllClients() {
        return clientGateway.getAllClients();
    }

    public Optional<ClientDomainResponse> getByIdClient(Long idClient) {
        return Optional.ofNullable(clientGateway.getByIdClient(idClient)
                .orElseThrow(() -> new ResourceNotFound(CustomizedResponseExceptionConstants.CLIENT_NOT_FOUND)));
    }

    public Optional<ClientDomainResponse> getByNameClient(String name) {
        return Optional.ofNullable(clientGateway.getByNameClient(name)
                .orElseThrow(() -> new ResourceNotFound(CustomizedResponseExceptionConstants.CLIENT_NOT_FOUND)));
    }

    public ClientDomainResponse saveClient(ClientDomainRequest clientDomainRequest) {
        return clientGateway.saveClient(clientDomainRequest);
    }

    public ClientDomainResponse updateClient(Long idClient, ClientModelRequest clientModelRequest) {

        Optional<ClientDomainResponse> clientDomainId = getByIdClient(idClient);

        ClientDomainResponse clientDomainResponse = clientDomainId.get();
        clientDomainResponse.setName(clientModelRequest.getName());
        clientDomainResponse.setBirthDate(clientModelRequest.getBirthDate());

        return clientGateway.updateClient(clientDomainResponse);
    }

    public void deleteClient(Long idClient) {
        getByIdClient(idClient);

        clientGateway.deleteClient(idClient);
    }
}
