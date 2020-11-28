package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test03 {
    //1. “https://www.saucedemo.com” Adresine gidin
    //2. Username kutusuna “standard_user” yazdirin
    //3. Password kutusuna “secret_sauce” yazdirin
    //4. Login tusuna basin
    //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
    //6. Add to Cart butonuna basin
    //7. Alisveris sepetine tiklayin
    //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
    //9. Sayfayi kapatin

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");
        //2. Username kutusuna “standard_user” yazdirin
        WebElement usernameKutusu=driver.findElement(By.id("user-name"));
        usernameKutusu.sendKeys("standard_user");

        //3. Password kutusuna “secret_sauce” yazdirin
        WebElement passwordKutusu=driver.findElement(By.id("password"));
        passwordKutusu.sendKeys("secret_sauce");

        //4. Login tusuna basin
        driver.findElement(By.id("login-button")).click();

        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin

        WebElement ilkUrun=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        String ilkUrunAdi=ilkUrun.getText();
        ilkUrun.click();

        //6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//button[@class='btn_primary btn_inventory']")).click();

        //7. Alisveris sepetine tiklayin
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//span[@class='fa-layers-counter shopping_cart_badge']")).click();

        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement sepettekiUrun=driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        String sepettekiUrunIsmi=sepettekiUrun.getText();
        if (ilkUrunAdi.equals(sepettekiUrunIsmi)){
            System.out.println("alisveris sepeti testi PASS");
        } else {
            System.out.println("alisveris sepeti testi FAILED");
            System.out.println("Sectigim urun ile sepetteki urun ayni degil");
        }


        //9. Sayfayi kapatin
        driver.close();

    }
}
