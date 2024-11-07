package org.example.Ex_3_Selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.example.Ex_3_Selenium.WaitHelpers.CheckVisibility;

public class Lab320_Use_WaitHelpers {
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

            CheckVisibility(driver,(By.cssSelector("[data-qa='lufexuloga']"))); // Custom element


           WebElement loggedin_userName= driver.findElement(By.cssSelector("span[data-qa='lufexuloga']"));
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
