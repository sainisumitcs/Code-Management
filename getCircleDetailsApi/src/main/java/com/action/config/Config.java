package com.action.config;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.action.http.GetUserInfo;

public class Config {

	private static Logger logger = LogManager.getLogger(Config.class);

	private static int port;
	private static int reciveTimeOut;
	private static String processIp;
	private static int mnpProcessPort;
	private static String mnpProcessIP;
	private static String origionUri;
	

	
	public static String getProcessIp() {
		return processIp;
	}

	public static void setProcessIp(String processIp) {
		Config.processIp = processIp;
	}

	public static String getOrigionUri() {
		return origionUri;
	}

	public static void setOrigionUri(String origionUri) {
		Config.origionUri = origionUri;
	}

	public static Map<String, String> commonTagMap = null;

	public void loadConfig() {

		try {
			port 			= Integer.parseInt(GetUserInfo.getPropertyValue("http.port"));
			reciveTimeOut	=  Integer.parseInt(GetUserInfo.getPropertyValue("reciveTimeOut"));
			mnpProcessPort	=  Integer.parseInt(GetUserInfo.getPropertyValue("mnpProcessPort"));
			processIp		=  GetUserInfo.getPropertyValue("processIp");
			mnpProcessIP		=  GetUserInfo.getPropertyValue("mnpProcessIP");
			origionUri		=  GetUserInfo.getPropertyValue("origionUri");
				
		} catch (Exception e) {
			logger.error("Exception while loading configuration " + e.getMessage());
			System.exit(0);
		}
	}

	public static int getMnpProcessPort() {
		return mnpProcessPort;
	}

	public static String getMnpProcessIP() {
		return mnpProcessIP;
	}

	public static void setMnpProcessIP(String mnpProcessIP) {
		Config.mnpProcessIP = mnpProcessIP;
	}

	public static void setMnpProcessPort(int mnpProcessPort) {
		Config.mnpProcessPort = mnpProcessPort;
	}

	public static void setPort(int port) {
		Config.port = port;
	}

	public static int getPort() {
		return port;
	}

	public static int getReciveTimeOut() {
		return reciveTimeOut;
	}

	public static void setReciveTimeOut(int reciveTimeOut) {
		Config.reciveTimeOut = reciveTimeOut;
	}


}
