package com.bastos.app.crudclient.entrypoint.controller;

import com.bastos.app.crudclient.commons.DataModelResponse;
import com.bastos.app.crudclient.entrypoint.mapper.ClientModelMapper;
import com.bastos.app.crudclient.entrypoint.model.response.ClientModelResponse;
import com.bastos.app.crudclient.usecase.domain.response.ClientDomainResponse;
import com.bastos.app.crudclient.usecase.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = UrlConstants.URL_CLIENT)
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping
    public ResponseEntity<DataModelResponse<Object>> getAll() {
        List<ClientDomainResponse> allClientsDomain = clientService.findAllClients();

        List<ClientModelResponse> clientModelResponses = ClientModelMapper.convertDomainToModel(allClientsDomain);

        var clienteDataModelResponse = DataModelResponse.builder()
                .data(clientModelResponses)
                .build();

        return ResponseEntity.ok(clienteDataModelResponse);
    }
}
