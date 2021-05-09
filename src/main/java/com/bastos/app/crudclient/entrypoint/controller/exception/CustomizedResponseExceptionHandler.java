package com.bastos.app.crudclient.entrypoint.controller.exception;

import com.bastos.app.crudclient.entrypoint.controller.constants.CustomizedResponseExceptionConstants;
import com.bastos.app.crudclient.entrypoint.model.response.MensagemErrorModelResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({HttpServerErrorException.class, Exception.class})
    public final ResponseEntity<Object> handleServerException(
            HttpServerErrorException httpServerErrorException, WebRequest webRequest) {

        MensagemErrorModelResponse mensagemErrorModelResponse = MensagemErrorModelResponse.builder()
                .codigo(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                .mensagem(CustomizedResponseExceptionConstants.ERRO_INESPERADO)
                .build();

        return new ResponseEntity<>(mensagemErrorModelResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({HttpClientErrorException.class})
    public final ResponseEntity<Object> handleClientException(
            HttpServerErrorException httpServerErrorException, WebRequest webRequest) {

        MensagemErrorModelResponse mensagemErrorModelResponse = MensagemErrorModelResponse.builder()
                .codigo(String.valueOf(HttpStatus.NOT_FOUND.value()))
                .mensagem(CustomizedResponseExceptionConstants.NOT_FOUND)
                .build();

        return new ResponseEntity<>(mensagemErrorModelResponse, HttpStatus.NOT_FOUND);
    }
}
