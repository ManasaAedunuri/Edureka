package com.parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	private static Properties config;

    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/PropertiesFile/careers.properties");
            config = new Properties();
            config.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        return config.getProperty(key);
    }
    
    

}
