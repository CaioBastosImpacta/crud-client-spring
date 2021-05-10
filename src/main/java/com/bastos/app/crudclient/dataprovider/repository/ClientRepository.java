package com.bastos.app.crudclient.dataprovider.repository;

import com.bastos.app.crudclient.dataprovider.repository.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Interface de repositorio JPA para assinar o contrato da base de dados.
 *
 * @since 09/05/2021
 */
@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    /**
     * Método responsável por realizar a busca pelo nome na base de dados. Esse método
     * realiza a consulta pelo nome exato, apenas ignorando lower case e upper case.
     *
     * @param name {@code name}
     *      - Parâmetro do nome que irá receber na entrada
     *
     * @return {@code Optional<ClientEntity}
     *      - Retorna um valor de optional de cliente para evitar nullPointer na aplicação.
     */
    Optional<ClientEntity> findByNameIs(String name);
}
