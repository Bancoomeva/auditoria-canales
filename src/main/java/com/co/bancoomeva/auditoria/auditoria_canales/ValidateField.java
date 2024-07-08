package com.co.bancoomeva.auditoria.auditoria_canales;

import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Constants.FIELD;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Constants.FIELD_MESSAGE_ID;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Constants.FIELD_INVOKER_DATE_TIME;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Constants.MSN_FIELD_ERROR;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Constants.FIELD_IP_TRANSACTION;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Constants.FIELD_COD_TRANSACTION;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Constants.FIELD_CHANNEL;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Constants.FIELD_USER;

import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Commons.MSN_HEADER_NON_PRESENT;

import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.co.bancoomeva.auditoria.auditoria_canales.exceptio.InputValidationException;
import com.co.bancoomeva.auditoria.auditoria_canales.model.FieldAuditoriaCanales;

public class ValidateField {

	public FieldAuditoriaCanales fieldAuditoria(Map<String, String> header) throws InputValidationException {

		FieldAuditoriaCanales auditoriaCanales = new FieldAuditoriaCanales();

		if (header != null) {
			if (Optional.ofNullable(header.get(FIELD_MESSAGE_ID)).isPresent()) {
				auditoriaCanales.setMessageId(header.get(FIELD_MESSAGE_ID));
			}
			if (Optional.ofNullable(header.get(FIELD_INVOKER_DATE_TIME)).isPresent()) {
				auditoriaCanales.setInvokerDateTime(header.get(FIELD_INVOKER_DATE_TIME));
			}
			if (Optional.ofNullable(header.get(FIELD_IP_TRANSACTION)).isPresent()) {
				auditoriaCanales.setIpTransaccion(FIELD_IP_TRANSACTION);
			}
			if (Optional.ofNullable(header.get(FIELD_COD_TRANSACTION)).isPresent()) {
				auditoriaCanales.setCodTransaccion(FIELD_COD_TRANSACTION);
			}
			if (Optional.ofNullable(header.get(FIELD_CHANNEL)).isPresent()) {
				auditoriaCanales.setCanal(FIELD_CHANNEL);
			}
			if (Optional.ofNullable(header.get(FIELD_USER)).isPresent()) {
				auditoriaCanales.setUsuario(FIELD_USER);
			}
		} else {
			throw new InputValidationException(MSN_HEADER_NON_PRESENT);
		}
		return auditoriaCanales;
	}

	public void validateFieldAuditoriaCanales(FieldAuditoriaCanales auditoriaCanales) throws InputValidationException {

		validateFieldNull(FIELD_MESSAGE_ID, Optional.ofNullable(auditoriaCanales.getMessageId()));
		validateFieldNull(FIELD_INVOKER_DATE_TIME, Optional.ofNullable(auditoriaCanales.getInvokerDateTime()));
		validateFieldNull(FIELD_IP_TRANSACTION, Optional.ofNullable(auditoriaCanales.getIpTransaccion()));
		validateFieldNull(FIELD_COD_TRANSACTION, Optional.ofNullable(auditoriaCanales.getCodTransaccion()));
		validateFieldNull(FIELD_CHANNEL, Optional.ofNullable(auditoriaCanales.getCanal()));
		validateFieldNull(FIELD_USER, Optional.ofNullable(auditoriaCanales.getUsuario()));

	//	validateRegEx (auditoriaCanales.getInvokerDateTime(), rejhre, mss);
		
	}

	public void validateFieldNull(String date, Optional<String> value) throws InputValidationException {
		if (value.isEmpty()) {
			throw new InputValidationException(MSN_FIELD_ERROR.replace(FIELD, date));
		}
	}

	public void validateSize(String data, int size, String message) throws InputValidationException {
		if (data.length() > size) {
			throw new InputValidationException(message);
		}

	}

	public void validateRegEx(String data, String regex, String message) throws InputValidationException {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(data);
		if (matcher.matches()) {
			throw new InputValidationException(message);
		}
	}

}
