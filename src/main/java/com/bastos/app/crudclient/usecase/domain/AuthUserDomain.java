package com.bastos.app.crudclient.usecase.domain;

import com.bastos.app.crudclient.usecase.domain.request.UserDomainRequest;
import lombok.Getter;
import org.springframework.security.core.userdetails.User;

import java.util.Collections;

@Getter
public class AuthUserDomain extends User {

    private String name;

    public AuthUserDomain(UserDomainRequest userDomain) {
        super(userDomain.getEmail(), userDomain.getPassword(), Collections.emptyList());

        this.name = userDomain.getName();
    }
}
