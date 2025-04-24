import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class flip {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com");

        // Close login popup
        try {
            WebElement closePopup = driver.findElement(By.xpath("//button[contains(text(),'✕')]"));
            closePopup.click();
        } catch (Exception e) {
            System.out.println("Login popup not found.");
        }

        // Hover on "Fashion"
        Actions actions = new Actions(driver);
        WebElement fashionMenu = driver.findElement(By.xpath("//span[text()='Fashion']"));
        actions.moveToElement(fashionMenu).perform();

        // Hover on "Men's Top Wear"
        WebElement mensTopWear = driver.findElement(By.xpath("//a[contains(text(),'Top Wear')]"));
        actions.moveToElement(mensTopWear).perform();

         //Optionally, click the sub-category (e.g., T-Shirts)
         WebElement tShirts = driver.findElement(By.xpath("//a[text()='All']"));
         tShirts.click();

        // Just for demo, wait before closing


    }
}
