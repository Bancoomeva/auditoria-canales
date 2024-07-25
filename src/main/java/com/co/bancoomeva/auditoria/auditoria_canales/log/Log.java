package com.co.bancoomeva.auditoria.auditoria_canales.log;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.co.bancoomeva.auditoria.auditoria_canales.model.Header;
import com.co.bancoomeva.auditoria.auditoria_canales.model.log.LogTransaction;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Commons.FINISHED;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Commons.INFO;
import static com.co.bancoomeva.auditoria.auditoria_canales.constants.Commons.INIT;

public class Log {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Log.class);
	private static Gson Gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();

	public static String generateLog(APIGatewayProxyRequestEvent apiGatewayProxyRequestEvent, Context context, String message, String application) {

		LOGGER.debug("Invoque method generateLog: " + INIT);
		
		Header header = Gson.fromJson(apiGatewayProxyRequestEvent.getBody(), Header.class);

		LogTransaction logTransaction = new LogTransaction(new Timestamp(System.currentTimeMillis()), INFO, message,
				context.getAwsRequestId(), application, header.getHeaders().getUser_login(),
				header.getHeaders().getIp_terminal(), null);

		String log = Gson.toJson(logTransaction, LogTransaction.class);

		LOGGER.debug("Invoque method generateLog: " + FINISHED);
		
		return log;
	}

}
