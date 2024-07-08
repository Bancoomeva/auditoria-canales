package com.co.bancoomeva.auditoria.auditoria_canales.exceptio;

import java.util.List;

public class UnauthorizedException extends Exception {

	private static final long serialVersionUID = -1606736426457863046L;

	private List<String> errorMessageList;

	public UnauthorizedException(String shortMessage) {
		super(shortMessage);
	}

	public UnauthorizedException(String shortMessage, List<String> errorMessageList) {
		super(shortMessage);
		this.errorMessageList = errorMessageList;
	}

	public List<String> getErrorMessageList() {
		return errorMessageList;
	}

}
