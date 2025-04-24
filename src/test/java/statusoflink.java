import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class statusoflink {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");


        WebDriver driver = new ChromeDriver(options);
        driver.get("https://flipakrt.com");

        List<WebElement> links = driver.findElements(By.tagName("a"));

        for (WebElement link : links) {
            String url = link.getDomAttribute("href");
            if (url != null && !url.isEmpty()) {
                checkLink(url);
            }
        }

        driver.quit();
    }

    public static void checkLink(String linkUrl) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(linkUrl).openConnection();
            connection.setConnectTimeout(3000);
            connection.connect();

            int statusCode = connection.getResponseCode();
            String message = connection.getResponseMessage();

            if (statusCode == 200) {
                System.out.println(linkUrl + " is OK (Status: " + statusCode + ")");
            } else {
                System.out.println(linkUrl + " is broken (Status: " + statusCode + ", " + message + ")");
            }
        } catch (Exception e) {
            System.out.println(linkUrl + " is broken. Error: " + e.getMessage());
        }
    }
}

