package com.bastos.app.crudclient.usecase.domain.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Classe responsável por conter os dados de domínio de entrada da aplicação para a base de dados
 * do cliente.
 *
 * @since 09/05/2021
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDomainRequest {

    private Long id;
    private String name;
    private String birthDate;
}
