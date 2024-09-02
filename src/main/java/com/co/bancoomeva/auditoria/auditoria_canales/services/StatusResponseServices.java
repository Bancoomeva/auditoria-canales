package com.co.bancoomeva.auditoria.auditoria_canales.services;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

import com.co.bancoomeva.auditoria.auditoria_canales.constants.Severity;

import com.co.bancoomeva.auditoria.auditoria_canales.model.StatusResponse;
import com.co.bancoomeva.auditoria.auditoria_canales.model.Status;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

import static com.co.bancoomeva.auditoria.auditoria_canales.constants.HttpStatusCode.BAD_REQUETS;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.HttpStatusCode.OK;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.HttpStatusCode.SCODE_INTERNAL_SERVER_ERROR;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.HttpStatusCode.UNAUTHORIZED;

import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Commons.MSG_INTERNAL_SERVER_ERROR;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Commons.MSG_UNAUTHORIZED;

public class StatusResponseServices {

	private APIGatewayProxyResponseEvent apiGatewayProxyResponseEvent;
	private Gson Gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
	
	
	public APIGatewayProxyResponseEvent successful(String body) {
		apiGatewayProxyResponseEvent = new APIGatewayProxyResponseEvent();
		apiGatewayProxyResponseEvent.setBody(body);
		apiGatewayProxyResponseEvent.setStatusCode(OK);
		return apiGatewayProxyResponseEvent;
	}
	
	public APIGatewayProxyResponseEvent badRequest(String statusDesc, String request_id) {
		apiGatewayProxyResponseEvent = new APIGatewayProxyResponseEvent();		
		apiGatewayProxyResponseEvent.setBody(Gson.toJson(new StatusResponse(new Status(Severity.WARNING, statusDesc, request_id))));
		apiGatewayProxyResponseEvent.setStatusCode(BAD_REQUETS);
		return apiGatewayProxyResponseEvent;		
	}
	
	public APIGatewayProxyResponseEvent unauthorized(String request_id) {
		apiGatewayProxyResponseEvent = new APIGatewayProxyResponseEvent();
		apiGatewayProxyResponseEvent.setBody(Gson.toJson(new StatusResponse(new Status(Severity.WARNING, MSG_UNAUTHORIZED, request_id))));
		apiGatewayProxyResponseEvent.setStatusCode(UNAUTHORIZED);
		return apiGatewayProxyResponseEvent;	
	}
	
	public APIGatewayProxyResponseEvent internalServerError(String request_id) {		
		apiGatewayProxyResponseEvent = new APIGatewayProxyResponseEvent();		
		apiGatewayProxyResponseEvent.setBody(Gson.toJson(new StatusResponse(new Status(Severity.ERROR, MSG_INTERNAL_SERVER_ERROR, request_id))));
		apiGatewayProxyResponseEvent.setStatusCode(SCODE_INTERNAL_SERVER_ERROR);
		return apiGatewayProxyResponseEvent;	
	}
	
}
