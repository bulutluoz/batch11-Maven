package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Assertion {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.techproeducation.com");
    }

    @Test
    public void positiveTest(){
        // Sayfa basligininin TECPROED icerdigini test ediniz
        String arananKelime="TECHPROED";
        String actualTitle=driver.getTitle();

        Assert.assertTrue(actualTitle.contains(arananKelime));
    }


    @Test
    public void negativeTest(){
        //Sayfa basliginin Mehmet kelimesi icermedigini test ediniz
    String arananKelime="Mehmet";
    String actualTitle=driver.getTitle();
    Assert.assertFalse(actualTitle.contains(arananKelime));

    }

    @Test
    public void equalsTest(){
        // Sayfa basliginin TECHPROED | SDET | Java Developer | Web Developer | DevOps Engineer oldugunu test ediniz
        String actualTitle=driver.getTitle();

        String expectedTitle="TECHPROED | SDET | Java Developer | Web Developer | DevOps Engineer";
        Assert.assertEquals(expectedTitle,actualTitle);
        System.out.println("Bu yazi yazilacak mi ?");
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}
