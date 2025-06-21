package org.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static final Properties prop = new Properties();

    static {
//        try (InputStream input = configReader.class
//                .getClassLoader()
//                .getResourceAsStream("config.properties")) {
//
//            if (input == null)
//                throw new RuntimeException("config.properties not found");
        String configFilePath = System.getProperty("user.dir") + "/src/main/resources/config.properties";

        try(FileInputStream fis = new FileInputStream(configFilePath)){
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Error loading properties", e);
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }

    public static int getInt(String key) {
        return Integer.parseInt(get(key));
    }

    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(get(key));
    }
}
