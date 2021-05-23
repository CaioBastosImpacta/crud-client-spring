package com.bastos.app.crudclient.dataprovider.implementation;

import com.bastos.app.crudclient.dataprovider.mapper.UserDomainRequestMapper;
import com.bastos.app.crudclient.dataprovider.mapper.UserMapper;
import com.bastos.app.crudclient.dataprovider.repository.UserRepository;
import com.bastos.app.crudclient.dataprovider.repository.entity.UserEntity;
import com.bastos.app.crudclient.usecase.domain.request.UserDomainRequest;
import com.bastos.app.crudclient.usecase.gateway.UserGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Classe de implementação dos métodos de contrato do Gateway para a comunicação com a base de dados
 * do usuario, para realizar buscas, cadastros e delação do cliente.
 *
 * @since 22/05/2021
 */
@Component
public class UserImplementation implements UserGateway {

    @Autowired
    UserRepository userRepository;

    @Override
    public void saveClient(UserDomainRequest userDomainRequest) {
        UserEntity userEntity = UserDomainRequestMapper.convertDomainToEntity(userDomainRequest);
        userRepository.save(userEntity);
    }

    @Override
    public UserDomainRequest findByEmail(String email) {
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario nao encontrado."));

        return UserMapper.convertEntityToDomain(userEntity);
    }
}
