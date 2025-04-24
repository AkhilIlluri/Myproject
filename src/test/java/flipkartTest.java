import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import java.util.List;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class flipkartTest  {
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();


        WebDriver driver=new ChromeDriver();
        driver.get("https://www.flipkart.com");
        WebElement searchElement=driver.findElement(By.name("q"));
        searchElement.sendKeys("laptops");
        searchElement.submit();
        Thread.sleep(4000);
        //driver.close();
        //String expectedUrl="https://www.flipkart.com/search?q=laptops&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off";

        //WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(200));
        //wait.until(ExpectedConditions.urlToBe(expectedUrl));
        List<WebElement> laptops=driver.findElements(By.cssSelector("div._75nlfW"));
        System.out.println(laptops.size());
        for (WebElement Ele:laptops){
            System.out.println(Ele.getText());
            System.out.println("");
        }

    }
}


