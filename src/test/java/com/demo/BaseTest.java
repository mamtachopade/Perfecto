package com.demo;

import org.testng.annotations.Test;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebDriver;

public class BaseTest  {

	@Test
	public void test() {
		System.out.println(ConfigurationManager.getBundle().getProperty("driver.name"));
		QAFWebDriver driver = new WebDriverTestBase().getDriver();
		PerfectoUtilities.openApplication("TOI");
		driver.quit();
	}

}
