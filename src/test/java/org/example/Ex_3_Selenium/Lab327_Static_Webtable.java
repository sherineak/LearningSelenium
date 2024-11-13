package org.example.Ex_3_Selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab327_Static_Webtable {
    WebDriver driver;

    //EdgeDriver driver;
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
    public void testWebTable() {

        driver.get("https://awesomeqa.com/webtable.html");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();

        //Print all the data in the table -P1
        // Helen belongs to which country  - p2


        //Dynamic Xpath
        // //table[@id='customers']/tbody/tr[2]/td[2]/following-sibling::td     --> Germany
        // //table[@id='customers']/tbody/tr[2]/td[2]/preceding-sibling::td     --> Google

        //Row - //table[@id='customers']/tbody/tr
        //col - //table[@id='customers']/tbody/tr[2]/td
        int row = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
        System.out.println(row);
        int col = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[2]/td")).size();
        System.out.println(col);

        //table[@id='customers']/tbody/tr[i]/td[j]/
        //i= 1 to 7  - row
        //j = 1 to 3 - column
        // In table there is no 0 index , table will start from 1 , it consider as cell

        // Xpath ->  //table[@id='customers']/tbody/tr[5]/td[2]
        // Xpath ->  //table[@id='customers']/tbody/tr[i]/td[j]

        //Dividing XPath
        // Xpath -  //table[@id='customers']/tbody/tr    - constant
        // i  - variable
        //]/td[  - constant
        // j     - variable
        //]   - constant

        //below three are constant parts
        String first_part = "//table[@id='customers']/tbody/tr[";
        String second_part = "]/td[";
        String third_part = "]";

        for (int i = 2; i <= row; i++) { // first row need to skip, first is header , not data
            for (int j = 1; j <= col; j++) {
                String dynamic_xpath = first_part + i + second_part + j + third_part;
                System.out.println(dynamic_xpath);
                String data = driver.findElement(By.xpath(dynamic_xpath)).getText();
                System.out.println(data);

                if(data.contains("Helen Bennett")){
                    String country_path = dynamic_xpath +"/following-sibling::td";
                    String country_text = driver.findElement(By.xpath(country_path)).getText();
                    System.out.println("Helen Country in " +country_text);

                    String company_path = dynamic_xpath + "/preceding-sibling::td";
                    String company_text = driver.findElement(By.xpath(company_path)).getText();
                    System.out.println("Helen Company in " +company_text);


                }

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

