package org.example.ex_Selenium;

import org.openqa.selenium.chrome.ChromeDriver;

public class Lab301 {
    public static void main(String[] args) {

//        //Selenium 3 .0
        //Json Wire Protocol
        // need to install WebDriver
//        ChromeDriver driver = new ChromeDriver();
//        System.setProperty("Webdriver.chrome.driver","/path/to/chromedriver");
//        driver.get("https://sdet.live");

        //Slenium 4
        //Selenium Manager - w3c Protocol
        //Opera removed
        ChromeDriver diver = new ChromeDriver();
        diver.get("https://sdet.live");

    }
}
