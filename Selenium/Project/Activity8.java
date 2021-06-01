package hrm_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity8 {

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
		// Dashboard page and click on the Apply Leave

		driver.findElement(By.xpath("//*[@id=\"menu_dashboard_index\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Apply Leave")).click();
		// click on add

		Thread.sleep(3000);
		// select leave type
		driver.findElement(By.xpath("//*[@id=\"applyleave_txtLeaveType\"]/option[2]")).click();

//From and To dates
		WebElement from = driver.findElement(By.id("applyleave_txtFromDate"));
		from.clear();
		from.sendKeys("2021-04-20");

		WebElement to = driver.findElement(By.id("applyleave_txtToDate"));
		to.clear();
		to.sendKeys("2021-04-21");
		WebElement t = driver.findElement(By.id("applyleave_txtToDate"));
		t.sendKeys(Keys.ENTER);
		driver.findElement(By.id("applyleave_txtComment")).sendKeys("Going village");
		Thread.sleep(3000);
		// click on save
		driver.findElement(By.id("applyBtn")).click();
//Go to myleave list
		driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
		Thread.sleep(3000);
		// Search with From and To dates
		WebElement from1 = driver.findElement(By.id("calFromDate"));
		from1.clear();
		from1.sendKeys("2021-04-20");

		WebElement to1 = driver.findElement(By.id("calToDate"));
		to1.clear();
		to1.sendKeys("2021-04-22");
		driver.findElement(By.id("btnSearch")).click();
		Thread.sleep(4000);
		// Get pending leaves
		WebElement status = driver.findElement(By.partialLinkText("Pending"));
		System.out.println(status.getText());

	}

	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();
	}

}
