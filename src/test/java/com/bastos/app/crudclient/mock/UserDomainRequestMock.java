package com.bastos.app.crudclient.mock;

import com.bastos.app.crudclient.usecase.domain.request.UserDomainRequest;

/**
 * Classe responsável por representar o mock de entrada de dominio do usuario
 *
 * @since 23/05/2021
 */
public class UserDomainRequestMock {

    public static UserDomainRequest getMockUserRequestDomain() {
        return UserDomainRequest.builder()
                .name("Caio Bastos")
                .email("caio@teste.com")
                .password("$2a$10$8gHeOyJLCRtVfMrvvT9ht.bUNJca9HLRu125WpJFINsGTea1TkwWK")
                .build();
    }
}
