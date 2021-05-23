package com.bastos.app.crudclient.dataprovider.mapper;

import com.bastos.app.crudclient.dataprovider.repository.entity.UserEntity;
import com.bastos.app.crudclient.mock.UserDomainRequestMock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de teste para validar os cenários de testes da transformações
 * de dados de dominio de entrada para a entidade usuario.
 *
 * @since 23/05/2021
 */
public class UserDomainRequestMapperTest {

    @Test
    public void testConvertDomainToEntitySucess() {
        UserEntity userEntity = UserDomainRequestMapper.convertDomainToEntity(UserDomainRequestMock.getMockUserRequestDomain());
        assertNotNull(userEntity);

        assertAll(
                () -> assertEquals("Caio Bastos", userEntity.getName()),
                () -> assertEquals("caio@teste.com", userEntity.getEmail()),
                () -> assertEquals("$2a$10$8gHeOyJLCRtVfMrvvT9ht.bUNJca9HLRu125WpJFINsGTea1TkwWK", userEntity.getPassword())
        );
    }
}
