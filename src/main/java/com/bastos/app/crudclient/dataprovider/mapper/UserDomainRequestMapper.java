package com.bastos.app.crudclient.dataprovider.mapper;


import com.bastos.app.crudclient.dataprovider.repository.entity.UserEntity;
import com.bastos.app.crudclient.usecase.domain.request.UserDomainRequest;

/**
 * Classe responsável por converter os dados de entrada de domínio da aplicação
 * para os dados de entidade, que é conhecido pelo base de dados do usuario.
 *
 * @since 22/05/2021
 */
public class UserDomainRequestMapper {

    public static UserEntity convertDomainToEntity(UserDomainRequest userDomainRequest) {
        return UserEntity.builder()
                .name(userDomainRequest.getName())
                .email(userDomainRequest.getEmail())
                .password(userDomainRequest.getPassword())
                .build();
    }
}
