package com.bastos.app.crudclient.usecase.service;

import com.bastos.app.crudclient.usecase.domain.AuthUserDomain;
import com.bastos.app.crudclient.usecase.domain.request.UserDomainRequest;
import com.bastos.app.crudclient.usecase.gateway.UserGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserEmailService implements UserDetailsService {

    @Autowired
    UserGateway userGateway;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDomainRequest userDomain = userGateway.findByEmail(username);

        return new AuthUserDomain(userDomain);
    }
}
