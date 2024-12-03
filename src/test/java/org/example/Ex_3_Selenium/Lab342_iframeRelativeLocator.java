package org.example.Ex_3_Selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Lab342_iframeRelativeLocator {
    WebDriver driver;
    //EdgeDriver driver;
    
        @BeforeTest
        public void openBrowser(){
            EdgeOptions options = new EdgeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            options.addArguments("--guest");
            driver = new EdgeDriver(options);
        }


    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testIframeRelativeLocators () throws InterruptedException {

        driver.get("https://codepen.io/AbdullahSajjad/full/LYGVRgK");
        driver.manage().window().maximize();
        Thread.sleep(15000);

        // Switch to iframe first
        driver.switchTo().frame("result");
        WebElement button = driver.findElement(By.xpath("//form[@id='form']/button"));
        button.click();

        WebElement element = driver.findElement(By.id("username"));
        WebElement errorElement = driver.findElement(with(By.tagName("small")).below(element));
        String error = errorElement.getText();

        Assert.assertTrue(errorElement.isDisplayed());
        Assert.assertEquals(error,"Username must be at least 3 characters");



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
