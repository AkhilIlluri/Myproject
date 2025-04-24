import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotExplanation  {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver=new EdgeDriver();
        driver.get("https://qadraganddrop.ccbp.tech/");
        Thread.sleep(4000);
        TakesScreenshot loginSrc=(TakesScreenshot)driver;
        File loginScreenshot=loginSrc.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(loginScreenshot,new File("destination/screenshot.png"));
        System.out.println("Hi Akhil");
        System.out.println("modified");
    }
}
