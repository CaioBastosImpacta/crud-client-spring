package com.bastos.app.crudclient.entrypoint.mapper;

import com.bastos.app.crudclient.entrypoint.model.request.ClientModelRequest;
import com.bastos.app.crudclient.usecase.domain.request.ClientDomainRequest;

public class ClientModelRequestMapper {

    public static ClientDomainRequest convertModelToDomain(ClientModelRequest clientModelRequest) {
        return ClientDomainRequest.builder()
                .name(clientModelRequest.getName())
                .birthDate(clientModelRequest.getBirthDate())
                .build();
    }
}
