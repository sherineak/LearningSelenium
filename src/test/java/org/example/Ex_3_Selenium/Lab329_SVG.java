package org.example.Ex_3_Selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Lab329_SVG {
    WebDriver driver;

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
    public void testSVG() {
        driver.manage().window().maximize();
        String URL = "https://www.flipkart.com/";
        driver.get(URL);
        System.out.println(driver.getTitle());

        // svg - Scalable Vector Graphics
        // svg - path, circle, ploygon
        //svg -> path -> g - shapes

        //  //*[local-name() = 'svg']
        // OR  //*[name()= 'svg']      , we have other functions contains(), test(), name()


        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("macmini");
        List<WebElement> svgElement = driver.findElements(By.xpath("//*[name() ='svg']"));
        svgElement.get(0).click();

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





