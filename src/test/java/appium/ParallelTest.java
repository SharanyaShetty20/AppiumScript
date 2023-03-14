package appium;

import java.net.URL;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;

public class ParallelTest {

	private static ThreadLocal<AndroidDriver> androidDriver = new ThreadLocal<AndroidDriver>();
	public static final String USERNAME = "oauth-sharanyashetty04-38ed4";
	public static final String ACCESS_KEY = "3a2df9ef-1172-477f-8146-abd99fc41915";
	public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

	@BeforeTest
	public static void setup() throws Exception {
		MutableCapabilities caps = new MutableCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("appium:app", "storage:filename=mda-1.0.16-19.apk");
		caps.setCapability("appium:deviceName", "Android GoogleAPI Emulator");
		caps.setCapability("appium:automationName", "UiAutomator2");
		MutableCapabilities sauceOptions = new MutableCapabilities();
		sauceOptions.setCapability("build", "build-1");
		sauceOptions.setCapability("name", "Uploading APK file to Android");
		caps.setCapability("sauce:options", sauceOptions);

		URL url = new URL("https://oauth-sharanyashetty04-38ed4:3a2df9ef-1172-477f-8146-abd99fc41915@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
		androidDriver.set(new AndroidDriver<WebElement>(url, caps));

		caps.setCapability("noReset", true);
		System.out.println("Application started....");
	}
	
	@Test
	public static void test() throws Exception {
		Thread.sleep(1000);
	}
	
	@Test
	public static void test1() throws Exception {
		Thread.sleep(1000);
	}
}
