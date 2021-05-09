package com.bastos.app.crudclient.dataprovider.implementation;

import com.bastos.app.crudclient.dataprovider.mapper.ClientDomainRequestMapper;
import com.bastos.app.crudclient.dataprovider.mapper.ClientDomainResponseMapper;
import com.bastos.app.crudclient.dataprovider.repository.ClientRepository;
import com.bastos.app.crudclient.dataprovider.repository.entity.ClientEntity;
import com.bastos.app.crudclient.usecase.domain.request.ClientDomainRequest;
import com.bastos.app.crudclient.usecase.domain.response.ClientDomainResponse;
import com.bastos.app.crudclient.usecase.gateway.ClientGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class ClientImplementation implements ClientGateway {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<ClientDomainResponse> getAllClients() {
        List<ClientEntity> allClientsEntity = clientRepository.findAll();

        if (allClientsEntity.isEmpty()) {
            throw new RuntimeException();
        }

        List<ClientDomainResponse> clientsDomainResponses = ClientDomainResponseMapper.convertEntityToDomain(allClientsEntity);

        return clientsDomainResponses;
    }

    @Override
    public Optional<ClientDomainResponse> getByIdClient(Long idClient) {
        Optional<ClientEntity> clientEntity = clientRepository.findById(idClient);

        if (clientEntity.isEmpty()) {
            return Optional.empty();
        }

        ClientDomainResponse clientDomain = ClientDomainResponseMapper.convertEntityToDomain(clientEntity.get());

        return Optional.of(clientDomain);
    }

    @Override
    public Optional<ClientDomainResponse> getByNameClient(String name) {

        Optional<ClientEntity> clientEntity = clientRepository.findByNameIs(name);

        if (clientEntity.isEmpty()) {
            return Optional.empty();
        }

        ClientDomainResponse clientDomain = ClientDomainResponseMapper.convertEntityToDomain(clientEntity.get());

        return Optional.of(clientDomain);
    }

    @Override
    public ClientDomainResponse saveClient(ClientDomainRequest clientDomainRequest) {
        ClientEntity clientEntity = ClientDomainRequestMapper.convertDomainToEntity(clientDomainRequest);
        ClientEntity clientEntityResponse = clientRepository.save(clientEntity);

        if (Objects.isNull(clientEntityResponse)) {
            throw new RuntimeException();
        }

        ClientDomainResponse clientDomainResponse = ClientDomainResponseMapper.convertEntityToDomain(clientEntityResponse);

        return clientDomainResponse;
    }

    @Override
    public ClientDomainResponse updateClient(ClientDomainResponse clientNew) {
        ClientEntity clientEntity = ClientDomainRequestMapper.convertDomainToEntity(clientNew);
        ClientEntity clientEntityResponse = clientRepository.save(clientEntity);

        if (Objects.isNull(clientEntityResponse)) {
            throw new RuntimeException();
        }

        ClientDomainResponse clientDomainResponse = ClientDomainResponseMapper.convertEntityToDomain(clientEntityResponse);

        return clientDomainResponse;
    }

    @Override
    public void deleteClient(Long idClient) {
        try {
            clientRepository.deleteById(idClient);
        } catch (Exception exception) {
            throw new RuntimeException();
        }

    }
}
