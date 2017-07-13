package toiassignment.toi_assignment;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

public class TOIAppiumTest {

	
	RemoteWebDriver driver;
	
	@BeforeTest
	public void beforeMethod() throws MalformedURLException {
		
//		String appPackage = "com.toi.reader.activities";
//		String appActivity = "com.toi.reader.activities.NavigationFragmentActivity";
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "Samsung Note");
		capabilities.setCapability("platformVersion", "5.1.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.toi.reader.activities");
		capabilities.setCapability("appActivity", "com.toi.reader.activities.NavigationFragmentActivity");
		capabilities.setCapability("noReset", "true");
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
//		driver.startActivity(appPackage, appActivity);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
		
	}
}
