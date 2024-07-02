package com.co.bancoomeva.auditoria.auditoria_canales;

import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Constants.FIELD;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Constants.FIELD_MESSAGE_ID;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Constants.MSN_FIELD_ERROR;

import java.util.Optional;

import com.co.bancoomeva.auditoria.auditoria_canales.exceptio.InputValidationException;
import com.co.bancoomeva.auditoria.auditoria_canales.model.FieldAuditoriaCanales;

public class ValidateField {

	public void validateFieldAuditoriaCanales(FieldAuditoriaCanales auditoriaCanales) throws InputValidationException {
			
		validateFieldNull(FIELD_MESSAGE_ID, Optional.ofNullable(auditoriaCanales.getMessageId()));
		validateFieldNull("invokerDateTime", Optional.ofNullable(auditoriaCanales.getInvokerDateTime()));
		validateFieldNull("ipTransaccion", Optional.ofNullable(auditoriaCanales.getIpTransaccion()));
		validateFieldNull("codTransaccion", Optional.ofNullable(auditoriaCanales.getCodTransaccion()));
		validateFieldNull("canal", Optional.ofNullable(auditoriaCanales.getCanal()));
		validateFieldNull("usuario", Optional.ofNullable(auditoriaCanales.getUsuario()));		
	
	}

	public void validateFieldNull(String date, Optional<String> value) throws InputValidationException {
		if (value.isEmpty()) {
			throw new InputValidationException(MSN_FIELD_ERROR.replace(FIELD, date));
		}
	}

}
