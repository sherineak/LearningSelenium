package org.example.Ex_3_Selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab337_Drag_Drop_file_upload {
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
    public void testDragAndDrop () throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        //driver.manage().window().maximize();
        Thread.sleep(5000); // To load page

        WebElement from = driver.findElement(By.id("column-a"));
        WebElement to = driver.findElement(By.id("column-b"));

        Actions actions = new Actions(driver);
        //First Method
        //actions.dragAndDrop(from,to).perform();

        //Second Method
        actions.clickAndHold(from).moveToElement(to).release(to).build().perform();

         Thread.sleep(4000);

         driver.get("https://awesomeqa.com/selenium/upload.html");
         String dir = System.getProperty("user.dir"); // this dir  will be different for each users
         System.out.println(dir);

         WebElement uploadFileInput = driver.findElement(By.id("fileToUpload"));
         uploadFileInput.sendKeys(dir + "\\src\\test\\java\\org\\example\\Ex_3_Selenium\\toUpload.txt");  // copy absolute path
         //C:\Users\SherineAntony\IdeaProjects\LearningSelenium\src\test\java\org\example\Ex_3_Selenium\toUpload.txt
        driver.findElement(By.name("submit")).click();


        Thread.sleep(10000);

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