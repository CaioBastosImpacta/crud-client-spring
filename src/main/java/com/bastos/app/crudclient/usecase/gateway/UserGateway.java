package com.bastos.app.crudclient.usecase.gateway;

import com.bastos.app.crudclient.usecase.domain.request.UserDomainRequest;

public interface UserGateway {

    void saveClient(UserDomainRequest userDomainRequest);
}
