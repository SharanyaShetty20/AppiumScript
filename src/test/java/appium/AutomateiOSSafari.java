package appium;

import java.net.URL;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.ios.IOSDriver;

public class AutomateiOSSafari {
	//public static AndroidDriver<WebElement> driver;
	public static final String USERNAME = "oauth-sharanya-17f2a";
	public static final String ACCESS_KEY = "fdec31ea-d69e-4c93-945a-b590f2c35d19";
	public static final String URL = "https://"+USERNAME+":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
	public static IOSDriver<WebElement> driver;
	
	@BeforeTest
	public static void setup() throws Exception{
		
		MutableCapabilities caps = new MutableCapabilities();
		caps.setCapability("platformName", "iOS");
		caps.setCapability("browserName", "Safari");
		caps.setCapability("appium:deviceName", "iPhone XR");
		caps.setCapability("appium:platformVersion", "16");
		caps.setCapability("appium:automationName", "XCUITest");
		MutableCapabilities sauceOptions = new MutableCapabilities();
		sauceOptions.setCapability("build", "build-3");
		sauceOptions.setCapability("name", "Safari in iOS");
		caps.setCapability("sauce:options", sauceOptions);

		URL url = new URL("https://oauth-sharanya-17f2a:fdec31ea-d69e-4c93-945a-b590f2c35d19@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
		driver = new IOSDriver<WebElement>(url, caps);
		
		caps.setCapability("noReset", true);
		System.out.println("Application started....");
		//Thread.sleep(3000);
	}
	
	@Test
	public static void MobileiOS() throws Exception{
		driver.get("https://saucedemo.com");
		Thread.sleep(1000);
	}
	
	@AfterTest
	public void aftertest() {
		driver.quit();
	}
}
