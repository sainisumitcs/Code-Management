package com.action.http;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.action.config.Config;

public class GetUserInfo {
    private static Logger logger = LogManager.getLogger(GetUserInfo.class);

    public static Properties prop = null;
    
    
    public GetUserInfo(String configFile) {
        InputStream is = null;

        try {

        	logger.error("Config File before"+configFile);
            this.prop = new Properties();
            //is = this.getClass().getResourceAsStream("/conf.properties");
            //is = getClass().getClassLoader().getResourceAsStream(configFile);
            is = new FileInputStream(configFile);
            prop.load(is);
        } catch (FileNotFoundException e) {
            logger.error("Exception while loading config file " + e.getMessage());
        } catch (IOException e) {
            logger.error("Exception while loading config file " + e.getMessage());
        }
    }

    public static String getPropertyValue(String key) {
        return prop.getProperty(key);
    }

    public static void main(String[] args) throws Exception {

        logger.info("application started.......");
        String configFile = "/conf.properties";

        if (args.length >= 1)
            configFile = args[0];
       
        logger.info("Config File"+configFile);
        
        GetUserInfo mainObject = new GetUserInfo(configFile);
        new Config().loadConfig();
        logger.info("configuration loading completed");

        if (Config.getPort() > 0) {
            logger.info("Starting HTTP receiver to receieve request");
            HTTPStartServer.StartJettyServer(Config.getPort());
            logger.info("HTTP receiver to receive GET request is started now.");

        }

    }
}
