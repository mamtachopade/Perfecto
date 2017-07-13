package toiassignment.toi_assignment;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



/**
 * author : tapas.padhi
 */
public class TOIAppTest extends TOIAppiumTest {
	
	@Override
	@BeforeTest
	public void beforeMethod() throws MalformedURLException {
		super.beforeMethod();
	}

	@Override
	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		
	}
	
	@Test
	public void test(){
		System.out.println("Done");
	}
}
 