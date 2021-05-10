package com.bastos.app.crudclient.entrypoint.controller.exception;

import com.bastos.app.crudclient.entrypoint.controller.constants.CustomizedResponseExceptionConstants;
import com.bastos.app.crudclient.entrypoint.model.response.MensagemErrorModelResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Classe responsável por conter as customizações de exceções que ocorre na aplicação.
 * Os métodos capturam as exceções lançadas e realiza o devido tratamento.
 *
 * @since 09/05/2021
 */
@ControllerAdvice
public class CustomizedResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({HttpServerErrorException.class, Exception.class})
    public final ResponseEntity<Object> handleServerException(
            Exception exception, WebRequest webRequest) {

        MensagemErrorModelResponse mensagemErrorModelResponse = MensagemErrorModelResponse.builder()
                .codigo(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                .mensagem(CustomizedResponseExceptionConstants.ERRO_INESPERADO)
                .build();

        return new ResponseEntity<>(mensagemErrorModelResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFound.class)
    public final ResponseEntity<Object> handleResourceNotFoundException(Exception exception, WebRequest webRequest) {

        MensagemErrorModelResponse mensagemErrorModelResponse = MensagemErrorModelResponse.builder()
                .codigo(String.valueOf(HttpStatus.NOT_FOUND.value()))
                .mensagem(exception.getMessage())
                .build();

        return new ResponseEntity(mensagemErrorModelResponse, HttpStatus.NOT_FOUND);
    }
}
