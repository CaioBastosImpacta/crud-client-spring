package com.bastos.app.crudclient.entrypoint.mapper;

import com.bastos.app.crudclient.entrypoint.model.response.ClientModelResponse;
import com.bastos.app.crudclient.usecase.domain.response.ClientDomainResponse;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe responsável por realizar as transformações de dados de domínio da aplicao para os dados
 * modelo de resposta da aplicação.
 *
 * @since 09/05/2021
 */
public class ClientModelResponseMapper {

    public static List<ClientModelResponse> convertDomainToModel(List<ClientDomainResponse> allClientsDomain) {
        return allClientsDomain.stream()
                .map(clientDomain -> ClientModelResponse.builder()
                        .id(clientDomain.getId())
                        .name(clientDomain.getName())
                        .birthDate(clientDomain.getBirthDate())
                        .build()).collect(Collectors.toList());
    }

    public static ClientModelResponse convertDomainToModel(ClientDomainResponse clientDomainResponse) {
        return ClientModelResponse.builder()
                .id(clientDomainResponse.getId())
                .name(clientDomainResponse.getName())
                .birthDate(clientDomainResponse.getBirthDate())
                .build();
    }
}
