package org.example.Ex_3_Selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.xml.sax.Locator;

import java.time.Duration;

import static org.example.Ex_3_Selenium.WaitHelpers.CheckVisibility;

public class Lab321_FluentWait {
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
        public void testWaitsExplicitPositiveScenario(){



            driver.get("https://app.vwo.com/#/login");
            System.out.println(driver.getTitle());


            driver.findElement(By.id("login-username")).sendKeys("contact+atb7x@thetestingacademy.com");
            driver.findElement(By.id("login-password")).sendKeys("Wingify@1234");
            driver.findElement(By.id("js-login-btn")).click();

            // Explicit wait to  display Dashboard with name Aman ji

//           WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10000));
//           wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-qa='lufexuloga']"))); // Custom element

            FluentWait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofSeconds(2))  // every 2 seconds will check 10/2 = 5. 5 times will check the element found or not
                    .ignoring(NoSuchElementException.class);



           WebElement loggedin_userName= wait.until(driver ->driver.findElement(By.cssSelector("span[data-qa='lufexuloga']")));
           System.out.println("logged in User Deatils ->" + loggedin_userName.getText());

            Assert.assertEquals(loggedin_userName.getText(),"Aman Ji");



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
