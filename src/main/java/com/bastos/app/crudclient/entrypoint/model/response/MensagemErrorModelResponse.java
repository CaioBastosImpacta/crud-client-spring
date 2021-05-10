package com.bastos.app.crudclient.entrypoint.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Classe responsável por conter os dados de modelo de saída da aplicação para
 * o tratamento de erro com a mensageme e código.
 *
 * @since 09/05/2021
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MensagemErrorModelResponse {

    private String codigo;
    private String mensagem;
}
