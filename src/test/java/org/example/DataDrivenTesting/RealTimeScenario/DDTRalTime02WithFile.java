package org.example.DataDrivenTesting.RealTimeScenario;

import org.example.DataDrivenTesting.ExcelReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class DDTRalTime02WithFile {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @Test(dataProvider = "LoginData")
    public void testDataDriven( String email, String password, String expectedResult) throws InterruptedException {
        driver.get("https://app.vwo.com");
        Thread.sleep(4000);
        WebElement emailElement = driver.findElement(By.id("login-username"));
        emailElement.clear();
        emailElement.sendKeys(email);

        WebElement passwordElement = driver.findElement(By.id("login-password"));
        passwordElement.clear();
        passwordElement.sendKeys(password);
        driver.findElement(By.id("js-login-btn")).click();

        if(expectedResult.equalsIgnoreCase("Valid")){
            String text = String.valueOf(driver.findElement(By.cssSelector("[data-qa = \"lufexuloga\"]")).getText());
            Thread.sleep(4000);
            System.out.println(text);
            Assert.assertEquals(text,"Sherine Antony");
        }
        if(expectedResult.equalsIgnoreCase("Invalid")){
           WebElement error_message =  driver.findElement(By.id("js-notification-box-msg"));
           WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(2));
           wait.until(ExpectedConditions.visibilityOf(error_message));
           Assert.assertTrue(( error_message).isDisplayed());
           Assert.assertEquals(((WebElement) error_message).getText(),"Your email, password, IP address or location did not match");
        }
    }


//    @DataProvider(name = "LoginData")
//    public Object[][] testData(){
//        return new Object[][]{
//                {"TD1","sherine","Welcome@1231", "Invalid"},
//                {"TD1","sherineak@gmail.com","Welcome@123", "valid"}
//        };
//    }
    @DataProvider(name = "LoginData")
public Object[][] testDataExcel() throws IOException {
        String testDataFile = "src/test/java/org/example/DataDrivenTesting/Resources/Test Data.xlsx";
        ExcelReader excelReader = new ExcelReader(testDataFile);
        String[][] data = excelReader.getDataFromSheet(testDataFile,"Login");
        return data;
}
@AfterTest
    public void tearDown(){
        driver.quit();
}

}
