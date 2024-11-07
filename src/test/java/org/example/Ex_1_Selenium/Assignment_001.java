package org.example.Ex_1_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment_001 {
    @Test
//    Selenium Project #1
//            [Assignment] - Automating the Login Page of VWO.com
//    Fetch the locators - https://app.vwo.com/
//    Create a Maven project and add TestNG.
//    Add the Allure Report (Allure TestNG)
//    Automate the two Test cases of VWO.com
//    Valid Username and Valid Password
//    Verify name on dashboard page.
//    Run them and share results.
//    Push the code to github.com
//    Git repo - ReadMe.md a Screen shot of allure.
public void testVerifyUsernamePass(){
        EdgeOptions edgeOptions = new EdgeOptions();
       edgeOptions.addArguments("--inprivate");
       edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com/#/login");

        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");


        WebElement emailInputBox = driver.findElement(By.id("login-username"));
        emailInputBox.sendKeys("sherine@test.com");

        WebElement passInputBox = driver.findElement(By.id("login-password"));
        passInputBox.sendKeys("Welcome@123");



            try {
                    Thread.sleep(5000);
            } catch (InterruptedException e) {
                    throw new RuntimeException(e);
            }

        WebElement buttonSubmit = driver.findElement(By.id("js-login-btn"));
        buttonSubmit.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

driver.quit();
    }

}
