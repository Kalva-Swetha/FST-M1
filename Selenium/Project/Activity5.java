package hrm_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Activity5 {

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
	public void edit_Myinfo() throws InterruptedException {
		// Go to Myinfo tab

		driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]")).click();
		Thread.sleep(3000);

		// Click on Edit button
		driver.findElement(By.id("btnSave")).click();
		// Edit first and last,gender,nationality,dob
		WebElement frtname = driver.findElement(By.id("personal_txtEmpFirstName"));
		frtname.clear();
		frtname.sendKeys("Swetha123");
		WebElement lstname = driver.findElement(By.id("personal_txtEmpLastName"));
		lstname.clear();
		lstname.sendKeys("Kalva");
		Thread.sleep(2000);
		driver.findElement(By.id("personal_optGender_2")).click();
		Thread.sleep(3000);
		WebElement natn = driver.findElement(By.id("personal_cmbNation"));
		natn.click();
		driver.findElement(By.xpath("//*[@id=\"personal_cmbNation\"]/option[83]")).click();
		Thread.sleep(3000);
		WebElement dob = driver.findElement(By.id("personal_DOB"));
		dob.clear();
		dob.sendKeys("1997-04-05");
		driver.findElement(By.id("btnSave")).click();

		Thread.sleep(3000);
		//print edited first and last name
		WebElement fn = driver.findElement(By.xpath("//*[@id=\"personal_txtEmpFirstName\"]"));
		System.out.print(fn.getAttribute("value") + " ");
		WebElement ln = driver.findElement(By.xpath("//*[@id=\"personal_txtEmpLastName\"]"));
		System.out.println(ln.getAttribute("value"));
		String s=fn.getAttribute("value")+ln.getAttribute("value");
Assert.assertEquals(s, "Swetha123 Kalva");
	}

	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();
	}

}
