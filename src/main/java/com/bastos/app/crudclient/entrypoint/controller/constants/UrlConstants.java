package com.bastos.app.crudclient.entrypoint.controller.constants;

/**
 * Classe responsável por conter as constantes de ULR da aplicação.
 *
 * @since 09/05/2021
 */
public class UrlConstants {

    public static final String URL_BASE = "/fit_app/v1";
    public static final String URL_CLIENT = URL_BASE + "/clients";
    public static final String URL_CLIENT_NAME = URL_CLIENT + "/name";

    /**
     * Construtor privado para evitar instanciação
     */
    private UrlConstants() {}
}
