package com.bastos.app.crudclient.mock;

import com.bastos.app.crudclient.dataprovider.repository.entity.UserEntity;
import com.bastos.app.crudclient.usecase.domain.request.UserDomainRequest;

/**
 * Classe responsável por representar o mock de entrada de entidade do usuario
 *
 * @since 23/05/2021
 */
public class UserEntityMock {

    public static UserEntity getMockUserRequestEntity() {
        return UserEntity.builder()
                .name("Caio Bastos")
                .email("caio@teste.com")
                .password("$2a$10$8gHeOyJLCRtVfMrvvT9ht.bUNJca9HLRu125WpJFINsGTea1TkwWK")
                .build();
    }
}
