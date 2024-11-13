package org.example.Ex_3_Selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab333_ActionClass {
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
        public void testPositive() throws InterruptedException {
            String URL = "https://www.spicejet.com/";
            driver.get(URL);
            driver.manage().window().maximize();


            WebElement source = driver.findElement(By.xpath("//div[@data-testid=\"to-testID-origin\"]/div/div/input"));

            Actions actions = new Actions(driver);
            actions.moveToElement(source).click().build().perform();
            actions.moveToElement(source).click().sendKeys("BLR").build().perform();



            Thread.sleep(13000);

        }

        @AfterTest
        public void closeBrowser(){
            driver.quit();
        }
    }