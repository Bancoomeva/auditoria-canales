package com.co.bancoomeva.auditoria.auditoria_canales;

import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Commons.FIELD;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Commons.MSN_FIELD_NUNABLE_ERROR;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Commons.MSN_FILED_IP_ERROR;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Constants.REGEX_IP_V4;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Constants.REGEX_IP_V6;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.co.bancoomeva.auditoria.auditoria_canales.exceptio.InputValidationException;

public class ValidateField {

	private static final Logger LOGGER = LoggerFactory.getLogger(ValidateField.class);
	

	public void validateFieldIp(String field, String data) throws InputValidationException {
		if (!validateRegEx(data, REGEX_IP_V4) && !validateRegEx(data, REGEX_IP_V6)) {
			throw new InputValidationException(MSN_FILED_IP_ERROR.replace(FIELD, field));
		}
	}

	public void validateFieldNull(String field, Optional<String> value) throws InputValidationException {
		if (value.isEmpty() || value.get().isBlank()) {
			LOGGER.debug("Invoque InputValidationException validateFieldNull: " + field);
			throw new InputValidationException(MSN_FIELD_NUNABLE_ERROR.replace(FIELD, field));
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

	public void valideteBoolean(String data, String message, String nameData) throws InputValidationException {

		Pattern queryLangPattern = Pattern.compile("true|false", Pattern.CASE_INSENSITIVE);
		Matcher matcher = queryLangPattern.matcher(data);
		boolean esBoolean = matcher.matches();
		if (!esBoolean) {
			LOGGER.debug("Invoque InputValidationException valideteBoolean: " + data);
			throw new InputValidationException(nameData + ": " + message);
		}

	}
}
