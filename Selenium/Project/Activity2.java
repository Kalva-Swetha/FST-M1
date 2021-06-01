package hrm_Project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


public class Activity2 {
	
	WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        
        //Open browser
        driver.get("http://alchemy.hguy.co/orangehrm");
    }

    @Test
    public void printHeader() {
            String url="http://alchemy.hguy.co:8080/orangehrm/symfony/web/webres_5d69118beeec64.10301452/themes/default/images/login/logo.png";
            driver.get(url);
            
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            // get current URL and print
            String strUrl = driver.getCurrentUrl();
            System.out.println("Current Url is:"+ strUrl);
            
            //Assert.assertEquals(url, strUrl);

    }
    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
