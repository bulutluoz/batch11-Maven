package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WallmartSearchTest {
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.walmart.com/");
    }

    @Test
    public void titleSaveArama(){
        String actualTitle=driver.getTitle();
        String arananKelimeTitle="Saven";
        if (actualTitle.contains(arananKelimeTitle)){
            System.out.println("Title testi PASS");
        } else {
            System.out.println("Title testi FAILED");
            System.out.println("Sayfa basligi \"" + arananKelimeTitle + "\" icermiyor");
        }
    }

    @Test
    public void TitleEsitMi(){
        String actualTitle=driver.getTitle();
        String expectedTitle="Walmart.com | Save Money.Live Better";
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title Walmart testi PASS");
        } else {
            System.out.println("Title Walmart testi FAILED");
            System.out.println("Actual Title : " +actualTitle);
            System.out.println("Expected Title : " + expectedTitle);

        }
    }

    @Test
    public void urlTesti(){
        String actualURL=driver.getCurrentUrl();
        String arananKelime ="walmart.com";
        if (actualURL.contains(arananKelime)){
            System.out.println("URL testi PASS");
        } else {
            System.out.println("URL testi FAILED");
        }
    }

    @Test
    public void nutellaTesti(){
        WebElement aramaCubugu=driver.findElement(By.cssSelector("input[id='global-search-input']"));
        String aramaKelimesi = "Nutella";
        aramaCubugu.sendKeys(aramaKelimesi+ Keys.ENTER);
        //aramaCubugu.submit();

        //9- Kac sonuc bulundugunu yaziniz
        WebElement sonucYazisi=driver.findElement(By.className("result-summary-container"));
        System.out.println(sonucYazisi.getText());
        driver.navigate().back();
    }



    @AfterClass
    public static void tearDown(){
        driver.close();
    }

}
