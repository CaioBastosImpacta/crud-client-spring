package com.bastos.app.crudclient.dataprovider.mapper;

import com.bastos.app.crudclient.dataprovider.repository.entity.ClientEntity;
import com.bastos.app.crudclient.mock.ClientDomainRequestMock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de teste para validar os cenários de testes da transformações
 * de dados de dominio de entrada para a entidade no cliente.
 *
 * @since 23/05/2021
 */
public class ClientDomainRequestMapperTest {

    @Test
    public void testConvertDomainToEntitySucess() {
        ClientEntity clientEntity = ClientDomainRequestMapper.convertDomainToEntity(ClientDomainRequestMock.getMockClientDomainRequest());
        assertNotNull(clientEntity);
        assertAll(
                () -> assertEquals("Caio Bastos", clientEntity.getName()),
                () -> assertEquals("1997-09-24", clientEntity.getBirth())
        );
    }

    @Test
    public void testConvertDomainToEntityNewSucess() {
        ClientEntity clientEntity = ClientDomainRequestMapper.convertDomainToEntity(ClientDomainRequestMock.getMockClientDomainResponse());
        assertNotNull(clientEntity);
        assertAll(
                () -> assertEquals(1L, clientEntity.getId()),
                () -> assertEquals("Caio Henrique Bastos", clientEntity.getName()),
                () -> assertEquals("2000-09-24", clientEntity.getBirth())
        );
    }
}
