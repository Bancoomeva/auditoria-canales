package com.co.bancoomeva.auditoria.auditoria_canales;

import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Commons.FIELD;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Commons.MSN_FIELD_NUNABLE_ERROR;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Commons.MSN_FILED_NUMBER_ERROR;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Commons.MSN_FILED_IP_ERROR;

import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Constants.FIELD_MESSAGE_ID;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Constants.FIELD_INVOKER_DATE_TIME;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Constants.FIELD_IP_TRANSACTION;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Constants.FIELD_COD_TRANSACTION;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Constants.FIELD_CHANNEL;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Constants.FIELD_USER;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Constants.REGEX_POSITIVE_NUMBER;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Constants.REGEX_IP_V4;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Constants.REGEX_IP_V6;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Constants.REGEX_DATE_ISO_8601;

import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Commons.MSN_FILED_DATE_ISO_8601_ERROR;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Commons.MSN_HEADER_NON_PRESENT;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Commons.FINISHED;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Commons.INIT;

import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.co.bancoomeva.auditoria.auditoria_canales.exceptio.InputValidationException;
import com.co.bancoomeva.auditoria.auditoria_canales.model.FieldAuditoriaCanales;

public class ValidateField {

	private static final Logger LOGGER = LoggerFactory.getLogger(ValidateField.class);

	public FieldAuditoriaCanales fieldAuditoria(Map<String, String> header) throws InputValidationException {

		LOGGER.debug("Invoque method fieldAuditoria: " + INIT);

		FieldAuditoriaCanales auditoriaCanales = new FieldAuditoriaCanales();

		if (header != null) {
			if (Optional.ofNullable(header.get(FIELD_MESSAGE_ID)).isPresent()) {
				auditoriaCanales.setMessageId(header.get(FIELD_MESSAGE_ID));
			}
			if (Optional.ofNullable(header.get(FIELD_INVOKER_DATE_TIME)).isPresent()) {
				auditoriaCanales.setInvokerDateTime(header.get(FIELD_INVOKER_DATE_TIME));
			}
			if (Optional.ofNullable(header.get(FIELD_IP_TRANSACTION)).isPresent()) {
				auditoriaCanales.setIpTransaccion(header.get(FIELD_IP_TRANSACTION));
			}
			if (Optional.ofNullable(header.get(FIELD_COD_TRANSACTION)).isPresent()) {
				auditoriaCanales.setCodTransaccion(header.get(FIELD_COD_TRANSACTION));
			}
			if (Optional.ofNullable(header.get(FIELD_CHANNEL)).isPresent()) {
				auditoriaCanales.setCanal(header.get(FIELD_CHANNEL));
			}
			if (Optional.ofNullable(header.get(FIELD_USER)).isPresent()) {
				auditoriaCanales.setUsuario(header.get(FIELD_USER));
			}
		} else {
			throw new InputValidationException(MSN_HEADER_NON_PRESENT);
		}

		LOGGER.debug("Invoque method fieldAuditoria: " + FINISHED);

		return auditoriaCanales;

	}

	public void validateFieldAuditoriaCanales(FieldAuditoriaCanales auditoriaCanales) throws InputValidationException {

		LOGGER.debug("Invoque method validateFieldAuditoriaCanales: " + INIT);

		validateFieldNull(FIELD_MESSAGE_ID, Optional.ofNullable(auditoriaCanales.getMessageId()));
		validateFieldNull(FIELD_INVOKER_DATE_TIME, Optional.ofNullable(auditoriaCanales.getInvokerDateTime()));
		validateRegEx(auditoriaCanales.getInvokerDateTime(), REGEX_DATE_ISO_8601, MSN_FILED_DATE_ISO_8601_ERROR.replace(FIELD, FIELD_INVOKER_DATE_TIME));		
		validateFieldNull(FIELD_IP_TRANSACTION, Optional.ofNullable(auditoriaCanales.getIpTransaccion()));
		validateFieldIp(FIELD_IP_TRANSACTION, auditoriaCanales.getIpTransaccion());
		validateFieldNull(FIELD_COD_TRANSACTION, Optional.ofNullable(auditoriaCanales.getCodTransaccion()));
		validateFieldNull(FIELD_CHANNEL, Optional.ofNullable(auditoriaCanales.getCanal()));
		validateRegEx(auditoriaCanales.getCanal(), REGEX_POSITIVE_NUMBER, MSN_FILED_NUMBER_ERROR.replace(FIELD, FIELD_CHANNEL));
		validateFieldNull(FIELD_USER, Optional.ofNullable(auditoriaCanales.getUsuario()));

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

}
