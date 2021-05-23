package com.bastos.app.crudclient.mock;

import com.bastos.app.crudclient.usecase.domain.request.ClientDomainRequest;
import com.bastos.app.crudclient.usecase.domain.response.ClientDomainResponse;

/**
 * Classe responsável por representar o mock de entrada do cliente de dominio
 *
 * @since 23/05/2021
 */
public class ClientDomainRequestMock {

    public static ClientDomainRequest getMockClientDomainRequest() {
        return ClientDomainRequest.builder()
                .name("Caio Bastos")
                .birthDate("1997-09-24")
                .build();
    }

    public static ClientDomainResponse getMockClientDomainResponse() {
        return ClientDomainResponse.builder()
                .id(1L)
                .name("Caio Henrique Bastos")
                .birthDate("2000-09-24")
                .build();
    }
}
