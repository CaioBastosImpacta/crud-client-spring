package com.bastos.app.crudclient.commons;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Classe responsável por conter o objeto <b>data</b>, que é o modelo principal de saída da API.
 *
 * @param <T>
 *     - Objeto genérico
 *
 * @since 09/05/2021
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataModelResponse<T> {

    private T data;
}
