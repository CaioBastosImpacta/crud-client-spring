package com.bastos.app.crudclient.dataprovider.repository;

import com.bastos.app.crudclient.dataprovider.repository.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    Optional<ClientEntity> findByNameIs(String name);
}
