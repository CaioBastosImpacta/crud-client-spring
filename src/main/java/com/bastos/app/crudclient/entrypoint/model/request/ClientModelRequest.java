package com.bastos.app.crudclient.entrypoint.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * Classe responsável por conter os dados de modelo de entrada da aplicação para a base de dados
 * do cliente.
 *
 * @since 09/05/2021
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientModelRequest {

	@ApiModelProperty(example = "Juca Silva", required = true)
    @NotBlank
    private String name;

	@ApiModelProperty(example = "1997-10-13", required = true)
    @NotBlank
    private String birthDate;
}

