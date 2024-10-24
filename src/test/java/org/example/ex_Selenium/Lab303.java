package org.example.ex_Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Lab303 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://sdet.live");

        //Interview Questions : quit vs Close()
//        Thread.sleep(5000);
//        driver.close();
        //Close the current browser Window
        //Not full browser
        //Session ID ! = Null

        Thread.sleep(5000);
        driver.quit();
        //Close all the / sessions /Windows and Stop the browser
        //Session = null , Error Session ID is NUll


    }
}
