package com.bastos.app.crudclient.usecase.domain.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDomainRequest {

    private Long id;
    private String name;
    private String birthDate;
}
