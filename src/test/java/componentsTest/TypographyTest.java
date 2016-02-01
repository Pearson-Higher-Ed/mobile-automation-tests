package componentsTest;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import com.saucelabs.common.SauceOnDemandAuthentication;

public class TypographyTest {
	IOSDriver driver;
	DesiredCapabilities cap;
	final String USERNAME = System.getenv("SAUCE_USERNAME");
	final String ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");
	SauceOnDemandAuthentication authentication = new SauceOnDemandAuthentication(USERNAME, ACCESS_KEY);
	
	@BeforeTest
	public void setUp() throws MalformedURLException{
		URL sauceUrl = new URL("http://" + authentication.getUsername() + ":"+ authentication.getAccessKey() + "@ondemand.saucelabs.com:80/wd/hub");
		cap=new DesiredCapabilities();
		cap.setCapability("tunnel-identifier", System.getenv("TRAVIS_JOB_NUMBER"));
		cap.setCapability("build", System.getenv("TRAVIS_BUILD_NUMBER"));
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.4");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
		cap.setCapability("appiumVersion", "1.3.4");
		cap.setCapability(CapabilityType.BROWSER_NAME, "safari");
		driver = new IOSDriver(sauceUrl,cap);	
	}
	
	@Test
	public void mobileTest() throws MalformedURLException, InterruptedException{
		driver.get("http://localhost:8000/src/main/java/fixtures/Typography.html");		
	}
	
	@AfterClass
	public void tearDown(){
	    driver.close();
		driver.quit();
	}
}