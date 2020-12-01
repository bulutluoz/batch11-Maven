package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
//1) Bir class oluşturun: YoutubeAssertions
//2) https://www.youtube.com adresine gidin
//3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri 	yapin
//	titleTest => Sayfa başlığının “YouTube” oldugunu test edin
//	imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
//	Search Box 'in erisilebilir oldugunu test edin (isEnabled())
//  wrongTitleTest=> Sayfa basliginin “youtube” olmadigini dogrulayin

public class AssertionHomeWork {
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com");
    }

    @Test
    public void titleTest(){
        //	titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        String actualTitle=driver.getTitle();
        String expectedTitle="YouTube";
        Assert.assertEquals(expectedTitle,actualTitle);

    }
    @Test
    public void imageTest(){
        //	imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement logo=driver.findElement(By.xpath("(//div[@id='logo-icon-container'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void searchBoxTest(){
        //	Search Box 'in erisilebilir oldugunu test edin

        WebElement link=driver.findElement(By.xpath("//div[@id='search-container']"));
        Assert.assertTrue(link.isEnabled());
    }

    @Test
    public void wrongTitleTest(){
        //  wrongTitleTest=> Sayfa basliginin “youtube” olmadigini dogrulayin
       String actualTitle=driver.getTitle();
       String istenmeyenTitle="youtube";
       Assert.assertFalse(actualTitle.equals(istenmeyenTitle));
    }



    @AfterClass
    public static void tearDown(){
        driver.close();
    }

}