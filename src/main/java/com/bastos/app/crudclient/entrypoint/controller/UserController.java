package com.bastos.app.crudclient.entrypoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bastos.app.crudclient.entrypoint.controller.constants.UrlConstants;
import com.bastos.app.crudclient.entrypoint.mapper.UserModelRequestMapper;
import com.bastos.app.crudclient.entrypoint.model.request.UserModelRequest;
import com.bastos.app.crudclient.usecase.domain.request.UserDomainRequest;
import com.bastos.app.crudclient.usecase.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Classe de controlle responsável por conter os endpoinst de client para realizar as requisições.
 *
 * @since 22/05/2021
 */
@RestController
@RequestMapping(value = UrlConstants.URL_USER, produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = UrlConstants.URL_USER, description = "REST API for Users", tags = { "user" })
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "Insert a user", notes = "Insert a user")
	@ApiResponses({
        @ApiResponse(code = 201, message = "Successful inclusion of a user"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Validated UserModelRequest userModelRequest) {
        UserDomainRequest userDomainRequest = UserModelRequestMapper.convertModelToDomain(userModelRequest);
        userService.saveUser(userDomainRequest);
    }
}
