package com.bastos.app.crudclient.entrypoint.controller;

import com.bastos.app.crudclient.commons.DataModelResponse;
import com.bastos.app.crudclient.entrypoint.controller.constants.UrlConstants;
import com.bastos.app.crudclient.entrypoint.mapper.ClientModelRequestMapper;
import com.bastos.app.crudclient.entrypoint.mapper.ClientModelResponseMapper;
import com.bastos.app.crudclient.entrypoint.model.request.ClientModelRequest;
import com.bastos.app.crudclient.entrypoint.model.response.ClientModelResponse;
import com.bastos.app.crudclient.usecase.domain.request.ClientDomainRequest;
import com.bastos.app.crudclient.usecase.domain.response.ClientDomainResponse;
import com.bastos.app.crudclient.usecase.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = UrlConstants.URL_CLIENT)
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping
    public ResponseEntity<DataModelResponse<Object>> getAll() {
        List<ClientDomainResponse> allClientsDomain = clientService.getAllClients();

        List<ClientModelResponse> clientModelResponses = ClientModelResponseMapper.convertDomainToModel(allClientsDomain);

        var clienteDataModelResponse = DataModelResponse.builder()
                .data(clientModelResponses)
                .build();

        return ResponseEntity.ok(clienteDataModelResponse);
    }

    @GetMapping("/{id_client}")
    public ResponseEntity<DataModelResponse<ClientModelResponse>> getById(@PathVariable("id_client") Long idClient) {
        Optional<ClientDomainResponse> clientDomainResponse = clientService.getByIdClient(idClient);

        ClientModelResponse clientModelResponse = ClientModelResponseMapper.convertDomainToModel(clientDomainResponse.get());

        DataModelResponse dataModelResponse = DataModelResponse.builder()
                .data(clientModelResponse)
                .build();

        return ResponseEntity.ok(dataModelResponse);
    }

    @PostMapping
    public ResponseEntity<DataModelResponse<ClientModelResponse>> save(@RequestBody @Validated ClientModelRequest clientModelRequest) {

        ClientDomainRequest clientDomainRequest = ClientModelRequestMapper.convertModelToDomain(clientModelRequest);

        ClientDomainResponse clientDomainResponse = clientService.saveClient(clientDomainRequest);

        ClientModelResponse clientModelResponse = ClientModelResponseMapper.convertDomainToModel(clientDomainResponse);

        DataModelResponse dataModelResponse = DataModelResponse.builder()
                .data(clientModelResponse)
                .build();

        return new ResponseEntity<>(dataModelResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id_client}")
    public ResponseEntity<DataModelResponse<ClientModelResponse>> update (@PathVariable("id_client") Long idClient,
        @RequestBody @Validated ClientModelRequest clientModelRequest) {

        ClientDomainResponse clientDomainResponse = clientService.updateClient(idClient, clientModelRequest);

        ClientModelResponse clientModelResponse = ClientModelResponseMapper.convertDomainToModel(clientDomainResponse);

        DataModelResponse dataModelResponse = DataModelResponse.builder()
                .data(clientModelResponse)
                .build();

        return new ResponseEntity<>(dataModelResponse, HttpStatus.CREATED);
    }
}
