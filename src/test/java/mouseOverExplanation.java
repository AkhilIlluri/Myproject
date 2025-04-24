import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class mouseOverExplanation {
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.edgedriver().setup();
        WebDriver driver=new EdgeDriver();
        driver.get("https://www.flipkart.com");
        driver.manage().window().maximize();
        Thread.sleep(4000);
        Actions action=new Actions (driver);
        WebElement parent=driver.findElement(By.xpath("//span[text()='Fashion']"));
        action.moveToElement(parent).perform();
        WebElement child1= driver.findElement(By.xpath("//a[contains(text(),'Bottom Wear')]"));
        action.moveToElement(child1).perform();

        WebElement child2=driver.findElement(By.xpath("//a[contains(text(),'Cargos')]"));
        action.moveToElement(child2).click().perform();
    }
}
