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

import java.util.Set;

public class Lab338_windowHandling {
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
    public void testWindowHandling () throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        String mainWindowHandler = driver.getWindowHandle(); // get window handle will give you how many windows are open
        System.out.println("Before Click : "+ mainWindowHandler);  // only one window

        WebElement link = driver.findElement(By.linkText("Click Here"));
        link.click();
        Set<String> windowHandles = driver.getWindowHandles();  // Why Set -- > all the window tab have a unique name
        for(String handles: windowHandles){
            driver.switchTo().window(handles); // Switch to that window
            System.out.println(handles);
            if(driver.getPageSource().contains("New Window")){    // Page Source --> right click on the browser page --> view page source --> verify in whole page " New Window " textt present or not
                System.out.println("Test Case Passed");
            }
        }
        //If move back to original window
        driver.switchTo().window(mainWindowHandler);


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
    //Problem : Download a file and check in the directory if that is present
    // Download file
    // Checked by Chrome options
    // Chrome options --> Wil tell in which directory you want to download
    //then check file name exist or not in the directory with file name