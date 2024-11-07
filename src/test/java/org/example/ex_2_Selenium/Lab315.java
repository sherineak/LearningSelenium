package org.example.ex_2_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Lab315 {
    @Test
    public void testVerify(){

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest"); // if you want to remove popup
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com");


        // Default Locator Strategy - ID, Name, Class - Unique - Super good
        //Other wise can use XPath or CSS Selector
        //css Selector is little fast to Find Element
        // CSS Selector little fast previously, Nowdays since more ram -xpath = css selector
        // xpath or css Selector --> Converted to each vice
        //Css Selector - css Engine little fast to find the element

        // What is XPath?
        // Xpath is query language
        // for selecting nodes from an XML Document
        //HTML - xml type of document - tag based
        //Xapth is defined by w3c (World Wide Wide consortium)
        // All the major browsers understand and support it . W3C

        //Core Logic - //tagName[@attribute = 'value'
        // right click --> copy full xpath
        //html/body/div[3]/div[1]/div[2]/div/div[1]/div/div/div[3]/form[1]/ul/li[1]/div/input
             // Its too long  - it should be small
             // If any chane in div or html - Xpath doesn't work
             //NoBody use this Absolute XPath

        //Relative Xpath(with Query)
        //Core Logic - //tagName[@attribute = 'value']
        //       //input[@id="login-username"]
         //    //a[@href="./profile.php#login"]

        //    open the url - https://katalon-demo-cura.herokuapp.com/
    //    click on the make appoinment button

        //LOCATOR STRATEGY to find Elements
       // Always Go with ID = "txt-username" - unique
        //  then name = "username" - unique,
        //  the class = "form-control" Class name not unique - find Multiple
        //Link - partial - since it is not 'a ' tag , we can't use link text, partial link text
        // Relative Xpath
               // Function
               // Axes
               // Multiple attribute
        // || Css Selector


   //     WebElement btnElement_linkText = driver.findElement(By.linkText("Make Appointment")); // id is always fast//      WebElement btnElement_PLinkText = driver.findElement(By.partialLinkText("Make"));
    //    WebElement btnElement_ID = driver.findElement(By.id("btn-make-appointment"));
    //    WebElement btnElement_CN = driver.findElement(By.className("btn.btn-dark btn-lg")); // use class name space should replace with '.' or partial class name also work , but its not working as its common
          WebElement btnElement_xpath = driver.findElement(By.xpath("//a[@href='./profile.php#login']"));
          btnElement_xpath.click();

          //Multiple 'a' tag - not recommended
//        WebElement btnElement_TagName = driver.findElement(By.tagName("a"));  //Multiple 'a' tag - not recommended
//        btnElement_TagName.click();

        // locator through index for username
        List<WebElement> username_element = driver.findElements(By.xpath("//input[@placeholder='Username']"));
        username_element.get(1).sendKeys("John Doe");

        //    //*input[@placeholder=\"Username\" //This is slow, we are going to find the first all the elements
//        List<WebElement> username_element = driver.findElements(By.xpath("//*input[@placeholder='Username']"));
//        username_element.get(1).sendKeys("John Doe");

        //XPath functions  - Dynamic elements can be handled by these below functions
          //1. Contains()
          //2.Starts-with()
          //3.Text()

        // Where the XPath functions are useful?
        //They are useful when in the value - some are constant and dynamic
        // title = "Sherine_2323"
        //starts-with -> pramod, contains    // Partial Match
        //img[contains(@title,"Flip")]
        //img[starts-with(@title,"Flip")]
        //Substring after
        //normalize space - remove the space  eg: title = " sherine "

        //There is a another function
        //a[text()="Make Appointment"]        // Exact Match

        //Multiple Attributes
        // operators AND & OR
        //a[text()="Make Appointment" and contains(@id,"btn-make-appointment")]

        // XPath axes
        https://awesomeqa.com/xpath/
        //Go to the parent or child , when you know about the son

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        driver.quit();

    }
}
