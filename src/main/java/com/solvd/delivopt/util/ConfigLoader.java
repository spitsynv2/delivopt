package com.solvd.delivopt.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-12
 */
public class ConfigLoader {

    private static final Logger log = LogManager.getLogger(ConfigLoader.class);
    private static final Properties properties = new Properties();

    private ConfigLoader() {}

    static {
        try (InputStream inputStream = ConfigLoader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (inputStream == null) {
                log.error("config.properties file not found.");
                throw new RuntimeException("config.properties file not found.");
            }
            properties.load(inputStream);
        } catch (IOException e) {
            log.error("Error loading config.properties", e);
            throw new RuntimeException("Error loading config.properties", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
