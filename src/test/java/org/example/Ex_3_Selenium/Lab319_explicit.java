package org.example.Ex_3_Selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Lab319_explicit {
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
        public void testWaitsExplicit(){


            driver.get("https://app.vwo.com/#/login");
            System.out.println(driver.getTitle());




            driver.findElement(By.id("login-username")).sendKeys("testusername");
            driver.findElement(By.id("login-password")).sendKeys("passass");
            driver.findElement(By.id("js-login-btn")).click();

            WebElement error_msg = driver.findElement(By.id("js-notification-box-msg"));

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
            wait.until(ExpectedConditions.textToBePresentInElement(error_msg,"Your email, password, IP address or location did not match"));

            Assert.assertEquals(error_msg.getText(),"Your email, password, IP address or location did not match");

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
