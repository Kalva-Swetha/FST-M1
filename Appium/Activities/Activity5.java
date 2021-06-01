package activities;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Activity5 {
    WebDriverWait wait;
    AppiumDriver<MobileElement> driver = null;

    @BeforeTest
    public void setup() throws MalformedURLException {

        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel4_Emulator");
		caps.setCapability("platformName", "Android");
        caps.setCapability("noReset", true);
        // Use your own device's messaging app
        caps.setCapability("appPackage", "com.google.android.apps.messaging");
        caps.setCapability("appActivity", ".ui.ConversationListActivity");

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 5);
    }

    @Test
    public void smsTest() {
        // Locate the button to write a new message and click it
    	wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Start new conversation")));
        driver.findElementByAccessibilityId("Start new conversation").click();

        // Enter the number to send message to
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("recipient_text_view")));
        WebElement m1=  driver.findElementById("recipient_text_view");
         m1.sendKeys("7207666520");
         Actions action = new Actions(driver);
         action.sendKeys(Keys.ENTER).perform();
        // Type in a message
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.EditText[contains(@text,'Text message')]")));
        driver.findElementByXPath("//android.widget.EditText[contains(@text,'Text message')]").sendKeys("Hello from Appium");
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("send_message_button_icon")));
        driver.findElementById("send_message_button_icon").click();
        
        // Assertion
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("message_text")));
      String sentMessageText=  driver.findElementById("message_text").getText();
        
        Assert.assertEquals(sentMessageText, "Hello from Appium");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}