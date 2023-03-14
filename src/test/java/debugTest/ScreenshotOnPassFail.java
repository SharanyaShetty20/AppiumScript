package debugTest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ ScreenshotUtility.class })
public class ScreenshotOnPassFail {

	static AndroidDriver<WebElement> driver;

	@BeforeClass
	public void initialize() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability("deviceName", "Galaxy J7");
		dc.setCapability("udid", "3300868aa3f4b2f9");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "6.0.1");

		dc.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		dc.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");

		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	// Method Is written In such a way to fail It Intentionally.
	// This method will fail as actual result 6 will not match with expected 7.
	@Test
	public void TestForFailure() throws IOException, Exception {
		
		// Click on DELETE/CLR button to clear result text box before running test.
		WebElement clear = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_clear"));
		clear.click();
		Thread.sleep(4000);
		
		// Click on 2, +, 4 and = buttons.
		driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_02")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_add")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_04")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_equal")).click();
		Thread.sleep(3000);
		
		// Get result from calculator result text-box.
		String result = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/txtCalc")).getText();
		
		// Compare actual and expected result using testng assertion and mark test pass or fail based on result.
		// Assertion will fail. So It will call onTestFailure method from ScreenshotUtility.
		assert result.equals("7") : "Expected value : 7 did not match with Actual value: "+ result;
		//Thread.sleep(6000);
	}

	@Test
	public void TestForPass() throws IOException, Exception {
		
		// Click on DELETE/CLR button to clear result text box before running test.
		WebElement clear = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_clear"));
		clear.click();
		Thread.sleep(4000);
		
		// Click on 3, +, 4 and = buttons.
		driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_03")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_add")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_04")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_equal")).click();
		Thread.sleep(3000);
		
		// Get result from calculator result text-box.
		String result = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/txtCalc")).getText();
		
		// Compare actual and expected result using testng assertion and mark test pass or fail based on result.
		// Assertion will pass. So It will call onTestSuccess method from ScreenshotUtility.
		assert result.equals("7") : "Expected value : 7 did not match with Actual value: " + result;
		//Thread.sleep(6000);
	}

	@AfterClass
	public void End() {
		driver.quit();
	}

}
