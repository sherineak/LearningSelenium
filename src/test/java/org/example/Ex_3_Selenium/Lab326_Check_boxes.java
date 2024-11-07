package org.example.Ex_3_Selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Lab326_Check_boxes {
    WebDriver driver;
    //EdgeDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions Options = new EdgeOptions();
        Options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        //Options.addArguments("--start-maximized");
        Options.addArguments("--guest"); // Avoid popups
        driver = new EdgeDriver(Options);


    }

    @Test(groups ="QA")
    @Description("Test Case Description")
    public void testCheckBox(){

        driver.get("https://the-internet.herokuapp.com/checkboxes");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();

        List<WebElement> checkboxes = driver.findElements(By.xpath(" //input[@type='checkbox']"));
        checkboxes.get(0).click();
        checkboxes.get(1).click();


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
