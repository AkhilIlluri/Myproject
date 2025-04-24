import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class caterXpert{
    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        // Set the path to the ChromeDriver executable
        WebDriver driver = new ChromeDriver();

        // Navigate to the login page
        driver.get("tps://catapps.aquilasoftware.com/CaterXpert.action");

        WebElement catererId= driver.findElement(By.id("CatererId"));
        catererId.sendKeys("chefstablecat");

        WebElement userId= driver.findElement(By.id("UserName"));
        userId.sendKeys("superadmin");

        WebElement password= driver.findElement(By.xpath("/html/body/div[1]/table[2]/tbody/tr/td[5]/table[1]/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td[1]/input"));
        password.sendKeys("Super2024#");

        WebElement button=driver.findElement(By.xpath("/html/body/div[1]/table[2]/tbody/tr/td[5]/table[1]/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td[2]/input"));
        //WebElement button=driver.findElement(By.xpath("//@input[value='go']"));
        button.click();

        String expectedUrl="https://catapps.aquilasoftware.com/CaterXpert2025_0303/homepage/appAuthenticate.action";
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        String CurrrentUrl =driver.getCurrentUrl();
        System.out.println(CurrrentUrl);

        driver.switchTo().frame("header");
        WebElement homebutton =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/table/tbody/tr/td[3]/table/tbody/tr/td/a[1]/img")));
        homebutton.click();
        String homePgaeUrl="https://catapps.aquilasoftware.com/CaterXpert2025_0303/homepage/appAuthenticate.action";
        wait.until(ExpectedConditions.urlToBe(homePgaeUrl));
        driver.switchTo().frame("right");
        WebElement accounting=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/center/form[1]/table[1]/tbody/tr[1]/td/table/tbody/tr[1]/td[1]/div/table/tbody/tr[2]/td/table/tbody/tr[1]/td/a")));
        accounting.click();







    }
}
