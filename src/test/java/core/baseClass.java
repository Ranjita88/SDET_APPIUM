package core;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.LogStatus;

import Utility.commonMethods;
import Utility.waitClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class baseClass extends commonMethods {
	public AndroidDriver<MobileElement> driver;
	waitClass waitWC = new waitClass();
	public static String userName = "amitjain_3L0ciU";
	public static String accessKey = "h6hwpoJXcSyPyWjZSNXK";

	@Parameters({"deviceName"})
	@BeforeSuite
	public void setUpDriver(String deviceName1) throws Exception {
		System.out.println("----------- "+deviceName1);
		DesiredCapabilities cap = new DesiredCapabilities();
		String appName = returnDataFromFile("apps", "\\data.properties");
		System.out.println("=========>" + appName);
		switch (deviceName1) {
		case "R9ZR5045KNR": 
			URL appiumUrl = new URL("http://127.0.0.1:4723/wd/hub/");
			cap.setCapability("platformName", "Android");
			// cap.setCapability("deviceName", "sdk_gphone_x86");
			cap.setCapability("deviceName", "R9ZR5045KNR");
			cap.setCapability("app", System.getProperty("user.dir") + "\\" + appName);
			driver = new AndroidDriver<MobileElement>(appiumUrl, cap);
			break;
		
		case "sdk_gphone_x86": 
			URL appiumUrl1 = new URL("http://127.0.0.1:4723/wd/hub/");
			cap.setCapability("platformName", "Android");
			cap.setCapability("deviceName", "sdk_gphone_x86");
			cap.setCapability("app", System.getProperty("user.dir") + "\\" + appName);
			driver = new AndroidDriver<MobileElement>(appiumUrl1, cap);
			break;
		

		case "Browser Stack": 
			URL appiumUr2 = new URL("https://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub");
			cap.setCapability("device", "Samsung Galaxy S8 Plus");
			cap.setCapability("os_version", "7.0");
			cap.setCapability("project", "My First Project");
			cap.setCapability("build", "My First Build");
			cap.setCapability("name", "Bstack-[Java] Sample Test");
			cap.setCapability("app", "bs://f1e6610f4f78aaf12e366fcedea81260fba15f40");
			driver = new AndroidDriver<MobileElement>(appiumUr2, cap);
			break;
		

		}

	}

	@AfterSuite
	public void closeDriver() {
		driver.quit();
	}

}
