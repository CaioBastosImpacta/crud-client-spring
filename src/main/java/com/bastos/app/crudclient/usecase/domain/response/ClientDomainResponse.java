package com.bastos.app.crudclient.usecase.domain.response;

import lombok.*;

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
