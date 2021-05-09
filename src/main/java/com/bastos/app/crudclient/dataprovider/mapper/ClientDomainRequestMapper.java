package com.bastos.app.crudclient.dataprovider.mapper;

import com.bastos.app.crudclient.dataprovider.repository.entity.ClientEntity;
import com.bastos.app.crudclient.usecase.domain.request.ClientDomainRequest;
import com.bastos.app.crudclient.usecase.domain.response.ClientDomainResponse;

public class ClientDomainRequestMapper {

    public static ClientEntity convertDomainToEntity(ClientDomainRequest clientDomainRequest) {
        return ClientEntity.builder()
                .name(clientDomainRequest.getName())
                .birth(clientDomainRequest.getBirthDate())
                .build();
    }

    public static ClientEntity convertDomainToEntity(ClientDomainResponse clientNew) {
        return ClientEntity.builder()
                .id(clientNew.getId())
                .name(clientNew.getName())
                .birth(clientNew.getBirthDate())
                .build();
    }
}
