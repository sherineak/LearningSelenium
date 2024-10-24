package org.example.ex_Selenium;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Lab300 {
    public static void main(String[] args) {
        SearchContext driver = new EdgeDriver(); // Dynamic dispatch or runtime polymorphism

        // it possible , but here only 2 functions with SearchContext, so not much used
        //driver.findElement();
        //driver.findElements();

       // WebDriver driver1 = new EdgeDriver();
        // driver.get 12 functions

        //RemoteWebDriver driver2 = new EdgeDriver();
        //30  function

        //EdgeDriver driver3 = new EdgeDriver();
        // 40 plus functions

        // The three scenarios

        //1. Do want to run on Chrome or Edge?   - 10 % only using this scenario
        ChromeDriver driver1 = new ChromeDriver();
        EdgeDriver driver2 = new EdgeDriver();

        //2. Do you want to run on chrome then change to Edge?  - 90 %
        WebDriver driver3 = new ChromeDriver();
        driver3 = new EdgeDriver();

        //3. Do you want to run on multiple browsers?
        // Remote WebDriver(with Grid ) - Advance (Last 2 sessions )


    }
}
