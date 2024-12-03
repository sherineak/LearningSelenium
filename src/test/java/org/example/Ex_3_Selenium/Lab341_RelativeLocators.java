package org.example.Ex_3_Selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Lab341_RelativeLocators {
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
    public void testRelativeLocators () throws InterruptedException {

        driver.get("https://www.aqi.in/real-time-most-polluted-city-ranking");
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement searchElement = driver.findElement(By.xpath("(//input[@type='search'])[2]")); //
        searchElement.sendKeys("India" + Keys.ENTER); // Need to click on enter to get results
//div[@class='page aqi-live-cities-ranking w-full min-h-dvh']/div/div/div[2]/div[@class="flex flex-col"]/a[1]

       WebElement list_of_states = driver.findElement(By.xpath("//div[@class='page aqi-live-cities-ranking w-full min-h-dvh']/div/div/div[2]/div[@class=\"flex flex-col\"]/a[1]"));
        System.out.println(list_of_states.getText());
//        Thread.sleep(5000);
//        for(WebElement l: list_of_states){
//            String s1=driver.findElement(with(By.tagName("a")).toRightOf(l)).getText();
//            System.out.println(s1);
//
//        }
// as HTML page is changed unable to fetch relative locators
Thread.sleep(3000);
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
