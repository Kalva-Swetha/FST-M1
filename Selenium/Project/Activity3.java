package hrm_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Activity3 {

	    WebDriver driver;
	    
	    @BeforeMethod
	    public void beforeMethod() {
	        //Create a new instance of the Firefox driver
	        driver = new FirefoxDriver();
	        
	        //Open browser
	        driver.get("http://alchemy.hguy.co/orangehrm");
	    }

	    @Test
	    public void loginCheck() throws InterruptedException {
	    	driver.findElement(By.id("txtUsername")).sendKeys("orange");
			 driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
			 driver.findElement(By.xpath("//*[@id=\'btnLogin\']")).submit();
			 Thread.sleep(5000);

	         String actualUrl="http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/dashboard";
	        	 String expectedUrl= driver.getCurrentUrl();
	     Assert.assertEquals(actualUrl, expectedUrl);
	         
	    }
	    @AfterMethod
	    public void afterMethod() {
	        //Close the browser
	        driver.quit();
	    }
	    

	}

