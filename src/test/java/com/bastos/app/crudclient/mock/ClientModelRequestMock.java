package com.bastos.app.crudclient.mock;

import com.bastos.app.crudclient.entrypoint.model.request.ClientModelRequest;

/**
 * Classe de mock para representar o modelo de entrada de dados do cliente
 *
 * @since 23/05/2021
 */
public class ClientModelRequestMock {

    public static ClientModelRequest getMockClientModelRequest() {
        return ClientModelRequest.builder()
                .name("Caio Bastos")
                .birthDate("1997-09-24")
                .build();
    }
}
