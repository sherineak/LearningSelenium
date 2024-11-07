package org.example.Ex_3_Selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Lab317 {
    WebDriver driver;
    //EdgeDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions Options = new EdgeOptions();
        Options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        Options.addArguments("--start-maximized");
        Options.addArguments("--guest"); // Avoid popups
        driver = new EdgeDriver(Options);


    }

    @Test(groups ="QA")
    @Description("Test Case Description")
    public void testCssSelector(){



        //  navigate to the url - https://www.ebay.com/b/Desktops-All-In-One-Computers/171957/bn_1643067
        driver.get("https://www.ebay.com/b/Desktops-All-In-One-Computers/171957/bn_1643067");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();


        //different ways to find Search element using CSS Slector given below
        //input[id="gh-ac"]   -> tagName[attributeName= value]
        //     -> # for Id
        //input[id="gh-ac"] -> //input[@id="gh-ac"]  convertion of css Selector to XPath


        //WebElement searchBox = driver.findElement(By.xpath("//input[@id='gh-ac']"));

        //WebElement searchBox1 = driver.findElement(By.cssSelector("#gh-ac")); // using ID
        //searchBox1.sendKeys("macmini");
        WebElement searchBox = driver.findElement(By.cssSelector("input[id='gh-ac']"));
        searchBox.sendKeys("macmini"); // // Find macmini

        // Click on search
        //.gh-spr     // partial class name with . for CSS Selector
        //input[value='Search']  - css Selector

        WebElement buttonSearch = driver.findElement(By.cssSelector(".gh-spr ")); //using class
        buttonSearch.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // print all the titles
        //.s-item__title

        List<WebElement> searchTitle = driver.findElements(By.cssSelector(".s-item__title")); // class name
        List<WebElement> searchTitlePrice = driver.findElements(By.cssSelector(".s-item__price"));

//        for(WebElement title : searchTitle){
//            System.out.println(title.getText());
//
//        }
//        for(WebElement prices : searchTitlePrice){
//            System.out.println(prices.getText());
//        }

        // to print side by side
        // Ensure both lists are of the same size to avoid IndexOutOfBoundsException
        int size = Math.min(searchTitle.size(),searchTitlePrice.size());// here count of search title = 62 and search title price = 63 so find the min value, if count same no issues if know correct size for (int i =0 ; i< searchTitle.size();i++
        for (int i =0 ; i < size ; i++){
            System.out.println("Title:"+ searchTitle.get(i).getText()+ "||" + "price:" + searchTitlePrice.get(i).getText());
        }

       //contains img[title*="Flip"]
       //starts with img[title^ ="Flip"]
       //ends with img[title$ = "kart"]

        // Select -> simple, custom Select (div, ui - li) - different approach

        // Why do we need Waits in selenium
        //Thread.sleep() - its worst one , it will be delay  , it tells JVM to stop to execution
        // do this thread.seep

        //Implicit wait - bad


    }

    @AfterTest
    public void closeBrowser(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }
}
