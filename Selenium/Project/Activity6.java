package hrm_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity6 {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		// Create a new instance of the Firefox driver
		driver = new FirefoxDriver();

		// Open browser
		driver.get("http://alchemy.hguy.co/orangehrm");
		// Enter login details
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
		driver.findElement(By.xpath("//*[@id=\'btnLogin\']")).submit();
		Thread.sleep(5000);

	}

	@Test
	public void check_DirectoryItem() throws InterruptedException {
	

		WebElement dir = driver.findElement(By.xpath("//*[@id=\"menu_directory_viewDirectory\"]"));
		// Checkk Directory menu item displaying and clickble or not
		if (dir.isDisplayed() && dir.isEnabled()) {
			dir.click();
		}
		else
			System.out.println("Directory element is not visible and clickable");
		Thread.sleep(3000);
		//check Search directory title matched or not
		WebElement sd = driver.findElement(By.className("head"));
		Assert.assertEquals(sd.getText(), "Search Directory");

		System.out.println(sd.getText());

	}

	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();
	}

}
