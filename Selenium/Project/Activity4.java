package hrm_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class Activity4 {

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
	public void check_newEmployee() throws InterruptedException {
		//Go to PIM tab

		driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]")).click();
		Thread.sleep(3000);
		//Click on add button
		driver.findElement(By.name("btnAdd")).click();
		//Enter first and last and save
		driver.findElement(By.name("firstName")).sendKeys("Swetha");
		driver.findElement(By.name("lastName")).sendKeys("Reddy");
		// driver.findElement(By.id("employeeId")).sendKeys("302417");
		// driver.findElement(By.xpath("//*[@id=\"chkLogin\"]")).click();
		driver.findElement(By.id("btnSave")).click();

		Thread.sleep(3000);
//Go to PIM tab 
		driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
//Searching created employee
		Thread.sleep(3000);
		WebElement m= driver.findElement(By.id("empsearch_employee_name_empName"));
		m.sendKeys("Swetha Reddy");
		WebElement m1= driver.findElement(By.id("empsearch_employee_name_empName"));
		m1.sendKeys(Keys.ENTER);
		

		Thread.sleep(3000);
		driver.findElement(By.id("searchBtn")).click();
		Thread.sleep(5000);
		WebElement fn=driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[3]/a"));
        System.out.print(fn.getText()+" ");
        WebElement ln=driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[4]/a"));
        System.out.println(ln.getText());
      

	}
	
	 @AfterMethod
	    public void afterMethod() {
	        //Close the browser
	        driver.quit();
	    }
	    
	

}
