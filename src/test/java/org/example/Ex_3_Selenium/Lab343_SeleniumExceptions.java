package org.example.Ex_3_Selenium;

import com.sun.org.apache.xpath.internal.operations.Or;
import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Lab343_SeleniumExceptions {
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
    public void testExceptions () throws InterruptedException {

            try {


                driver.get("https://google.com");
                driver.manage().window().maximize();
                WebElement ele = driver.findElement(By.xpath("//*[@class ='gLFyf']")); // To get this xpath use shadow Dom ,
                // to understand StaleElementReferenceException open google then refresh or open any other url  and the send key in the text box " The testing Academy"
                // there will be a staleElementReferenceException as this element is already refreshed and try to send
                driver.navigate().refresh();
                ele.sendKeys("The Testing Academy");

                // Refresh, Navigate to other page, element removed , change in DOM elemets(ajaX calls)  --> Stale elementReferenceException

                //b1 - found driver
                //b1 remove
                //b1.click --> No Such  element Exception


                // driver.switchTo().frame(1);   --> No such a frame Exception
                //driver.switchTo().alert().accept(); --> No Such a alert Exception


            }catch (StaleElementReferenceException | NoSuchElementException ex ) {
                System.out.println(ex.getMessage());  // OR
                ex.printStackTrace();

            }catch ( Exception ex){
                ex.printStackTrace();// if you are not sure which exception will come then can use daddy
            }



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
