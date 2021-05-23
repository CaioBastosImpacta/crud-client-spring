package com.bastos.app.crudclient.dataprovider.mapper;

import com.bastos.app.crudclient.mock.ClientEntityMock;
import com.bastos.app.crudclient.usecase.domain.response.ClientDomainResponse;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de teste para validar os cenários de testes da transformações
 * de dados de entidade de resposta para o dominio no cliente.
 *
 * @since 23/05/2021
 */
public class ClientDomainResponseMapperTest {

    @Test
    public void testConvertEntityToDomainListSucess() {
        List<ClientDomainResponse> clientDomainResponses = ClientDomainResponseMapper
                .convertEntityToDomain(ClientEntityMock.getMockClientEntityList());
        assertNotNull(clientDomainResponses);

        assertAll(
                () -> assertEquals(1L, clientDomainResponses.get(0).getId()),
                () -> assertEquals("Caio Bastos", clientDomainResponses.get(0).getName()),
                () -> assertEquals("1997-09-24", clientDomainResponses.get(0).getBirthDate()),

                () -> assertEquals(2L, clientDomainResponses.get(1).getId()),
                () -> assertEquals("Caio Henrique", clientDomainResponses.get(1).getName()),
                () -> assertEquals("2000-09-24", clientDomainResponses.get(1).getBirthDate())
        );
    }

    @Test
    public void testConvertEntityToDomainSucess() {
        ClientDomainResponse clientDomainResponse = ClientDomainResponseMapper
                .convertEntityToDomain(ClientEntityMock.getMockClientEntity());
        assertNotNull(clientDomainResponse);

        assertAll(
                () -> assertEquals(1L, clientDomainResponse.getId()),
                () -> assertEquals("Caio Bastos", clientDomainResponse.getName()),
                () -> assertEquals("1997-09-24", clientDomainResponse.getBirthDate())
        );
    }
}
