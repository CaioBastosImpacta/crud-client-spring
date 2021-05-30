package com.bastos.app.crudclient.entrypoint.model.request;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Classe responsável por conter os dados de modelo de entrada da aplicação para a base de dados
 * do usuario.
 *
 * @since 22/05/2021
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserModelRequest {

	@ApiModelProperty(example = "Juca Silva", required = true)
    @NotBlank
    private String name;

	@ApiModelProperty(example = "juca@gmail.com", required = true)
    @NotBlank
    private String email;

	@ApiModelProperty(example = "12345678", required = true)
    @NotBlank
    private String password;
}
