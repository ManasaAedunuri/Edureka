package com.parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    // Reads data from properties file without creating object
    public static Properties readProperty() {
        Properties prop = new Properties();
        String fileName = System.getProperty("user.dir") + "\\src\\test\\resources\\PropertiesFile\\discover_top_categories.properties";

        try (FileInputStream fis = new FileInputStream(fileName)) {
            prop.load(fis);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}