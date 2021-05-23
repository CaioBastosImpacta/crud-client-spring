package com.bastos.app.crudclient.mock;

import com.bastos.app.crudclient.entrypoint.model.request.UserModelRequest;

/**
 * Classe responsável por conter o mock de entrada com relação ao modelo de usuario
 */
public class UserModelRequestMock {

    public static UserModelRequest getMockUserModelRequest() {
        return UserModelRequest.builder()
                .name("Caio Bastos")
                .email("caio@teste.com")
                .password("123456")
                .build();
    }
}
