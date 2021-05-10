package com.bastos.app.crudclient.usecase.domain.response;

import lombok.*;

/**
 * Classe responsável por conter os dados de domínio de saída da aplicação para a base de dados
 * do cliente.
 *
 * @since 09/05/2021
 */
@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDomainResponse {

    private Long id;
    private String name;
    private String birthDate;
}
