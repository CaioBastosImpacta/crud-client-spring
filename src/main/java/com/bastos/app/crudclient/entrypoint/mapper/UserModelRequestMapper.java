package com.bastos.app.crudclient.entrypoint.mapper;

import com.bastos.app.crudclient.entrypoint.model.request.UserModelRequest;
import com.bastos.app.crudclient.usecase.domain.request.UserDomainRequest;

/**
 * Classe responsável por realizar as transformações de dados de entrada que são os modelos
 * da aplicação para os dados de dominio de entrada da aplicação.
 *
 * @since 21/05/2021
 */
public class UserModelRequestMapper {

    public static UserDomainRequest convertModelToDomain(UserModelRequest userModelRequest) {
        return UserDomainRequest.builder()
                .name(userModelRequest.getName())
                .email(userModelRequest.getEmail())
                .password(userModelRequest.getPassword())
                .build();
    }
}
