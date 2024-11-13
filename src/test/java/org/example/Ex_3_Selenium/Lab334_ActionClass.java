package org.example.Ex_3_Selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Lab334_ActionClass {
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
    public void testActionsClass() throws InterruptedException {

        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();

        Thread.sleep(4000);
        WebElement fromCity = driver.findElement(By.id("fromCity"));

        Actions actions = new Actions(driver);
        actions.moveToElement(fromCity).click().sendKeys("New Delhi").build().perform();

        Thread.sleep(3000);

        List<WebElement> auto_suggestions= driver.findElements(By.xpath("//ul[@class ='react-autosuggest__suggestions-list']/li"));

        for (WebElement e: auto_suggestions){
            if(e.getText().contains("New Delhi")){
                e.click();
                break;
            }
        }
        Thread.sleep(8000);
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