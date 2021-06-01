package appium_project_activities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity5 {
	AndroidDriver<MobileElement> driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel4_Emulator");
		caps.setCapability("platformName", "android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("appPackage", "com.android.chrome");
		caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		caps.setCapability("noReset", true);
		URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, caps);
		wait = new WebDriverWait(driver, 10);
		driver.get("https://www.training-support.net/selenium");
	}

	@Test
	public void login_check_validCred() throws InterruptedException {

		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View")));
		driver.findElement(
				MobileBy.AndroidUIAutomator("UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(2)"));
		Thread.sleep(3000);
		driver.findElementByXPath("//android.view.View[contains(@text,'Login Form')]").click();
		Thread.sleep(3000);

		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy
				.xpath("//android.view.View[4]/android.view.View/android.view.View/android.widget.EditText[1]")));
		driver.findElementByXPath(
				"//android.view.View[4]/android.view.View/android.view.View/android.widget.EditText[1]")
				.sendKeys("admin");
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy
				.xpath("//android.view.View[4]/android.view.View/android.view.View/android.widget.EditText[2]")));
		driver.findElementByXPath(
				"//android.view.View[4]/android.view.View/android.view.View/android.widget.EditText[2]")
				.sendKeys("password");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[@text='Log in']")));
		driver.findElementByXPath("//android.widget.Button[@text='Log in']").click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(MobileBy.xpath("//android.view.View/android.view.View[4]")));
		String msg = driver.findElementByXPath("//android.view.View/android.view.View[4]").getText();

		System.out.println(msg);

		Assert.assertEquals("Welcome Back, admin", msg);

	}

	@Test(priority=1)
	public void login_check_InvalidCred() throws InterruptedException {

		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View")));
		driver.findElement(
				MobileBy.AndroidUIAutomator("UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(2)"));
		Thread.sleep(3000);
		driver.findElementByXPath("//android.view.View[contains(@text,'Login Form')]").click();
		Thread.sleep(3000);

		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy
				.xpath("//android.view.View[4]/android.view.View/android.view.View/android.widget.EditText[1]")));
		driver.findElementByXPath(
				"//android.view.View[4]/android.view.View/android.view.View/android.widget.EditText[1]")
				.sendKeys("Swetha");
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy
				.xpath("//android.view.View[4]/android.view.View/android.view.View/android.widget.EditText[2]")));
		driver.findElementByXPath(
				"//android.view.View[4]/android.view.View/android.view.View/android.widget.EditText[2]")
				.sendKeys("1234567");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[@text='Log in']")));
		driver.findElementByXPath("//android.widget.Button[@text='Log in']").click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(MobileBy.xpath("//android.view.View/android.view.View[4]")));
		String msg = driver.findElementByXPath("//android.view.View/android.view.View[4]").getText();

		System.out.println(msg);

		Assert.assertEquals("Invalid Credentials", msg);
		driver.get("https://www.training-support.net/selenium");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}