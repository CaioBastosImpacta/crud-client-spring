package com.bastos.app.crudclient.entrypoint.mapper;

import com.bastos.app.crudclient.entrypoint.model.response.ClientModelResponse;
import com.bastos.app.crudclient.mock.ClientDomainResponseMock;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de teste para validar os cenários de transformação dos dados de dominio
 * para os dados de saida da aplicação para o cliente.
 *
 * @since 23/05/2021
 */
public class ClientModelResponseMapperTest {

    @Test
    public void testConvertDomainToModelListSucess() {
        List<ClientModelResponse> clientModelResponses = ClientModelResponseMapper
                .convertDomainToModel(ClientDomainResponseMock.getMockClientDomainResponseList());
        assertNotNull(clientModelResponses);

        assertAll(
                () -> assertEquals(1L, clientModelResponses.get(0).getId()),
                () -> assertEquals("Caio Bastos", clientModelResponses.get(0).getName()),
                () -> assertEquals("1997-09-24", clientModelResponses.get(0).getBirthDate()),

                () -> assertEquals(2L, clientModelResponses.get(1).getId()),
                () -> assertEquals("Caio Henrique", clientModelResponses.get(1).getName()),
                () -> assertEquals("2000-09-24", clientModelResponses.get(1).getBirthDate())
        );
    }

    @Test
    public void testConvertDomainToModelSucess() {
        ClientModelResponse clientModelResponse = ClientModelResponseMapper
                .convertDomainToModel(ClientDomainResponseMock.getMockClientDomainResponse());
        assertNotNull(clientModelResponse);

        assertAll(
                () -> assertEquals(1L, clientModelResponse.getId()),
                () -> assertEquals("Caio Bastos", clientModelResponse.getName()),
                () -> assertEquals("1997-09-24", clientModelResponse.getBirthDate())
        );
    }
}
