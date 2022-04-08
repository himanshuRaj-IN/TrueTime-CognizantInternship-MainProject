package utilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertiesFile {
	
	
	/******************** Read Properties File ***********************/
	public  Properties readPropertiesFile() {

		Properties prop = new Properties();
		InputStream readFile = null;
		try {
			readFile = new FileInputStream("resources\\config.properties");
			prop.load(readFile);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return prop;
	}

}
