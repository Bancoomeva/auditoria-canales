package com.co.bancoomeva.auditoria.auditoria_canales.model;

public class FieldAuditoriaCanales {

	private String messageId;
	private String invokerDateTime;
	private String ipTransaccion;
	private String codTransaccion;
	private String canal;
	private String usuario;
	private String action;

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getInvokerDateTime() {
		return invokerDateTime;
	}

	public void setInvokerDateTime(String invokerDateTime) {
		this.invokerDateTime = invokerDateTime;
	}

	public String getIpTransaccion() {
		return ipTransaccion;
	}

	public void setIpTransaccion(String ipTransaccion) {
		this.ipTransaccion = ipTransaccion;
	}

	public String getCodTransaccion() {
		return codTransaccion;
	}

	public void setCodTransaccion(String codTransaccion) {
		this.codTransaccion = codTransaccion;
	}

	public String getCanal() {
		return canal;
	}

	public void setCanal(String canal) {
		this.canal = canal;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Override
	public String toString() {
		return "FieldAuditoria [messageId=" + messageId + ", invokerDateTime=" + invokerDateTime + ", ipTransaccion="
				+ ipTransaccion + ", codTransaccion=" + codTransaccion + ", canal=" + canal + ", usuario=" + usuario
				+ ", action=" + action + "]";
	}

}
