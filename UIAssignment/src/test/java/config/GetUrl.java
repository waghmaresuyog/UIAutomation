package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetUrl {

    public static Properties getProperties() {
        Properties properties = new Properties();
        try {
            FileInputStream file = new FileInputStream("src/test/java/config/zooplaURL.properties");
            properties.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

    public static String commonUrl() {
        String commonUrl = getProperties().getProperty("Url");
        return commonUrl;
    }
}
