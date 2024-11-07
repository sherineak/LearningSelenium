package org.example.ex_0_Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab305 {
    @Test
    public void testVWOLoginTitle(){
        WebDriver driver = new EdgeDriver();
        //driver.get("app.vwo.com");  // http is mandatory
        driver.get("https://app.vwo.com");
        //TestNG Assertions
        Assert.assertEquals(driver.getTitle(),"Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");
        driver.quit();

    }




}
