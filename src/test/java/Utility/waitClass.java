package Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.baseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class waitClass {
	//public static AndroidDriver<MobileElement> driver;
	 public int timeout = 0;
	 public static final long Wait = 10;

	public static void waitForElement(AndroidDriver<MobileElement> driver, AndroidElement element) {
		//new WebDriverWait(driver, 20000).until(ExpectedConditions.elementToBeClickable(element));
		WebDriverWait wait = new WebDriverWait(driver, 30000);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	 public void waitForVisibilityAndroid(AndroidDriver<MobileElement> driver, MobileElement e) {
	        WebDriverWait wait = new WebDriverWait(driver, Wait);
	        wait.until(ExpectedConditions.visibilityOf(e));

	    }
	

     
	    public void implicitWait(AndroidDriver<MobileElement> driver, int timeout) {
	        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.MILLISECONDS);
	    }

}
