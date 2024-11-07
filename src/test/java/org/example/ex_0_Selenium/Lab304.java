package org.example.ex_0_Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Lab304 {
    public static void main(String[] args) throws MalformedURLException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://sdet.live");

        // No Back , forward allowed in case of get

        driver.navigate().to("https://app.vwo.com");
        driver.navigate().to(new URL("https://google.com"));
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }
}
