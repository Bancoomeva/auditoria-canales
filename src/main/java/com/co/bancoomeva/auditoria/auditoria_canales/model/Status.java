package com.co.bancoomeva.auditoria.auditoria_canales.model;

import com.co.bancoomeva.auditoria.auditoria_canales.constants.Severity;

public class Status {

	private Severity severity;
	private String statusDesc;
	private String request_id;

	public Status(Severity severity, String statusDesc, String request_id) {
		this.severity = severity;
		this.statusDesc = statusDesc;
		this.request_id = request_id;
	}

	public Severity getSeverity() {
		return severity;
	}

	public void setSeverity(Severity severity) {
		this.severity = severity;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public String getRequest_id() {
		return request_id;
	}

	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}

	@Override
	public String toString() {
		return "Status [severity=" + severity + ", statusDesc=" + statusDesc + ", request_id=" + request_id + "]";
	}

}
