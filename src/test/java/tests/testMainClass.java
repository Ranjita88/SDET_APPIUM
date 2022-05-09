package tests;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.baseClass;
import extendReport.logger_Class;
import pages.addItemPage;
import pages.mainPage;
import pages.removeItem;

public class testMainClass extends baseClass {

	@BeforeMethod
	public void beforeMethod(Method m) {
		mainPage mp = new mainPage(driver);
		System.out.println("\n" + "--Starting Test:" + m.getName() + "---" + "\n");

	}

	@Test
	public void testFirst() throws Exception {
		mainPage mp = new mainPage(driver);
		mp.goToTheme(driver);
		Assert.assertTrue(true);
	}

	

}
