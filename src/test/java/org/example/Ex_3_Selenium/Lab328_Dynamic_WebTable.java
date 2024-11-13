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

public class Lab328_Dynamic_WebTable {
    WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions Options = new EdgeOptions();
        Options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        //Options.addArguments("--start-maximized");
        Options.addArguments("--guest"); // Avoid popups
        driver = new EdgeDriver(Options);
    }

    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testDynamicWebTable() {
        driver.manage().window().maximize();
        String URL = "https://awesomeqa.com/webtable1.html";
        driver.get(URL);
        System.out.println(driver.getTitle());

        // //table[@summary = 'Sample Table']/tbody/tr       Xpath for custom element
        // //table[@class='tsc_table_s13']/tbody/tr           can use class for xpath if class is not a dynamic web element
        // find table
        // find row
        //find size of row

        WebElement table = driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody"));  // to get table
        List<WebElement> row_table  = table.findElements(By.tagName("tr"));
        System.out.println(row_table.size());

        //To print data
        for (int i =1 ; i< row_table.size() ; i++){
            List<WebElement> col = row_table.get(i).findElements(By.tagName("td"));
            for(WebElement c : col){
                System.out.println(c.getText());
            }


        }





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
