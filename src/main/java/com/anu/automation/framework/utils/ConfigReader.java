package com.anu.automation.framework.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop = new Properties();

    static {
        try {
            InputStream is = ConfigReader.class
                    .getClassLoader()
                    .getResourceAsStream("config/config.properties");

            if (is == null) {
                throw new RuntimeException("config.properties not found in classpath");
            }

            prop.load(is);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String getBrowser() {
        return prop.getProperty("browser");
    }

    public static String getBaseUrl() {
        return prop.getProperty("baseUrl");
    }

    public static int getImplicitWait() {
        return Integer.parseInt(prop.getProperty("implicitWait"));
    }

    public static int getExplicitWait() {
        return Integer.parseInt(prop.getProperty("explicitWait"));
    }

    public static String getUsername() {
        return prop.getProperty("username");
    }

    public static String getPassword() {
        return prop.getProperty("password");
    }
}