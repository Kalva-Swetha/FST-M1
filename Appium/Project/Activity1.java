package appium_project_activities;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

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

public class Activity1 {
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait ;

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel4_Emulator");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.google.android.apps.tasks");
		caps.setCapability("appActivity", ".ui.TaskListsActivity");
		caps.setCapability("noReset", true);
		// Instantiate Appium Driver
		try {
		URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, caps);
		wait= new WebDriverWait(driver,10);
		}
		catch(MalformedURLException e) {
			e.printStackTrace();
		}
		
	}

	@Test
	public void create_Tasks() {
		String[] taskToAdd= {
				"Complete Activity with Google Tasks",
				"Complete Activity with Google Keep",
				"Complete the second Activity Google Keep"
		};
		for(String tasksToBeadded: taskToAdd) {
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("tasks_fab")));
		driver.findElementById("tasks_fab").click();
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));
		driver.findElementById("add_task_title").sendKeys(tasksToBeadded);
		driver.findElementById("add_task_done").click();

		// Display Result
		//String result = driver.findElementById("result").getText();
		//System.out.println(result);
		//Assert.assertEquals(result, "28");
		}
		wait.until(ExpectedConditions.numberOfElementsToBe(MobileBy.id("task_name"),3));
		List<MobileElement> tasksAdded= driver.findElementsById("task_name");
		assertEquals(tasksAdded.size(),3);
		int j=0;
		for(int i=tasksAdded.size()-1;i>=0;i--) {
			
			assertEquals(tasksAdded.get(i).getText(),taskToAdd[j]);
			j++;
		}
	}


	@AfterClass
	    public void afterClass() {
	        driver.quit();
	   
	}
}
