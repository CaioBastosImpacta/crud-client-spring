package com.bastos.app.crudclient.dataprovider.mapper;

import com.bastos.app.crudclient.dataprovider.repository.entity.ClientEntity;
import com.bastos.app.crudclient.usecase.domain.response.ClientDomainResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ClientDomainMapper {

    public static List<ClientDomainResponse> convertEntityToDomain(List<ClientEntity> allClientsEntity) {
        return allClientsEntity.stream()
                .map(clientEntity -> ClientDomainResponse.builder()
                        .id(clientEntity.getId())
                        .name(clientEntity.getName())
                        .birthDate(clientEntity.getBirth())
                        .build()).collect(Collectors.toList());
    }
}
