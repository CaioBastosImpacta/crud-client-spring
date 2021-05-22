package com.bastos.app.crudclient.usecase.domain.request;

import lombok.*;

/**
 * Classe responsável por conter os dados de domínio de entrada da aplicação para a base de dados
 * do usuario.
 *
 * @since 21/05/2021
 */
@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDomainRequest {

    private String name;
    private String email;
    private String password;
}
