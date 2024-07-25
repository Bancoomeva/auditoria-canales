package com.co.bancoomeva.auditoria.auditoria_canales.model.auditoria;

public class Header {

	private HeadersAuditoria headers;

	public HeadersAuditoria getHeaders() {
		return headers;
	}

	public void setHeaders(HeadersAuditoria headers) {
		this.headers = headers;
	}

	@Override
	public String toString() {
		return "Header [headers=" + headers + "]";
	}

}
