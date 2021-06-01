package appium_project_activities;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity2 {
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel4_Emulator");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.google.android.keep");
		caps.setCapability("appActivity", ".activities.BrowseActivity");
		caps.setCapability("noReset", true);
		// Instantiate Appium Driver
		try {
			URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
			driver = new AndroidDriver<MobileElement>(appServer, caps);
			wait = new WebDriverWait(driver, 10);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void create_Tasks() {
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("new_note_button")));
		driver.findElementById("new_note_button").click();
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("editable_title")));
		driver.findElementById("editable_title").sendKeys("Appium project");
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("edit_note_text")));
		driver.findElementById("edit_note_text").sendKeys("Complete Activity with Google Keep");
		driver.findElementByAccessibilityId("Navigate up").click();

		// Assertion
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("index_note_title")));
		String title = driver.findElementById("index_note_title").getText();
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("index_note_text_description")));
		String Desc = driver.findElementById("index_note_text_description").getText();
		assertEquals(title, "Appium project");
		assertEquals(Desc, "Complete Activity with Google Keep");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();

	}
}
