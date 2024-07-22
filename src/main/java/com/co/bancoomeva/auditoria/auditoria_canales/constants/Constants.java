package com.co.bancoomeva.auditoria.auditoria_canales.constants;

public class Constants {
 	 
	 public static final String FIELD_DATE_TIME = "request-date-time";
	 public static final String FIELD_RESQUEST_ID =  "request-id";
	 public static final String FIELD_IP_TERMINAL  = "ip-terminal";
	 public static final String FIELD_COD_TRANSACTION =   "codTransaccion";
	 public static final String FIELD_CHANNEL = "channel";
	 public static final String FIELD_USER_LOGIN = "user-login";
	 
	 public static final String REGEX_POSITIVE_NUMBER = "\\d*\\.?\\d+";
	 public static final String REGEX_IP_V4 = "^((25[0-5]|2[0-4][0-9]|[0-1]?[0-9][0-9]?)(\\.|\\b)){4}$"; 	 
	 public static final String REGEX_IP_V6 = "(([0-9a-fA-F]{1,4}:){7,7}[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,7}:|([0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,5}(:[0-9a-fA-F]{1,4}){1,2}|([0-9a-fA-F]{1,4}:){1,4}(:[0-9a-fA-F]{1,4}){1,3}|([0-9a-fA-F]{1,4}:){1,3}(:[0-9a-fA-F]{1,4}){1,4}|([0-9a-fA-F]{1,4}:){1,2}(:[0-9a-fA-F]{1,4}){1,5}|[0-9a-fA-F]{1,4}:((:[0-9a-fA-F]{1,4}){1,6})|:((:[0-9a-fA-F]{1,4}){1,7}|:)|fe80:(:[0-9a-fA-F]{0,4}){0,4}%[0-9a-zA-Z]{1,}|::(ffff(:0{1,4}){0,1}:){0,1}((25[0-5]|(2[0-4]|1{0,1}[0-9])?[0-9])\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9])?[0-9])|([0-9a-fA-F]{1,4}:){1,4}:((25[0-5]|(2[0-4]|1{0,1}[0-9])?[0-9])\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9])?[0-9]))";
	 public static final String REGEX_URL = "^(http|https)://([a-zA-Z0-9]+\\.)+[a-zA-Z]{2,}(/{0,1}[^\\s]*)?$"; 
	 public static final String REGEX_DATE_ISO_8601 = "^\\d{4}-\\d{2}-\\d{2}" + "T\\d{2}:\\d{2}:\\d{2}" + "(\\.\\d{1,3})?" + "(Z|[+-]\\d{2}:\\d{2})?$";
}
