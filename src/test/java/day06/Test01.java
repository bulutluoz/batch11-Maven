package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test01 {

    //1-Test01 isimli bir class olusturun
    //2- https://www.walmart.com/ adresine gidin
    //3- Browseri tam sayfa yapin
    //4-Sayfayi “refresh” yapin
    //5- Sayfa basliginin “Save” ifadesi icerdigini control edin
    //6-Sayfa basliginin “Walmart.com | Save Money.Live Better” a esit oldugunu control ediniz
    //7- URL in walmart.com icerdigini control edin
    //8-”Nutella” icin arama yapiniz
    //9- Kac sonuc bulundugunu yaziniz
    //10-Sayfayi kapatin
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //2- https://www.walmart.com/ adresine gidin

        driver.get("https://www.walmart.com/");
        //3- Browseri tam sayfa yapin
        driver.manage().window().maximize();
        //4-Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //5- Sayfa basliginin “Save” ifadesi icerdigini control edin
        String actualTitle=driver.getTitle();
        String arananKelimeTitle="Save";
        if (actualTitle.contains(arananKelimeTitle)){
            System.out.println("Title testi PASS");
        } else {
            System.out.println("Title testi FAILED");
            System.out.println("Sayfa basligi \"" + arananKelimeTitle + "\" icermiyor");
        }


        //6-Sayfa basliginin “Walmart.com | Save Money.Live Better” a esit oldugunu control ediniz
        String expectedTitle="Walmart.com | Save Money.Live Better";
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title Walmart testi PASS");
        } else {
            System.out.println("Title Walmart testi FAILED");
            System.out.println("Actual Title : " +actualTitle);
            System.out.println("Expected Title : " + expectedTitle);

        }

        //7- URL in walmart.com icerdigini control edin
            String actualURL=driver.getCurrentUrl();
            String arananKelime ="walmart.com";
            if (actualURL.contains(arananKelime)){
                System.out.println("URL testi PASS");
            } else {
                System.out.println("URL testi FAILED");
            }

        //8-”Nutella” icin arama yapiniz
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement aramaCubugu=driver.findElement(By.cssSelector("input[id='global-search-input']"));
        String aramaKelimesi = "Nutella";
        aramaCubugu.sendKeys(aramaKelimesi+ Keys.ENTER);
        //aramaCubugu.submit();

        //9- Kac sonuc bulundugunu yaziniz
        //WebElement sonucYazisi=driver.findElement(By.className("result-summary-container"));
        //System.out.println(sonucYazisi.getText());

        //System.out.println(driver.findElement(By.className("result-summary-container")).getText());
        //75 ve 76.satirlar yerine 78.satirdaki gibi tum islemleri tek bir satirda yaptirabiliriz
        // ancak kodun anlasilmasi acisindan bu sekilde yazim tavsiye edilmez


        //10-Sayfayi kapatin
        driver.close();

    }
}
