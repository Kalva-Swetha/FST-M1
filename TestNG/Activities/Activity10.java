package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity10 
{
	   WebDriver driver;
	    Actions builder;


 
    @BeforeClass
    void beforeClass() {
        driver = new FirefoxDriver();
        builder = new Actions(driver);

        //Open browser
        driver.get("https://www.training-support.net/selenium/sliders");
    }

    @Test(priority=1)
    public void sliderToMiddleTest() {
        //Find slider
        WebElement slider = driver.findElement(By.id("slider"));
        //Clicking on the slider element moves it to the middle
        slider.click();
        
        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Mid value: " + volumeLevel);
        
        Assert.assertEquals(volumeLevel, "50");
    }
    
    @Test(priority=2)
    public void sliderToMaxTest() throws InterruptedException {
        //Find slider
        WebElement slider = driver.findElement(By.id("slider"));
        //Drag the slider
        builder.clickAndHold(slider).moveByOffset(80, 0).release().build().perform();
        Thread.sleep(3000);
        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Max value: " + volumeLevel);
        
        Assert.assertEquals(volumeLevel, "100");
    }
    @Test(priority=3)
    public void sliderToMinTest() {
        //Find slider
        WebElement slider = driver.findElement(By.id("slider"));
        //Drag the slider
        builder.clickAndHold(slider).moveByOffset(-80, 0).release().build().perform();
        
        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Min value: " + volumeLevel);
        
        Assert.assertEquals(volumeLevel, "0");
    }
    
    @Test(priority=5)
    public void sliderTo30Test() {
        //Find slider
        WebElement slider = driver.findElement(By.id("slider"));
        //Drag the slider
        builder.clickAndHold(slider).moveByOffset(-31, 0).release().build().perform();
        
        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Min value: " + volumeLevel);
        
        Assert.assertEquals(volumeLevel, "30");
    }
    
    @Test(priority=4)
    public void sliderTo80Test() {
        //Find slider
        WebElement slider = driver.findElement(By.id("slider"));
        //Drag the slider
        builder.clickAndHold(slider).moveByOffset(49, 0).release().build().perform();
        
        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Min value: " + volumeLevel);
        
        Assert.assertEquals(volumeLevel, "80");
    }
 
   

    @AfterClass
    public void afterClass() {
        //Close browser
        driver.close();
    }
}
