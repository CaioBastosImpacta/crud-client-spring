package com.bastos.app.crudclient.entrypoint.model.request;

import lombok.Getter;

import java.beans.ConstructorProperties;

/**
 * Classe responsavel por conter os dados de entrada para os parametros da requiisção
 *
 * @since 09/05/2021
 */
@Getter
public class ClientModelParamRequest {

    private String expand;

    @ConstructorProperties({"expand"})
    public ClientModelParamRequest(String expand) {
        this.expand = expand;
    }
}
