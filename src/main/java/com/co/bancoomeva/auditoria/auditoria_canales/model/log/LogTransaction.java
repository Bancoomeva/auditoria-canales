package com.co.bancoomeva.auditoria.auditoria_canales.model.log;

import java.sql.Timestamp;

public class LogTransaction {

	private Timestamp timestamp;
	private String level;
	private String message;
	private String transactionId;
	private String application;
	private String userId;
	private String ip;
	private DetailsTransacction details;

	public LogTransaction(Timestamp timestamp, String level, String message, String transactionId, String application,
			String userId, String ip, DetailsTransacction details) {

		this.timestamp = timestamp;
		this.level = level;
		this.message = message;
		this.transactionId = transactionId;
		this.application = application;
		this.userId = userId;
		this.ip = ip;
		this.details = details;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public DetailsTransacction getDetails() {
		return details;
	}

	public void setDetails(DetailsTransacction details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "LogTransaction [timestamp=" + timestamp + ", level=" + level + ", message=" + message
				+ ", transactionId=" + transactionId + ", application=" + application + ", userId=" + userId + ", ip="
				+ ip + ", details=" + details + "]";
	}

}
