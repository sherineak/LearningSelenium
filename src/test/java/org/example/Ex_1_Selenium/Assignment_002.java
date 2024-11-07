package org.example.Ex_1_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment_002 {

//    open the url - https://katalon-demo-cura.herokuapp.com/
//    click on the make appoinment button
//    verify that url changes - assert
//            time.sleep(3)
//    enter the username, password
//    next page verify the current url
//    make appoinment text on the web page.

    @Test
    public void testMakeAppoint(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com");


        WebElement ButtonmakeAppoint = driver.findElement(By.linkText("Make Appointment"));
        ButtonmakeAppoint.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/profile.php#login");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement UserNameInputBox = driver.findElement(By.id("txt-username"));
        UserNameInputBox.sendKeys("John Doe");

        WebElement passwordInputBox = driver.findElement(By.id("txt-password"));
        passwordInputBox.sendKeys("ThisIsNotAPassword");

        WebElement buttonLogin = driver.findElement(By.id("btn-login"));
        buttonLogin.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");
        //Verify appointment text on the web page.
        WebElement textMakeAppointment = driver.findElement(By.tagName("h2"));
        System.out.println(textMakeAppointment);
        Assert.assertTrue(textMakeAppointment.isDisplayed(),"Make Appointment");


        driver.quit();
    }

}
