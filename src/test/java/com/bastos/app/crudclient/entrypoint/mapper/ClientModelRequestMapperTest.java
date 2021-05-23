package com.bastos.app.crudclient.entrypoint.mapper;

import com.bastos.app.crudclient.mock.ClientModelRequestMock;
import com.bastos.app.crudclient.usecase.domain.request.ClientDomainRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de teste responsável por validar a transformação de dados de entrada para o modelo de cliente
 *
 * @since 23/05/2021
 */
public class ClientModelRequestMapperTest {

    @Test
    public void testConvertModelToDomainSucess() {
        ClientDomainRequest clientDomainRequest = ClientModelRequestMapper
                .convertModelToDomain(ClientModelRequestMock.getMockClientModelRequest());
        assertNotNull(clientDomainRequest);

        assertAll(
                () -> assertEquals("Caio Bastos", clientDomainRequest.getName()),
                () -> assertEquals("1997-09-24", clientDomainRequest.getBirthDate())
        );
    }
}
