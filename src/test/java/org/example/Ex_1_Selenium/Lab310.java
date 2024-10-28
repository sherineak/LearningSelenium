package org.example.Ex_1_Selenium;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Lab310 {
    public static void main(String[] args) {

        //Normal - Wait for all resources to download - 80% usage
        //If not specify any setPageLoadStrategy like previous class 'Lab309' its by default normal

        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com/#/login");
        System.out.println(driver.getTitle());
        driver.quit();

    }
}
