package hrm_Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class Activity1 {
	
	WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        
        //Open browser
        driver.get("http://alchemy.hguy.co/orangehrm");
    }

    @Test
    public void testTitle() {
        // Check the title of the page
        String title = driver.getTitle();
            
        //Print the title of the page
        //System.out.println("Page title is: " + title);	
            
            //Assertion for page title
        Assert.assertEquals("OrangeHRM", title);

    }
    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
