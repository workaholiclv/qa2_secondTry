package lesson7.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BaseFunc {
    WebDriver driver;

    public BaseFunc() {
        System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void openPageByUrl(String url) {
        if (!url.contains("http://") && !url.contains("https://")) {
            url = "http://" + url;
        }
        driver.get(url);
    }

    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    public WebElement getElement(By locator) {
        Assertions.assertFalse(getElements(locator).isEmpty(), "There is no elements!");
        return driver.findElement(locator);
    }
}
