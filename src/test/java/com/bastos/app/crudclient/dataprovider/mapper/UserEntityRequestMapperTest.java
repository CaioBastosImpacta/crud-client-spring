package com.bastos.app.crudclient.dataprovider.mapper;

import com.bastos.app.crudclient.mock.UserEntityMock;
import com.bastos.app.crudclient.usecase.domain.request.UserDomainRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de teste para validar os cenários de testes da transformações
 * de dados de entidade de entrada para o dominio de usuario.
 *
 * @since 23/05/2021
 */
public class UserEntityRequestMapperTest {

    @Test
    public void testConvertEntityToDomainSucess() {
        UserDomainRequest userDomainRequest = UserEntityRequestMapper.convertEntityToDomain(UserEntityMock.getMockUserRequestEntity());
        assertNotNull(userDomainRequest);

        assertAll(
                () -> assertEquals("Caio Bastos", userDomainRequest.getName()),
                () -> assertEquals("caio@teste.com", userDomainRequest.getEmail()),
                () -> assertEquals("$2a$10$8gHeOyJLCRtVfMrvvT9ht.bUNJca9HLRu125WpJFINsGTea1TkwWK", userDomainRequest.getPassword())
        );
    }
}
