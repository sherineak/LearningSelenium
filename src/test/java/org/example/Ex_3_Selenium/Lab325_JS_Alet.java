package org.example.Ex_3_Selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Lab325_JS_Alet {
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
    public void testJsAlert(){

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();

        //JavaScript Alert

        //   //button[onclick='jsAlert()'    - css Selector
        //    //button[text()='Click for JS Alert']   - text

        //WebElement element = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        //WebElement elementConfirm = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        WebElement elementPrompt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        //element.click();
        //elementConfirm.click();
         elementPrompt.click();


        //when we run this code in the aws , docker machine , it will be slow , so have to give wait-Explicit wait
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());

        // there is a class alert
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Sherine");
        alert.accept();
        //alert.dismiss();

        String result = driver.findElement(By.id("result")).getText();
        //Assert.assertEquals(result,"You successfully clicked an alert");
        //Assert.assertEquals(result,"You clicked: Ok");
        //Assert.assertEquals(result,"You clicked: Cancel");
        Assert.assertEquals(result,"You entered: Sherine");


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
