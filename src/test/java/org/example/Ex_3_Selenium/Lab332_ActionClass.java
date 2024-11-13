package org.example.Ex_3_Selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.*;

public class Lab332_ActionClass {
    WebDriver driver;

    //EdgeDriver driver;
    @BeforeTest
    public void openBrowser() {
        EdgeOptions Options = new EdgeOptions();
        Options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        //Options.addArguments("--start-maximized");
        Options.addArguments("--guest"); // Avoid popups
        driver = new EdgeDriver(Options);

    }

    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testActionClass() throws InterruptedException {

        driver.get("https://awesomeqa.com/practice.html");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();

        //THETESTINGACADEMY
        //shift keydown --> theTestingacademy + shiftUp
        WebElement firstName = driver.findElement(By.name("firstname"));

        Actions actions = new Actions(driver);
        actions
                .keyDown(Keys.SHIFT)
                .sendKeys(firstName,"thetestingacademy")
                .keyUp(Keys.SHIFT).build().perform();
        //RightClick on the link Click here to Download File
        WebElement link = driver.findElement(By.linkText("Click here to Download File"));
        actions.contextClick(link).build().perform();

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
