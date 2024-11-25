package org.example.Ex_3_Selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab336_scroll_down_keyboard {
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
    public void testActionClass () throws InterruptedException {

        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();
        Thread.sleep(5000); // To load page



        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
        System.out.println("Scroll Down");


        Thread.sleep(5000);

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