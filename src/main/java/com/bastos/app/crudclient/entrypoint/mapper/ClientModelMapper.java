package com.bastos.app.crudclient.entrypoint.mapper;

import com.bastos.app.crudclient.entrypoint.model.response.ClientModelResponse;
import com.bastos.app.crudclient.usecase.domain.response.ClientDomainResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ClientModelMapper {

    public static List<ClientModelResponse> convertDomainToModel(List<ClientDomainResponse> allClientsDomain) {
        return allClientsDomain.stream()
                .map(clientDomain -> ClientModelResponse.builder()
                        .id(clientDomain.getId())
                        .name(clientDomain.getName())
                        .birthDate(clientDomain.getBirthDate())
                        .build()).collect(Collectors.toList());
    }
}
