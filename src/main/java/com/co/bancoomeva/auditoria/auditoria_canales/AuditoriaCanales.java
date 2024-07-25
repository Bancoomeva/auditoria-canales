package com.co.bancoomeva.auditoria.auditoria_canales;

import com.co.bancoomeva.auditoria.auditoria_canales.exceptio.InputValidationException;
import com.co.bancoomeva.auditoria.auditoria_canales.model.auditoria.Header;

import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Commons.CARACTER_REQUEST_ID;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Commons.FIELD;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Commons.FINISHED;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Commons.INIT;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Commons.MSN_FILED_DATE_ISO_8601_ERROR;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Commons.MSN_HEADER_NON_PRESENT;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Commons.REQUEST_ID_EXCEEDS;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Constants.FIELD_CHANNEL;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Constants.FIELD_DATE_TIME;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Constants.FIELD_IP_TERMINAL;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Constants.FIELD_RESQUEST_ID;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Constants.FIELD_USER_LOGIN;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Constants.REGEX_DATE_ISO_8601;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuditoriaCanales {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuditoriaCanales.class);
	private ValidateField validateField = new ValidateField();

	public void validateFieldAuditoriaCanales(Header header) throws InputValidationException {

		LOGGER.debug("Invoque method validateFieldAuditoriaCanales: " + INIT);

		if (header == null || header.getHeaders() == null) {
			throw new InputValidationException(MSN_HEADER_NON_PRESENT);
		}

		validateField.validateFieldNull(FIELD_DATE_TIME, Optional.ofNullable(header.getHeaders().getRequest_date_time()));
		validateField.validateRegEx(header.getHeaders().getRequest_date_time(), REGEX_DATE_ISO_8601, MSN_FILED_DATE_ISO_8601_ERROR.replace(FIELD, FIELD_DATE_TIME));

		validateField.validateFieldNull(FIELD_CHANNEL, Optional.ofNullable(header.getHeaders().getChannel()));

		validateField.validateFieldNull(FIELD_RESQUEST_ID, Optional.ofNullable(header.getHeaders().getRequest_id()));
		validateField.validateSize(header.getHeaders().getRequest_id(), CARACTER_REQUEST_ID, REQUEST_ID_EXCEEDS);

		validateField.validateFieldNull(FIELD_IP_TERMINAL, Optional.ofNullable(header.getHeaders().getIp_terminal()));
		validateField.validateFieldIp(FIELD_IP_TERMINAL, header.getHeaders().getIp_terminal());

		validateField.validateFieldNull(FIELD_USER_LOGIN, Optional.ofNullable(header.getHeaders().getUser_login()));
		
		LOGGER.debug("Invoque method validateFieldAuditoriaCanales: " + FINISHED);
	}

}
