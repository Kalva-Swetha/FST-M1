package appium_project_activities;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

import io.appium.java_client.android.AndroidDriver;

public class Activity3 {
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
		driver.findElementById("editable_title").sendKeys("Google Keep Activities");
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("edit_note_text")));
		driver.findElementById("edit_note_text").sendKeys("Complete Activities with Google Keep");

		
        //Adding reminder
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("menu_switch_to_list_view")));
		driver.findElementById("menu_switch_to_list_view").click();
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView")));
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView").click();
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("save")));
		driver.findElementById("save").click();
		driver.findElementByAccessibilityId("Navigate up").click();
		
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Open navigation drawer")));
		driver.findElementByAccessibilityId("Open navigation drawer").click();
		
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("title")));
		driver.findElementById("title").click();
		
		
		// Assertion
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("index_note_title")));
		String title = driver.findElementById("index_note_title").getText();
		
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("index_note_text_description")));
		String Desc = driver.findElementById("index_note_text_description").getText();
	
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("reminder_chip_text")));
		String Rem = driver.findElementById("reminder_chip_text").getText();
		assertEquals(title, "Google Keep Activities");
		assertEquals(Desc, "Complete Activities with Google Keep");
		assertEquals(Rem, "Today, 2:00 PM");
		

	}

	@AfterClass
	public void afterClass() {
		driver.quit();

	}
}
