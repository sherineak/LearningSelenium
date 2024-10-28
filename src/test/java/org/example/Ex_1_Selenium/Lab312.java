package org.example.Ex_1_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab312 {
    @Test
    public void testVwoLoginNegative(){
        // ** Project 1 - TC(Negative) -  Invalid Username  &  Pass - Then  Error Message **
    // 1. Open the URL .app.vwo.com/#/login (https://app.vwo.com/#/login)
    // 2.** Find the meail id ** and enter the email as admin@admin.com
    //3. **  Find the pass input box ** and enter password as admin
    //4. ** Find and click on the Submit Button
    //5. Verify that the error message is shown "Your email, password, IP address or location did not match"


        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest"); // if you want to remove popup


        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com/#/login");

        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");

        // 2.** Find the meail id ** and enter the email as admin@admin.com
        //How to find Element of username
//  <input type="email"  // attributes and behaviour
//  class="text-input W(100%)"  // attributes and behaviour
//  name="username" // attributes  and behaviour
//  id="login-username" // attributes  and behaviour
//  data-qa="hocewoqisi"> // attributes and behaviour
        WebElement emailInputBox = driver.findElement(By.id("login-username"));
        emailInputBox.sendKeys("admin@admin.com");

        WebElement passwordInputBox = driver.findElement(By.id("login-password"));
        passwordInputBox.sendKeys("password@321");

        WebElement buttonSubmit = driver.findElement(By.id("js-login-btn"));
        buttonSubmit.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        //Verify the message
        //WebElement error_message = driver.findElement(By.id("js-notification-box-msg"));
        WebElement error_message = driver.findElement(By.className("notification-box-description"));
        Assert.assertEquals(error_message.getText(),"Your email, password, IP address or location did not match");

        // No Id, name and class is not unique
        //link text and partial link  - a tag anchor

        WebElement freeTrialLInk = driver.findElement(By.linkText("Start a free trial"));
        //WebElement freeTrialLInk = driver.findElement((By.partialLinkText("Start a free")));
        freeTrialLInk.click();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }
}
