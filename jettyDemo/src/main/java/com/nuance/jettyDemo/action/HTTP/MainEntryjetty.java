package com.nuance.jettyDemo.action.HTTP;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainEntryjetty {
    private static Logger logger = LogManager.getLogger(MainEntryjetty.class);

    public static Properties prop = null;
    static Map<Integer, String> map = new HashMap<>();

    public MainEntryjetty() {
        InputStream is = null;

        try {

            this.prop = new Properties();

            map.put(1,
                    "{\r\n" + "    \"TransactionId\" :\"123\",\r\n" + "    \"Msisdn\" : \"9871398646\",\r\n"
                            + "    \"KPI\" : {\"Bundle Expiry\":\"21-06-18\",\"OG\":\"24-06-18\"},\r\n"
                            + "    \"Status\" : \"Success\"\r\n" + "}");

            map.put(2,
                    "{\r\n" + "    \"TransactionId\" :\"123\",\r\n" + "    \"Msisdn\" : \"9871398646\",\r\n"
                            + "    \"KPI\" : {\"Bundle Expiry\":\"21-06-18\",\"OG\":\"25-06-18\"},\r\n"
                            + "    \"Status\" : \"Success\"\r\n" + "}");

            map.put(3,
                    "{\r\n" + "    \"TransactionId\" :\"123\",\r\n" + "    \"Msisdn\" : \"9871398646\",\r\n"
                            + "    \"KPI\" : {\"Bundle Expiry\":\"21-06-18\",\"OG\":\"26-06-18\"},\r\n"
                            + "    \"Status\" : \"Success\"\r\n" + "}");

            map.put(4,
                    "{\r\n" + "    \"TransactionId\" :\"123\",\r\n" + "    \"Msisdn\" : \"9871398646\",\r\n"
                            + "    \"KPI\" : {\"Bundle Expiry\":\"25-06-18\",\"OG\":\"26-06-18\"},\r\n"
                            + "    \"Status\" : \"Success\"\r\n" + "}");

            map.put(5,
                    "{\r\n" + "    \"TransactionId\" :\"123\",\r\n" + "    \"Msisdn\" : \"9871398646\",\r\n"
                            + "    \"KPI\" : {\"Bundle Expiry\":\"21-06-18\"},\r\n" + "    \"Status\" : \"Success\"\r\n"
                            + "}\r\n" + "");

            map.put(6, "{\r\n" + "    \"TransactionId\" :\"123\",\r\n" + "    \"Msisdn\" : \"9871398646\",\r\n"
                    + "    \"KPI\" : {\"OG\":\"14-06-18\"},\r\n" + "    \"Status\" : \"Success\"\r\n" + "}\r\n" + "");

            map.put(7, "{\r\n" + "    \"TransactionId\" :\"123\",\r\n" + "    \"Msisdn\" : \"9871398646\",\r\n"
                    + "    \"Status\" : \"NOT FOUND\"\r\n" + "}\r\n" + "");

            map.put(8, "{\r\n" + "    \"TransactionId\" :\"123\",\r\n" + "    \"Msisdn\" : \"9871398646\",\r\n"
                    + "    \"Status\" : \"NOT EXIST\"\r\n" + "}\r\n" + "");

            is = this.getClass().getResourceAsStream("/demo.properties");
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

        MainEntryjetty mainObject = new MainEntryjetty();
        new Config().loadConfig();
        logger.info("configuration loading completed");

        if (Config.getPort() > 0) {
            logger.info("Starting HTTP receiver to receieve request");
            HTTPStartServer.StartJettyServer(Config.getPort());
            logger.info("HTTP receiver to receive GET request is started now.");

        }

    }
}
