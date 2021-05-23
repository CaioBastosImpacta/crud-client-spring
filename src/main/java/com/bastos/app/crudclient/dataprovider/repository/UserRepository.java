package com.bastos.app.crudclient.dataprovider.repository;

import com.bastos.app.crudclient.dataprovider.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Interface de repositorio JPA para assinar o contrato da base de dados.
 *
 * @since 09/05/2021
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);
}
