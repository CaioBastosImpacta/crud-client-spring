package com.bastos.app.crudclient.entrypoint.model.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Classe responsável por conter os dados de modelo de saída da aplicação para a base de dados
 * do cliente.
 *
 * @since 09/05/2021
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ClientModelResponse {

    private Long id;
    private String name;
    private String birthDate;
}
