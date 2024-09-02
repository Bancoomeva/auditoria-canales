package com.co.bancoomeva.auditoria.auditoria_canales.model;

public class StatusResponse {

	private Status status;

	public StatusResponse(Status status) {
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "StatusResponse [status=" + status + "]";
	}

}
