package org.example.Ex_1_Selenium;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Lab308 {
    public static void main(String[] args) throws InterruptedException {
        EdgeOptions options = new EdgeOptions();
        // Browser - 1.Headless( NO UI) or 2.full mode
        //1. Headless - No UI, performance good , fast execution
        //2. Full Mode - UI , Performance Lag , >100

        //Options -> Browser -> to  start Maximize , add extension , add options or parameters, to open in the incognito mode(--incognito)

        //options.addArguments("--start-maximized");  // we can maximize using option class and through driver
        // options.addArguments("-window-size=800,600");
        options.addArguments("-inprivate");   // Edge Browser
        //options.addArguments("--incognito");  // chrome browser
        options.addArguments("--guest");  // remove the popup

        Proxy proxy = new Proxy();
        proxy.setHttpProxy("222.129.35.173:57114");
        options.setCapability("proxy", proxy); //to connected to set Proxy machine Like VPN and then access Internet, In VPN - we have to install VPN in our system



        WebDriver driver = new EdgeDriver(options); // need to pass options here ,
        driver.get("https://www.google.com");
        driver.manage().window().maximize();  //we can maximize using option class and through driver
        //driver.manage().window().minimize();

        Thread.sleep(8000);  // worst way to add a wait in the Script
        driver.quit();
    }
}
