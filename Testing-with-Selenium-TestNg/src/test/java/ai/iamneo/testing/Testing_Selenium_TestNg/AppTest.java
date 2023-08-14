package ai.iamneo.testing.Testing_Selenium_TestNg;

import org.testng.annotations.Test;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class AppTest {

    ChromeOptions chromeOptions = new ChromeOptions();
    WebDriver driver = null;

    @BeforeTest
    public void beforeTest() throws Exception {
    // Driver setup & Navigation
        driver = new RemoteWebDriver(new URL("http://www.flipkart.com"), chromeOptions);
    }

    @Test
    public void testcase_1() throws InterruptedException
    {
        // Verify Title         
        String title = driver.getTitle();
        Assert.assertEquals(title, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
    }

    @Test
    public void testcase_2() throws InterruptedException 
      {
        //Flipkart Login 

        driver.findElement(By.xpath("//div[@class='1XBjg-row]//form//input[@type='text']")).sendKeys("test@gmail.com");
        driver.findElement(By.xpath("//div[@class='_1XBjg-row]//form//input[@type='password']")).sendKeys("Test@123");
        driver.findElement(By.xpath("//div[@class='1XBjg-row']//form//button[@type'submit']")).click();

        // verify that the user is login successfully in homepage

         String get = driver.getCurrentUrl();
         Assert.assertEquals(get, "https://www.flipkart.com/");

         
         String actualUrl="https://www.flipkart.com/";
         if(actualUrl.equalsIgnoreCase(get)) 
         { 
            System.out.println("Test passed"); 
         } 
         else
         { System.out.println("Test failed");
         } 
        }
    

        
    @AfterTest
    public void afterTest() {
        driver.quit();
    }

}

