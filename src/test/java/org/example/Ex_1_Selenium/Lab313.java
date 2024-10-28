package org.example.Ex_1_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Lab313 {
    @Test
    public void testVerifyFREETrial(){


        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest"); // if you want to remove popup


        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com/#/login");

        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");



        WebElement freeTrialLInk = driver.findElement(By.linkText("Start a free trial"));
        //WebElement freeTrialLInk = driver.findElement((By.partialLinkText("Start a free")));
        freeTrialLInk.click();

        WebElement enterEmail = driver.findElement(By.id("page-v1-step1-email"));
        enterEmail.sendKeys("admin@admin.com");

        WebElement gdprConsentCheckbox = driver.findElement(By.name("gdpr_consent_checkbox"));
        gdprConsentCheckbox.click();

        // in Case of Button " Create a Free Trial Account' there is no id, name and unique class name
        // here class name is Dynamic Element class = "button W(100%) btn-model - form - submit" ,
        // if it open in the tab , its class name changes based on the resolution like button(70%)  eg ; ipad
        // in this case will go with Xpath, css selector , or custom selector

        // if you want click on the button any way use find elements

        List<WebElement> buttonList = driver.findElements(By.tagName("button"));
        buttonList.get(0).click();   // consider need to click on first index button

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // to verify the error message , so if check there is no unique locators like id , name , class name , but the class name for this attribute is first one

        WebElement errorMsgEmailExist = driver.findElement(By.className("invalid-reason"));  // we can mention partial class name also, as its first attribute
        System.out.println(errorMsgEmailExist.getText());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }
}
