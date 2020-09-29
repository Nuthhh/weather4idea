package com.ohow.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertyUtil {

    private static final Logger logger = LoggerFactory.getLogger(PropertyUtil.class);
    private static Properties properties;

    static {
        try (InputStream inputStream = PropertyUtil.class.getClassLoader().getResourceAsStream("weather.properties");
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        ) {
            properties = new Properties();
            properties.load(inputStreamReader);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public static String getString(String key, String defaultVal) {
        String value = properties.getProperty(key);
        if (isNotEmpty(value)) {
            return value;
        }
        return defaultVal;
    }

    public static int getInt(String key, int defaultVal) {
        String value = getString(key, null);
        if (isNotEmpty(value)) {
            try {
                return Integer.parseInt(key);
            } catch (NumberFormatException e) {
                return defaultVal;
            }
        }
        return defaultVal;
    }


    private static boolean isNotEmpty(String str) {
        return str != null && !str.isEmpty();
    }


}
