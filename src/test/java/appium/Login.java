package appium;

import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import debugTest.ScreenshotUtility;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

@Listeners({ ScreenshotUtility.class })
public class Login {

	public static AndroidDriver<WebElement> driver;
	public static final String USERNAME = "oauth-sharanya-17f2a";
	public static final String ACCESS_KEY = "fdec31ea-d69e-4c93-945a-b590f2c35d19";
	public static final String URL = "https://"+USERNAME+":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

	@BeforeTest
	public static void setup() throws Exception{
		/*DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName", "Galaxy J7");
		dc.setCapability("udid", "3300868aa3f4b2f9");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "6.0.1");

		dc.setCapability("appPackage", "com.android.chrome");
		dc.setCapability("appActivity", "com.google.android.apps.chrome.Main");

		//URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<WebElement>(new URL(URL), dc);

		System.out.println("Application started....");
		Thread.sleep(4000);*/
		
		MutableCapabilities caps = new MutableCapabilities();
		caps.setCapability("platformName","Android");
		caps.setCapability("appium:deviceName","Android GoogleAPI Emulator");
		//caps.setCapability("appium:deviceOrientation", "portrait");
		caps.setCapability("appium:platformVersion","12.0");
		caps.setCapability("appium:automationName", "UiAutomator2");
		caps.setCapability("appium:app", "storage:filename=Android.SauceLabs.Mobile.Sample.app.2.3.0.apk");
		
		caps.setCapability("noReset", true);
		URL url = new URL("https://oauth-sharanya-17f2a:fdec31ea-d69e-4c93-945a-b590f2c35d19@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
		driver = new AndroidDriver<WebElement>(url, caps);
		System.out.println("Application started....");
		Thread.sleep(3000);
	}

	@Test
	public static void asaucelabstest() throws Exception{
		
		MobileElement el4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.EditText");
		el4.sendKeys("standard_user");
		MobileElement el5 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText");
		el5.sendKeys("secret_sauce");
		MobileElement el6 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button");
		el6.click();
		Thread.sleep(3000);
		String result = driver.findElement(By.xpath("(//android.view.View[@content-desc=\"Sauce Labs Backpack\"])[2]/android.widget.TextView")).getText();
		assert result.equals("Sauce Labs Backpack") : "Expected value : 'Sauce Labs Backpack' did not match with Actual value: "+ result;
		Thread.sleep(3000);
		driver.findElement(By.id("com.android.chrome:id/home_button")).click();
		Thread.sleep(3000);
	}

	@Test
	public static void failsaucelabstest() throws Exception{
		
		MobileElement el4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.EditText");
		el4.sendKeys("locked_out_user");
		MobileElement el5 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText");
		el5.sendKeys("secret_sauce");
		MobileElement el6 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button");
		el6.click();
		Thread.sleep(3000);
		String result = driver.findElement(By.xpath("(//android.view.View[@content-desc=\"Sauce Labs Backpack\"])[2]/android.widget.TextView")).getText();
		assert result.equals("Sauce Labs Backpack") : "Expected value : 'Sauce Labs Backpack' did not match with Actual value: "+ result;
		Thread.sleep(2000);
	}

	@AfterTest
	public void aftertest() {
		driver.quit();
	}
}
