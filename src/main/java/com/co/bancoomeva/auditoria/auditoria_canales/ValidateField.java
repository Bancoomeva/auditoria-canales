package com.co.bancoomeva.auditoria.auditoria_canales;

import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Commons.FIELD;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Commons.FINISHED;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Commons.INIT;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Commons.MSN_FIELD_NUNABLE_ERROR;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Commons.MSN_FILED_IP_ERROR;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Commons.MSN_HEADER_NON_PRESENT;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Commons.MSN_FILED_NUMBER_ERROR;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Commons.CARACTER_REQUEST_ID;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Commons.REQUEST_ID_EXCEEDS;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Commons.MSN_FILED_DATE_ISO_8601_ERROR;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Constants.FIELD_CHANNEL;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Constants.FIELD_DATE_TIME;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Constants.FIELD_IP_TERMINAL;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Constants.FIELD_RESQUEST_ID;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Constants.FIELD_USER_LOGIN;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Constants.REGEX_IP_V4;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Constants.REGEX_IP_V6;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Constants.REGEX_DATE_ISO_8601;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Constants.REGEX_POSITIVE_NUMBER;


import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.co.bancoomeva.auditoria.auditoria_canales.exceptio.InputValidationException;
import com.co.bancoomeva.auditoria.auditoria_canales.model.HeadersAuditoria;

public class ValidateField {

	private static final Logger LOGGER = LoggerFactory.getLogger(ValidateField.class);
	
	@SuppressWarnings("unused")
	public void ValideteFirstAuditoria(HeadersAuditoria headersAuditoria) throws InputValidationException {
		LOGGER.debug("Invoque method ValideteFirstAuditoria: " + INIT);
		System.out.println(headersAuditoria.toString());
		if(headersAuditoria != null) {
		validateFieldNull(FIELD_DATE_TIME, Optional.ofNullable(headersAuditoria.getRequest_date_time()));
		validateFieldNull(FIELD_CHANNEL, Optional.ofNullable(headersAuditoria.getChannel()));
		validateFieldNull(FIELD_RESQUEST_ID, Optional.ofNullable(headersAuditoria.getRequest_id()));
		validateFieldNull(FIELD_IP_TERMINAL, Optional.ofNullable(headersAuditoria.getIp_terminal()));
		validateFieldNull(FIELD_USER_LOGIN, Optional.ofNullable(headersAuditoria.getUser_login()));
	
		}else {
			throw new InputValidationException(MSN_HEADER_NON_PRESENT);	
			
		}
		LOGGER.debug("Invoque method ValideteFirstAuditoria: " + FINISHED);
	}
	
	public void validateFieldAuditoriaCanales(HeadersAuditoria auditoriaCanales) throws InputValidationException {

		LOGGER.debug("Invoque method validateFieldAuditoriaCanales: " + INIT);

		validateFieldNull(FIELD_DATE_TIME, Optional.ofNullable(auditoriaCanales.getRequest_date_time()));
		validateRegEx(auditoriaCanales.getRequest_date_time(), REGEX_DATE_ISO_8601, MSN_FILED_DATE_ISO_8601_ERROR.replace(FIELD, FIELD_DATE_TIME));
		validateSize(auditoriaCanales.getRequest_id(), CARACTER_REQUEST_ID,	REQUEST_ID_EXCEEDS);
		validateFieldNull(FIELD_IP_TERMINAL, Optional.ofNullable(auditoriaCanales.getIp_terminal()));
		validateFieldIp(FIELD_IP_TERMINAL, auditoriaCanales.getIp_terminal());
		validateFieldNull(FIELD_CHANNEL, Optional.ofNullable(auditoriaCanales.getChannel()));
		validateFieldNull(FIELD_USER_LOGIN, Optional.ofNullable(auditoriaCanales.getUser_login()));

		LOGGER.debug("Invoque method validateFieldAuditoriaCanales: " + FINISHED);

	}

	public void validateFieldIp(String field, String data) throws InputValidationException {
		if (!validateRegEx(data, REGEX_IP_V4) && !validateRegEx(data, REGEX_IP_V6)) {
			throw new InputValidationException(MSN_FILED_IP_ERROR.replace(FIELD, field));
		}
	}

	public void validateFieldNull(String data, Optional<String> value) throws InputValidationException {
		if (value.isEmpty()) {
			LOGGER.debug("Invoque InputValidationException validateFieldNull: " + data);
			throw new InputValidationException(MSN_FIELD_NUNABLE_ERROR.replace(FIELD, data));
		}
	}

	public void validateSize(String data, int size, String message) throws InputValidationException {
		if (data.length() > size) {
			LOGGER.debug("Invoque InputValidationException validateSize: " + data);
			throw new InputValidationException(message);
		}

	}

	public void validateRegEx(String data, String regex, String message) throws InputValidationException {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(data);
		if (!matcher.matches()) {
			LOGGER.debug("Invoque InputValidationException validateRegEx: " + data);
			throw new InputValidationException(message);
		}
	}

	public boolean validateRegEx(String data, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(data);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}	
  
  public void valideteBoolean(String data, String message, String nameData) throws InputValidationException{
	  
	  Pattern queryLangPattern = Pattern.compile("true|false", Pattern.CASE_INSENSITIVE);
	  Matcher matcher = queryLangPattern.matcher(data);
	  boolean esBoolean = matcher.matches();
	  if(!esBoolean) {
		  LOGGER.debug("Invoque InputValidationException valideteBoolean: " + data);
		  throw new InputValidationException(nameData + ": " +message);
	  }
	 
  }
}
