package com.nuance.jettyDemo.action.HTTP;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Config {

	private static Logger logger = LogManager.getLogger(Config.class);

	private static int port;
	private static String xmlRessponse;

	public static Map<String, String> commonTagMap = null;

	public void loadConfig() {

		try {

			port = Integer.parseInt(MainEntryjetty.getPropertyValue("http.port"));
			xmlRessponse = MainEntryjetty.getPropertyValue("http.xml.response");

		} catch (Exception e) {
			logger.error("Exception while loading configuration " + e.getMessage());
			System.exit(0);
		}
	}

	public static int getPort() {
		return port;
	}

	public static String getXmlRessponse() {
		return xmlRessponse;
	}

}
