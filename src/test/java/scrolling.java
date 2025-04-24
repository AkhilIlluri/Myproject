import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class scrolling {
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.flipkart.com");
        driver.manage().window().maximize();
        JavascriptExecutor scrolling=(JavascriptExecutor)driver;
        Thread.sleep(4000);
        scrolling.executeScript("window.scrollBy(0,1000)");
       // scrolling.executeScript("window.scrollTo(document.body.scrollHeight,0)");
    }
}
