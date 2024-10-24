package org.example.ex_Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Lab299 {
    public static void main(String[] args) {
        // Important concepts of OOPs
        // Interface interfaceRef = new Class();
        //1. Inheritance
        //2. Upcasting -> Dynamic Dispatch (Grand father Interface can have object of child class)
        // WebDriver is Grand father , EdgeDriver, ChromeDriver etc are Object Child class

        WebDriver driver = new EdgeDriver();
        WebDriver driver1 = new ChromeDriver();
        WebDriver driver2 = new FirefoxDriver();
        WebDriver driver3 = new InternetExplorerDriver();
        WebDriver driver4 = new SafariDriver();

        // Opera is removed from selenium.

        //-- Edge ---
        // SearchContext(Interface) (2 function)
        //-> webDriver(I) (10)
        //-> RemotewebDriver(Class) (15)
        //-> ChromiumDriver (C)25
        //-> EdgeDriver(c) (45)

        // -- Chrome
        // SearchContext(Interface) (2 function)
        //-> webDriver(I) (10)
        //-> RemotewebDriver(Class) (15)
        //-> ChromiumDriver (C)25
        //-> ChromeDriver(c) (45)

         //Selenium - Architecture - API
        // Create Session, commands or function --> API request to Browser Drive
        //pass the commands as API


    }
}
