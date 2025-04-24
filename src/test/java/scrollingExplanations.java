import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.edge.EdgeDriver;

public class scrollingExplanations  {
    public  static  void main(String[] args) throws InterruptedException{
        WebDriverManager.edgedriver().setup();
        WebDriver driver=new EdgeDriver();
        driver.get("https://qadraganddrop.ccbp.tech/");
        Thread.sleep(4000);
        JavascriptExecutor scroll= (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollTo(0,document.body.scrollHeight)");



    }
}
