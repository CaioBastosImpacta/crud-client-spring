package com.bastos.app.crudclient.mock;

import com.bastos.app.crudclient.dataprovider.repository.entity.ClientEntity;

import java.util.List;

/**
 * Classe responsável por representar o mock de resposta de entidade do cliente
 *
 * @since 23/05/2021
 */
public class ClientEntityMock {

    public static List<ClientEntity> getMockClientEntityList() {
        ClientEntity clientEntity = ClientEntity.builder()
                .id(1L)
                .name("Caio Bastos")
                .birth("1997-09-24")
                .build();

        ClientEntity clientEntity1 = ClientEntity.builder()
                .id(2L)
                .name("Caio Henrique")
                .birth("2000-09-24")
                .build();

        return List.of(clientEntity, clientEntity1);
    }

    public static ClientEntity getMockClientEntity() {
        return ClientEntity.builder()
                .id(1L)
                .name("Caio Bastos")
                .birth("1997-09-24")
                .build();
    }
}
