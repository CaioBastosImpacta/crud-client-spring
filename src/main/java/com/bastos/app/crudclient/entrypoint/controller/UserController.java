package com.bastos.app.crudclient.entrypoint.controller;

import com.bastos.app.crudclient.entrypoint.controller.constants.UrlConstants;
import com.bastos.app.crudclient.entrypoint.mapper.UserModelRequestMapper;
import com.bastos.app.crudclient.entrypoint.model.request.UserModelRequest;
import com.bastos.app.crudclient.usecase.domain.request.UserDomainRequest;
import com.bastos.app.crudclient.usecase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Classe de controlle responsável por conter os endpoinst de client para realizar as requisições.
 *
 * @since 22/05/2021
 */
@RestController
@RequestMapping(value = UrlConstants.URL_USER)
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Validated UserModelRequest userModelRequest) {
        UserDomainRequest userDomainRequest = UserModelRequestMapper.convertModelToDomain(userModelRequest);
        userService.saveUser(userDomainRequest);
    }
}
