package com.bastos.app.crudclient.dataprovider.repository.entity;

import lombok.*;

import javax.persistence.*;

/**
 * Classe responsável por converter por ser o modelo de entidade para os dados de cliente,
 * no qual serão os dados de entrada e saída da entidade cliente
 *
 * @since 09/05/2021
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "client")
public class ClientEntity {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String birth;
}
