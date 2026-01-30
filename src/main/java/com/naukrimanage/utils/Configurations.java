package com.naukrimanage.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configurations {
    public static Properties properties;
    private static FileInputStream fileInputStream;
    private static String propertiesFile = System.getProperty("user.dir")+File.separator+"config.properties";

    

    public static void loadProperties()
    {
        try{
        fileInputStream = new FileInputStream(propertiesFile);
        properties = new Properties();
        properties.load(fileInputStream);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
