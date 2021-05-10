package com.bastos.app.crudclient.entrypoint.mapper;

import com.bastos.app.crudclient.entrypoint.model.request.ClientModelRequest;
import com.bastos.app.crudclient.usecase.domain.request.ClientDomainRequest;

/**
 * Classe responsável por realizar as transformações de dados de entrada que são os modelos
 * da aplicação para os dados de dominio de entrada da aplicação.
 *
 * @since 09/05/2021
 */
public class ClientModelRequestMapper {

    public static ClientDomainRequest convertModelToDomain(ClientModelRequest clientModelRequest) {
        return ClientDomainRequest.builder()
                .name(clientModelRequest.getName())
                .birthDate(clientModelRequest.getBirthDate())
                .build();
    }
}
