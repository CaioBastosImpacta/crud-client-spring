package com.bastos.app.crudclient.entrypoint.mapper;

import com.bastos.app.crudclient.mock.UserModelRequestMock;
import com.bastos.app.crudclient.usecase.domain.request.UserDomainRequest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe responsável por validar cenários de transformação do modelo entrada para o dominio
 * da aplicação com relação aos dados de usuario.
 *
 * @since 23/05/2021
 */
public class UserModelRequestMapperTest {

    public void testConvertModelToDomainSucess() {
        UserDomainRequest userDomainRequest = UserModelRequestMapper.convertModelToDomain(UserModelRequestMock.getMockUserModelRequest());
        assertNotNull(userDomainRequest);

        assertAll(
                () -> assertEquals("Caio Bastos", userDomainRequest.getName()),
                () -> assertEquals("caio@teste.com", userDomainRequest.getEmail()),
                () -> assertEquals("123456", userDomainRequest.getPassword())
        );
    }
}
