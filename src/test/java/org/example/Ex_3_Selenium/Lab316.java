package org.example.Ex_3_Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Lab316 {
    public void testVerifyCssSelector(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver=new EdgeDriver();
        //driver.get("https://katalon-demo-cura.herokuapp.com");
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com");
        System.out.println(driver.getTitle());

        // CSS Selectors are used to select elements in an HTML or XML Document
        // in order to apply styles or other manipulations to those elements.

        //Normal Selector                          --> Css Selector
        // Core Logic   - xpath - //tagName[@attribute = value]     css Selector - tagName[attribute = value]
        //BY.id -> #id
        //className -> .class
        //custom Attribute -> input type = "text" data-qa= "abc"/>   --> [data-qa="abc"]
        //can convert xpath to css Selector also

        //css Selectors
        //function contains -  Xpath contains() -> *
        //function starts-with() - xpath -> ^
        //function end - with-> $


    }
}
