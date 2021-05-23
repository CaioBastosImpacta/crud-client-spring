package com.bastos.app.crudclient.dataprovider.mapper;

import com.bastos.app.crudclient.dataprovider.repository.entity.UserEntity;
import com.bastos.app.crudclient.usecase.domain.request.UserDomainRequest;

public class UserMapper {

    public static UserDomainRequest convertEntityToDomain(UserEntity userEntity) {
        return UserDomainRequest.builder()
                .name(userEntity.getName())
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .build();
    }
}
