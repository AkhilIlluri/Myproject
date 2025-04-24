import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.util.List;

public class dropdown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
        driver.manage().window().maximize();
        Thread.sleep(4000);

// Switch to iframe


// Select dropdown by visible text
        WebElement dropdown = driver.findElement(By.tagName("select"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("India");
        select.selectByIndex(10);
        driver.get("https://www.flipkart.com");
        driver.navigate().back();
        String  handle=driver.getWindowHandle();
        driver.switchTo().window(handle);


    }
}
