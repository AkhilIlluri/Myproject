import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import  org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class mouseHover {
    public static void main(String[] args) throws  IOException,InterruptedException {

        // Set the ChromeDriver location
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.flipkart.com");
        try {
            WebElement closePopup = driver.findElement(By.xpath("//button[contains(text(),'✕')]"));
            closePopup.click();
        } catch (Exception e) {
            System.out.println("Login popup not found.");
        }

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(200));
        String CurrentUrl=driver.getCurrentUrl();
        wait.until(ExpectedConditions.urlToBe(CurrentUrl));

        //Thread.sleep(4000);
        Actions action = new Actions(driver);

        WebElement fashionEle = driver.findElement(By.xpath("//span[text()='Fashion']"));
        // TakesScreenshot srcScreenshot=(TakesScreenshot) driver;
        // File newScreenshot=srcScreenshot.getScreenshotAs(OutputType.FILE);
        // FileUtils.copyFile(newScreenshot,new File("destination/flipkart.png"));


        action.moveToElement(fashionEle).perform();

        WebElement childEle = driver.findElement(By.xpath("//a[contains(text(),'Top Wear')]"));
        action.moveToElement(childEle).perform();
        WebElement all=driver.findElement(By.xpath("//a[text()='All']"));
        action.moveToElement(all).doubleClick().perform();
        try {
            driver.navigate().back();


            WebElement closePopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'✕')]")));
            closePopup.submit();
        } catch (Exception e) {
            System.out.println("Login popup not found.");
        }
        TakesScreenshot srcScreenshot=(TakesScreenshot) driver;
        File newScreenshot=srcScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(newScreenshot,new File("destination/screen.png"));


    }
}

