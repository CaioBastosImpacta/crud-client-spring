package com.bastos.app.crudclient.entrypoint.controller.constants;

/**
 * Classe responsável por conter as constantes de mensagens de retornos de erro da aplicação.
 *
 * @since 09/05/2021
 */
public class CustomizedResponseExceptionConstants {

    public static final String ERRO_INESPERADO = "Ocorreu um erro inesperado. Tente mais tarde.";
    public static final String CLIENTS_NOT_FOUND = "Não existem clientes cadastrados.";
    public static final String CLIENT_NOT_FOUND = "Cliente não encontrado.";

    /**
     * Construtor privado para evitar instanciação
     */
    private CustomizedResponseExceptionConstants() {}
}
