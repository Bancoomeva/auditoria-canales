package com.co.bancoomeva.auditoria.auditoria_canales.model.log;

import com.co.bancoomeva.auditoria.auditoria_canales.model.HeadersAuditoria;

public class DetailsTransacction {

	private HeadersAuditoria headers;
	private String contexto;
	private String httpMethod;
	private String body;

	public HeadersAuditoria getHeaders() {
		return headers;
	}

	public void setHeaders(HeadersAuditoria headers) {
		this.headers = headers;
	}

	public String getContexto() {
		return contexto;
	}

	public void setContexto(String contexto) {
		this.contexto = contexto;
	}

	public String getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "DetailsTransacction [headers=" + headers + ", contexto=" + contexto + ", httpMethod=" + httpMethod
				+ ", body=" + body + "]";
	}

}
