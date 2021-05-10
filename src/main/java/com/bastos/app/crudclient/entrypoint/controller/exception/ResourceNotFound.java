package com.bastos.app.crudclient.entrypoint.controller.exception;

/**
 * Classe responsável por conter o o lançamento da mensagem de quando
 * os dados ou registros não são encontrados na base de dados.
 *
 * @since 09/05/2021
 */
public class ResourceNotFound extends RuntimeException {

    public ResourceNotFound(String message) {
        super(message);
    }
}
