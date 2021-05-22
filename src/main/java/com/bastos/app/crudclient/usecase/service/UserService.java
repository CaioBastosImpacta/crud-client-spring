package com.bastos.app.crudclient.usecase.service;

import com.bastos.app.crudclient.usecase.domain.request.UserDomainRequest;
import com.bastos.app.crudclient.usecase.gateway.UserGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Classe responsável por conter as regras de negócio para as trasações de serviço
 * do usuario e realizar os devidos tratamentos.
 *
 * @since 09/05/2021
 */
@Component
public class UserService {

    @Autowired
    UserGateway userGateway;

    @Autowired
    PasswordEncoder passwordEncoder;

    public void saveUser(UserDomainRequest userDomainRequest) {
        userDomainRequest.setPassword(passwordEncoder.encode(userDomainRequest.getPassword()));
        userGateway.saveClient(userDomainRequest);
    }
}
