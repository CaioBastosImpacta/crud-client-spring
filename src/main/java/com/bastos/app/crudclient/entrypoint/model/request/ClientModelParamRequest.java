package com.bastos.app.crudclient.entrypoint.model.request;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.beans.ConstructorProperties;

@Getter
public class ClientModelParamRequest {

    @NotBlank
    private String expand;

    @ConstructorProperties({"expand"})
    public ClientModelParamRequest(String expand) {
        this.expand = expand;
    }
}
