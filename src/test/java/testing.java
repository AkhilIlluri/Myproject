import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class testing {
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();
        WebElement input=driver.findElement(By.id("file-upload"));
        input.sendKeys("C:/Users/91918/Downloads/QaAkhil.pdf");
        WebElement submit=driver.findElement(By.id("file-submit"));
        submit.submit();
        System.out.println(driver.getTitle());
    }
}
//file:///C:/Users/91918/Downloads/QaAkhil.pdf
