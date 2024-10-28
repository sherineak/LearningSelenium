package org.example.Ex_1_Selenium;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Lab309 {
    public static void main(String[] args) {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        //Page load strategy EAGER, NONE, NORMAL
        //EAGER - partial or some resources
        //NONE - Don't wait for any resources
        //Normal - Wait for all resources to download - 80% usage
        //If not specify any setPageLoadStrategy its by default normal

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com/#/login");
        System.out.println(driver.getTitle());
        driver.quit();

    }
}
