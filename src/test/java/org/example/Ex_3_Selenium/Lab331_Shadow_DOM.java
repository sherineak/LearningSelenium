package org.example.Ex_3_Selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab331_Shadow_DOM {
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
    public void testShadowDOM() throws InterruptedException {

        driver.get("https://selectorshub.com/xpath-practice-page/");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();

// Java Script code handled by java script executor
        JavascriptExecutor js = (JavascriptExecutor) driver;



//        WebElement element = driver.findElement(By.xpath("//input[@id='pizza']"));
//        element.sendKeys(" This will nt work  ");


            Thread.sleep(5000);


        // Java Script code which gives you web element in Shadow Dom- document.querySelector("div#userName").shadowRoot.querySelector("div").shadowRoot.querySelector("input#pizza")
//div#userName
        // We have to scroll to the element so the div class of this element is jackPart
        WebElement divScroll = driver.findElement(By.xpath("//div[@id='userName']")); // This is not under the shadow and can use xpath
        js.executeScript("arguments[0].scrollIntoView(true);",divScroll); // here divScroll - element will assign to argument[0]to scroll using javascript executor


            Thread.sleep(5000);



        WebElement inputBoxPizza = (WebElement) js.executeScript("return document.querySelector(\"div#userName\").shadowRoot.querySelector(\"div\").shadowRoot.querySelector(\"input#pizza\")");
        inputBoxPizza.sendKeys("FarmHouse");


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
