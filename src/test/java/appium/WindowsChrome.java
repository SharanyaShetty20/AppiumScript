package appium;

import java.net.URL;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;

public class WindowsChrome {
	public static AndroidDriver<WebElement> driver;
	public static final String USERNAME = "oauth-sharanya-17f2a";
	public static final String ACCESS_KEY = "fdec31ea-d69e-4c93-945a-b590f2c35d19";
	public static final String URL = "https://"+USERNAME+":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
	//public static IOSDriver<WebElement> driver;

	@BeforeTest
	public static void setup() throws Exception{

		/*ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 8");
		browserOptions.setBrowserVersion("latest");
		Map<String, Object> sauceOptions = new HashMap<String, Object>();
		sauceOptions.put("build", "<your build id>");
		sauceOptions.put("name", "<your test name>");
		browserOptions.setCapability("sauce:options", sauceOptions);

		URL url = new URL("https://oauth-sharanya-17f2a:fdec31ea-d69e-4c93-945a-b590f2c35d19@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);*/

		MutableCapabilities caps = new MutableCapabilities();
		caps.setCapability("platformName", "Windows 8");
		//caps.setCapability("appium:app", "storage:filename=mda-1.0.16-19.apk");
		//caps.setCapability("appium:deviceName", "Samsung.*");
		caps.setCapability("appium:automationName", "UiAutomator2");
		MutableCapabilities sauceOptions = new MutableCapabilities();
		sauceOptions.setCapability("build", "build-4");
		sauceOptions.setCapability("name", "Desktop Automation Windows - Chrome");
		caps.setCapability("sauce:options", sauceOptions);

		URL url = new URL("https://oauth-sharanya-17f2a:fdec31ea-d69e-4c93-945a-b590f2c35d19@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
		driver = new AndroidDriver<WebElement>(url, caps);

		caps.setCapability("noReset", true);
		System.out.println("Application started....");
	}

	@Test
	public static void MobileiOS() throws Exception{
		Thread.sleep(1000);
	}

	@AfterTest
	public void aftertest() {
		driver.quit();
	}
}
