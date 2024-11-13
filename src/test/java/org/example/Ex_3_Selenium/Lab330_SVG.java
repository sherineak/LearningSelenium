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

public class Lab330_SVG {
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
    public void testSVG() {
        driver.manage().window().maximize();

        driver.get("https://www.amcharts.com/svg-maps/?map=india");
        System.out.println(driver.getTitle());

        //  //*[local-name() = 'svg']
        // OR  //*[name()= 'svg']      , we have other functions contains(), test(), name()


        //      //*[name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path']

        List<WebElement> states = driver.findElements(By.xpath("//*[name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path']"));
        System.out.println(states.size());
        for(WebElement state: states){
            System.out.println(state.getAttribute("aria-label"));
            if(state.getAttribute("aria-label").contains("Kerala")){
                state.click();
            }

        }

        //I agree popup can handle by action class

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
