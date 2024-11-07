package org.example.Ex_3_Selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab324_SelectBox {
    WebDriver driver;
    //EdgeDriver driver;
    @BeforeTest
    public void openBrowser1(){
        EdgeOptions Options = new EdgeOptions();
        Options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        //Options.addArguments("--start-maximized");
        Options.addArguments("--guest"); // Avoid popups
        driver = new EdgeDriver(Options);


    }

    @Test(groups ="QA")
    @Description("Test Case Description")
    public void testSelectTag(){

        driver.get("https://the-internet.herokuapp.com/dropdown");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();

        //Select Box

        // HTML Select TAG is used
        WebElement element_Select = driver.findElement(By.id("dropdown"));

        Select select = new Select(element_Select);
        //select.selectByIndex(1);
        select.selectByVisibleText("Option 2");

        //HTML Select Tag is NOT used  - Another Mechanism








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
