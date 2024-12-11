package cf.nbfc.util;

import cf.nbfc.constants.IConstants;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtil {

    public static Properties properties;

    public static String getPropertyValue(String configFilePath,String key) {
        String keyValue = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(configFilePath);
            properties = new Properties();
            properties.load(fileInputStream);
            keyValue = properties.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return keyValue;
    }


}
