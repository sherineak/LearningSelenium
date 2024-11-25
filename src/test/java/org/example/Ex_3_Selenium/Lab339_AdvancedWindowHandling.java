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

import java.util.Iterator;
import java.util.Set;

public class Lab339_AdvancedWindowHandling {
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
    public void testAdvancedWindowHandling () throws InterruptedException {

        driver.get("https://app.vwo.com/#/test/ab/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1");
        driver.manage().window().maximize();
        Thread.sleep(5000);

        String mainWindowHandle = driver.getWindowHandle();
        System.out.println("BeforeClick"+mainWindowHandle);
        Actions ac = new Actions(driver);   // to Move to that element using action class
        ac.moveToElement(driver.findElement(By.cssSelector("[data-qa=\"yedexafobi\"]"))).click().build().perform();

        Thread.sleep(5000);

        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);

        // Instead of for loop , here using Iterator, you can use what you like
        Iterator<String> iterator = windowHandles.iterator();
        while  (iterator.hasNext()){
            String childWindow = iterator.next();
            if(!mainWindowHandle.equalsIgnoreCase((childWindow))){  // If main window and child window is not equal
                driver.switchTo().window(childWindow);
                System.out.println(driver.getTitle());
            }
        }
        Thread.sleep(6000);
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
