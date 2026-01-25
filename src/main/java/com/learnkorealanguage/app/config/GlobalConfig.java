package com.learnkorealanguage.app.config;

import com.learnkorealanguage.app.ultil.GlobalException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GlobalConfig {
    private final static Properties properties = new Properties();
    private static final String PATH = "/com/learnkorealanguage/app/application.properties";
    static  {
         try (InputStream inputStream = GlobalConfig.class.getResourceAsStream(PATH)) {
             properties.load(inputStream);
         } catch (IOException ioe){
             System.out.println(ioe.getMessage());
         }
    }
    public static String getProperties(String key){
        return properties.getProperty(key);
    }
}
