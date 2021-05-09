package com.bastos.app.crudclient.dataprovider.implementation;

import com.bastos.app.crudclient.dataprovider.mapper.ClientDomainMapper;
import com.bastos.app.crudclient.dataprovider.repository.ClientRepository;
import com.bastos.app.crudclient.dataprovider.repository.entity.ClientEntity;
import com.bastos.app.crudclient.usecase.domain.response.ClientDomainResponse;
import com.bastos.app.crudclient.usecase.gateway.ClientGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientImplementation implements ClientGateway {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<ClientDomainResponse> getAllClient() {
        List<ClientEntity> allClientsEntity = clientRepository.findAll();

        if (allClientsEntity.isEmpty()) {
            throw new RuntimeException();
        }

        List<ClientDomainResponse> clientsDomainResponses = ClientDomainMapper.convertEntityToDomain(allClientsEntity);

        return clientsDomainResponses;
    }
}
