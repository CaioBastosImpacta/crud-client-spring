package com.bastos.app.crudclient.mock;

import com.bastos.app.crudclient.usecase.domain.response.ClientDomainResponse;

import java.util.List;

/**
 * CLasse de mock para representar o dominio de resposta da aplicação para os dados de cliente
 *
 * @since 23/05/2021
 */
public class ClientDomainResponseMock {

    public static List<ClientDomainResponse> getMockClientDomainResponseList() {
        ClientDomainResponse clientDomainResponse = ClientDomainResponse.builder()
                .id(1L)
                .name("Caio Bastos")
                .birthDate("1997-09-24")
                .build();

        ClientDomainResponse clientDomainResponse1 = ClientDomainResponse.builder()
                .id(2L)
                .name("Caio Henrique")
                .birthDate("2000-09-24")
                .build();

        return List.of(clientDomainResponse, clientDomainResponse1);
    }

    public static ClientDomainResponse getMockClientDomainResponse() {
        return ClientDomainResponse.builder()
                .id(1L)
                .name("Caio Bastos")
                .birthDate("1997-09-24")
                .build();
    }
}
