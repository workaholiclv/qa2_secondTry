import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;

//Training Nr.1.

//Creating main class
public class DelfiFiveTitlesComparison {

        // Xpath definition for delfi.lv desktop version and mobile version
        private final By deskArticles = By.xpath(".//a[@class = 'top2012-title']");

        // Titles to check from delfi.lv
        private String titleOne = ("Lidlauka 'Spilve' juridisko 'kalambūru' Rīgas dome atrisinās ar buldozeru");
        private String titleTwo = ("Futbola 'toto' skandāla četri gadi: ilgstoša izmeklēšana un tiesas pats sākums");
        private String titleThree = ("Tramps: ASV izstāšanos no kodollīguma motivējusi arī Ķīnas arsenāla stiprināšana");
        private String titleFour = ("Cīņu par VID ģenerāldirektora amatu turpina trīs pretendenti");
        private String titleFive = ("Foto: Lidojums ar 'Boeing' angārā jeb ieskats 'airBalticTraining'");

        // Test component from Junit
        @Test
        public void delfiTitlesCheck() {

// Location of the driver for browser on your local machine
                System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriver");
// Driver variable        
                WebDriver driver = new ChromeDriver();
// Adding full screen option to open browser in full screen mode       
                driver.manage().window().fullscreen();
// Resource location which we will be using in test
                driver.get("http://delfi.lv");

// Creating array and adding all articles to array
                List<String> articleTitles = new ArrayList<String>();
                articleTitles.add(titleOne);
                articleTitles.add(titleTwo);
                articleTitles.add(titleThree);
                articleTitles.add(titleFour);
                final boolean add = articleTitles.add(titleFive);

// Creating list with articles from xPath of delfi.lv desktop version        
                List<WebElement> articles = driver.findElements(deskArticles);

                for (int i = 0; i < 5; i++) {
                        articles.get(i);

// Comparing titles from variable articleTitles (given) to articles from array which we created previously
                        Assertions.assertEquals(articleTitles.get(i), articles.get(i).getText(), "Articles not equals");
                }
        }
}