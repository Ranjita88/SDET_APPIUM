package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import core.baseClass;
import Utility.*;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class mainPage {
	//AndroidDriver<MobileElement> driver;
	waitClass wait;
	AndroidDriver<MobileElement> driver;

	public mainPage(AndroidDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
	}

	public void goToTheme(AndroidDriver<MobileElement> driver) throws Exception {
		if (btnWelcome.isDisplayed()) {
			btnWelcome.click();
			txtSearchFirst.click();
			txtSearchFirst.sendKeys("American Dream, American Dream Way, East Rutherford, NJ");
			//Thread.sleep(20000);
			wait.waitForElement(driver, entertext);
			Thread.sleep(2000);
			entertext.click();
			//Thread.sleep(2000);
		} else {
			btnSearchNearBy.sendKeys("American Dream, American Dream Way, East Rutherford, NJ");
			selectOption.click();
		}
	}

	@AndroidFindBy(id = "com.grubhub.android:id/welcome_button")
	private AndroidElement btnWelcome;
	@AndroidFindBy(id = "com.grubhub.android:id/address_bar")
	private AndroidElement txtSearchFirst;
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[@content-desc='Search At Current Location Button']")
	private AndroidElement entertext;
	@AndroidFindBy(id = "com.grubhub.android:id/search_address_input_fused")
	private AndroidElement btnSearchNearBy;
	@AndroidFindBy(xpath = "//*[@resource-id='com.grubhub.android:id/home_content_frame']//*[@class='android.view.ViewGroup'][1]")
	private AndroidElement selectOption;

}
