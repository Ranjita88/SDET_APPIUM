package Utility;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class commonMethods {
	//WebDriver driver;
	waitClass wait;
	
	public void scrollToElement(int l1, int l2, int l3, int l4, AndroidDriver driver){
		TouchAction action = new TouchAction(driver);
		action.longPress(LongPressOptions.longPressOptions().withPosition(new PointOption()
		.withCoordinates(l1, l2)))
		.moveTo(new PointOption().withCoordinates(l3, l4)).release().perform();
	}
	
	public void dragDrop(MobileElement dragEle, MobileElement dropEle, AndroidDriver driver){
		new AndroidTouchAction(driver).longPress(LongPressOptions.longPressOptions()
				.withElement(ElementOption.element(dragEle))).moveTo(ElementOption.element(dropEle))
		.release().perform();
	}
	
	public void clickToElement(AndroidElement ele){
		//wait.waitForVisibilityAndroid(ele);
		ele.click();
	}
	
	public String returnDataFromFile(String val, String path) throws Exception {
		FileInputStream fileInput = new FileInputStream(System.getProperty("user.dir") + path);
		Properties prop = new Properties();
		prop.load(fileInput);
		return prop.getProperty(val);
	}
	
	public String returnValueFromFile(String app) throws Exception {
		String url = returnDataFromFile(app, "\\data.properties");
		System.out.println("url=======> "+url);
		return url;
	}

}
