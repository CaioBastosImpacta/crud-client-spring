package com.bastos.app.crudclient.entrypoint.controller;

import com.bastos.app.crudclient.commons.DataModelMapper;
import com.bastos.app.crudclient.commons.DataModelResponse;
import com.bastos.app.crudclient.entrypoint.controller.constants.UrlConstants;
import com.bastos.app.crudclient.entrypoint.mapper.ClientModelRequestMapper;
import com.bastos.app.crudclient.entrypoint.mapper.ClientModelResponseMapper;
import com.bastos.app.crudclient.entrypoint.model.request.ClientModelParamRequest;
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

/**
 * Classe de controlle responsável por conter os endpoinst de client para realizar as requisições.
 *
 * @since 09/05/2021
 */
@RestController
@RequestMapping(value = UrlConstants.URL_CLIENT)
public class ClientController {

    @Autowired
    ClientService clientService;

    @Autowired
    DataModelMapper dataModelMapper;

    /**
     * Método responsável por relizar a busca de todos os clientes na base de dados.
     *
     * @return {@code ResponseEntity<DataModelResponse<Object>>} - Lista de entidade em um data de Clientes
     */
    @GetMapping
    public ResponseEntity<DataModelResponse<Object>> getAll() {
        List<ClientDomainResponse> allClientsDomain = clientService.getAllClients();

        List<ClientModelResponse> clientModelResponses = ClientModelResponseMapper.convertDomainToModel(allClientsDomain);

        return ResponseEntity.ok(dataModelMapper.setDataModel(clientModelResponses));
    }

    /**
     * Método responsável por relizar a busca de um cliente por ID
     *
     * @return {@code ResponseEntity<DataModelResponse<ClientModelResponse>>} - Entidade em um data de um cliente
     */
    @GetMapping("/{id_client}")
    public ResponseEntity<DataModelResponse<ClientModelResponse>> getById(@PathVariable("id_client") Long idClient) {
        Optional<ClientDomainResponse> clientDomainResponse = clientService.getByIdClient(idClient);

        ClientModelResponse clientModelResponse = ClientModelResponseMapper.convertDomainToModel(clientDomainResponse.get());

        return ResponseEntity.ok(dataModelMapper.setDataModel(clientModelResponse));
    }

    /**
     * Método responsável por relizar a busca de um cliente por Nome. E tem que ser o mesmo nome que está na base de dados
     *
     * @return {@code ResponseEntity<DataModelResponse<ClientModelResponse>>} - Entidade em um data de um cliente
     */
    @GetMapping(UrlConstants.URL_CLIENT_NAME)
    public ResponseEntity<DataModelResponse<ClientModelResponse>> getByName(ClientModelParamRequest clientModelParamRequest) {

        Optional<ClientDomainResponse> clientDomainResponse = clientService.getByNameClient(clientModelParamRequest.getExpand());

        ClientModelResponse clientModelResponse = ClientModelResponseMapper.convertDomainToModel(clientDomainResponse.get());

        return ResponseEntity.ok(dataModelMapper.setDataModel(clientModelResponse));
    }

    /**
     * Método responsável por relizar o cadastro (inclusao) de um cliente na base de dados.
     *
     * @return {@code ResponseEntity<DataModelResponse<ClientModelResponse>>} - O cadastro criado de uma entidade em data de um cliente
     */
    @PostMapping
    public ResponseEntity<DataModelResponse<ClientModelResponse>> save(@RequestBody @Validated ClientModelRequest clientModelRequest) {

        ClientDomainRequest clientDomainRequest = ClientModelRequestMapper.convertModelToDomain(clientModelRequest);

        ClientDomainResponse clientDomainResponse = clientService.saveClient(clientDomainRequest);

        ClientModelResponse clientModelResponse = ClientModelResponseMapper.convertDomainToModel(clientDomainResponse);

        return new ResponseEntity<>(dataModelMapper.setDataModel(clientModelResponse), HttpStatus.CREATED);
    }

    /**
     * Método responsável por relizar a atualização por id de um cliente na base de dados.
     *
     * @return {@code ResponseEntity<DataModelResponse<ClientModelResponse>>} - A atualização de dados de uma entidade em data de um cliente
     */
    @PutMapping("/{id_client}")
    public ResponseEntity<DataModelResponse<ClientModelResponse>> update (@PathVariable("id_client") Long idClient,
        @RequestBody @Validated ClientModelRequest clientModelRequest) {

        ClientDomainResponse clientDomainResponse = clientService.updateClient(idClient, clientModelRequest);

        ClientModelResponse clientModelResponse = ClientModelResponseMapper.convertDomainToModel(clientDomainResponse);

        return new ResponseEntity<>(dataModelMapper.setDataModel(clientModelResponse), HttpStatus.CREATED);

    }

    /**
     * Método responsável por relizar a deleção do cadastro por id de um cliente na base de dados.
     * O método não retorna nada, apenas o HttpStatus 204
     *
     */
    @DeleteMapping("/{id_client}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id_client") Long idClient) {
        clientService.deleteClient(idClient);
    }
}
