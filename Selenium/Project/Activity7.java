package hrm_Project;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity7 {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		// Create a new instance of the Firefox driver
		driver = new FirefoxDriver();

		// Open browser
		driver.get("http://alchemy.hguy.co/orangehrm");
		// Enter login details
		driver.findElement(By.id("txtUsername")).sendKeys("Swetha");
		driver.findElement(By.id("txtPassword")).sendKeys("swetha123");
		driver.findElement(By.xpath("//*[@id=\'btnLogin\']")).submit();
		Thread.sleep(5000);
	}

	@Test
	public void check_DirectoryItem() throws InterruptedException {
		// Go to Myinfo tab

		driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]")).click();
		Thread.sleep(3000);
//click on Qualification link
		driver.findElement(By.linkText("Qualifications")).click();
		//click on add
		driver.findElement(By.id("addWorkExperience")).click();
		//Enter all details
		driver.findElement(By.id("experience_employer")).sendKeys("IBM");
		driver.findElement(By.id("experience_jobtitle")).sendKeys("Test Specialist");
		WebElement from=driver.findElement(By.id("experience_from_date"));
		from.clear();
		from.sendKeys("2019-04-29");
		//current date
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		  LocalDate localDate = LocalDate.now();
		  WebElement to= driver.findElement(By.id("experience_to_date"));
		  to.clear();
		  to.sendKeys(dtf.format(localDate));
		  //click on save
		  driver.findElement(By.id("btnWorkExpSave")).click();
	}
	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();
	}
	

}
