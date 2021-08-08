package cx.en.oq.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private static PropertiesReader instance = null;
    private Properties properties;

    private PropertiesReader(){
        properties = new Properties();
        try {
            properties.load(new FileReader("src/test/resources/app.properties"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private PropertiesReader(String propertyFileName){
        properties = new Properties();
        try {
            properties.load(new FileReader("src/test/resources/" + propertyFileName));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static PropertiesReader getInstance(){
        if (instance == null){
            instance = new PropertiesReader();
        }
        return instance;
    }

    public static PropertiesReader getInstance(String propertyFileName){
        if (instance == null){
            instance = new PropertiesReader(propertyFileName);
        }
        return instance;
    }

    public String getPropertyByName(String name){
        return properties.getProperty(name);
    }
}
