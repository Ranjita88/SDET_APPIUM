package core;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.stream.Stream;

import org.testng.annotations.DataProvider;


public class getDevice {
	
	@DataProvider(name = "dev")
	public String returnDataFromFile(String val) throws Exception {
		FileInputStream fileInput = new FileInputStream(System.getProperty("user.dir") + "//device.properties");
		Properties prop = new Properties();
		prop.load(fileInput);
		return prop.getProperty("device");
	}

}
