package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {

    private static String filePath ="src/main/resources/config.properties";

    public static String readProperty(String key) throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(filePath);
        prop.load(fis);
        fis.close();
        return prop.getProperty(key);
    }


    public static void writeProperty(String key, String value) throws IOException {

           
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(filePath);
        prop.load(fis);
        fis.close();
        prop.setProperty(key, value);
        FileOutputStream fos = new FileOutputStream(filePath);
        prop.store(fos, "Updated Test Result");
        fos.close();
    }
}
