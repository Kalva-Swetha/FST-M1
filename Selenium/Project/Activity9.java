package hrm_Project;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity9 {

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
		//Go to myinfo tab

		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
		Thread.sleep(3000);
		//click on Emergency contacts
		driver.findElement(By.linkText("Emergency Contacts")).click();
		// click on add

		Thread.sleep(3000);

		WebElement emc= driver.findElement(By.id("emgcontact_list"));
		//Print all info
		System.out.println(emc.getText());
		

	}

	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();
	}

}
