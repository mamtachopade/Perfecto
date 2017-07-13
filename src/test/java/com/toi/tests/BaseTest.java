package com.toi.tests;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.RemoteExecuteMethod;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.demo.PerfectoUtilities;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebDriver;

public class BaseTest {
	QAFWebDriver driver;

	@BeforeMethod
	public void startUp() {
		System.out.println(ConfigurationManager.getBundle().getProperty("driver.name"));
		driver = new WebDriverTestBase().getDriver();
		PerfectoUtilities.closeApplication("TOI");
		PerfectoUtilities.openApplication("TOI");
		RemoteExecuteMethod executeMethod = new RemoteExecuteMethod((RemoteWebDriver) driver);
		Map<String, String> params = new HashMap<String, String>();
		params.put("name", "NATIVE");
		executeMethod.execute(DriverCommand.SWITCH_TO_CONTEXT, params);

	}

	@AfterMethod
	public void quitApplication() {
		driver.quit();
	}

}
