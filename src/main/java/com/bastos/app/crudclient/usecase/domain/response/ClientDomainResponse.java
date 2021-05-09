package com.bastos.app.crudclient.usecase.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDomainResponse {

    private Long id;
    private String name;
    private String birthDate;
}
