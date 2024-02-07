package variables;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class configproperities {
    public static Properties property;
    private static String configpath="Configuration/configsetting.properities";

    public static void initializePropertyFile()
    {
        property=new Properties();
        InputStream instm= null;
        try {
            instm = new FileInputStream(configpath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            property.load(instm);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
