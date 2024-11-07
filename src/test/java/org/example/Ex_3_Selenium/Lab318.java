package org.example.Ex_3_Selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Lab318 {
        WebDriver driver;
        //EdgeDriver driver;
        @BeforeTest
        public void openBrowser1(){
            EdgeOptions Options = new EdgeOptions();
            Options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            Options.addArguments("--start-maximized");
            Options.addArguments("--guest"); // Avoid popups
            driver = new EdgeDriver(Options);


        }

        @Test(groups ="QA")
        @Description("Test Case Description")
        public void testWaits(){

            //  navigate to the url - https://www.ebay.com/b/Desktops-All-In-One-Computers/171957/bn_1643067
            driver.get("https://www.ebay.com/b/Desktops-All-In-One-Computers/171957/bn_1643067");
            System.out.println(driver.getTitle());
            WebElement searchBox = driver.findElement(By.cssSelector("input[id='gh-ac']"));
            searchBox.sendKeys("macmini"); // // Find macmini

            // Select -> simple, custom Select (div, ui - li) - different approach

            // Why do we need Waits in selenium
            //Thread.sleep() - its worst one , it will be delay  , it tells JVM to stop to execution
            // do this thread.seep

            //Implicit wait - bad
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Global way to add
            // if the element not getting, gives no such element Exception

            driver.findElement(By.id("login-username")).sendKeys("testusername");
            driver.findElement(By.id("login-password")).sendKeys("passass");
            driver.findElement(By.id("js-login-btn")).click();


        }
        @AfterTest

        public void closeBrowser(){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            driver.quit();

        }
}
