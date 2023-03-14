package appium;

import java.net.URL;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.ios.IOSDriver;

public class MobileTestiOS {
	//public static AndroidDriver<WebElement> driver;
	//public static final String USERNAME = "oauth-sharanya-17f2a";
	//public static final String ACCESS_KEY = "fdec31ea-d69e-4c93-945a-b590f2c35d19";
	//public static final String URL = "https://"+USERNAME+":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
	public static final String USERNAME = "oauth-sharanyashetty04-38ed4";
	public static final String ACCESS_KEY = "3a2df9ef-1172-477f-8146-abd99fc41915";
	public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
	public static IOSDriver<WebElement> driver;
	
	@BeforeTest
	public static void setup() throws Exception{
		
		MutableCapabilities caps = new MutableCapabilities();
		caps.setCapability("platformName", "iOS");
		caps.setCapability("appium:app", "storage:filename=SauceLabs-Demo-App.ipa");
		caps.setCapability("appium:deviceName", "iPhone.*");
		caps.setCapability("appium:automationName", "XCUITest");
		MutableCapabilities sauceOptions = new MutableCapabilities();
		sauceOptions.setCapability("build", "build-1234");
		sauceOptions.setCapability("name", "Mobile Testing in iOS");
		caps.setCapability("sauce:options", sauceOptions);

		//URL url = new URL("https://oauth-sharanya-17f2a:fdec31ea-d69e-4c93-945a-b590f2c35d19@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
		URL url = new URL("https://oauth-sharanyashetty04-38ed4:3a2df9ef-1172-477f-8146-abd99fc41915@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
		
		driver = new IOSDriver<WebElement>(url, caps);
		
		caps.setCapability("noReset", true);
		System.out.println("Application started....");
		//Thread.sleep(3000);
	}
	
	@Test
	public static void MobileiOS() throws Exception{
		Thread.sleep(2000);
	}
	
	@AfterTest
	public void aftertest() {
		driver.quit();
	}
}
