package com.bastos.app.crudclient.entrypoint.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bastos.app.crudclient.entrypoint.controller.constants.UrlConstants;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = UrlConstants.URL_HEALTHCHECK)
@Api(value = UrlConstants.URL_HEALTHCHECK, description = "REST API for HealthCheck", tags = { "healthCheck" })
public class HealthCheckController {

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> healthCheck(){
		return ResponseEntity.ok("{\"status\":\"OK\"}");
	}
}
