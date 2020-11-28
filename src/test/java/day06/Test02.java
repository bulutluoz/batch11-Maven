package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test02 {
    //1. http://zero.webappsecurity.com sayfasina gidi
    // 2. Signin buttonuna tiklayi
    // 3. Login alanine  “username” yazdirin
    // 4. Password alanine “password” yazdirin
    // 5. Sign in buttonuna tiklayin
    // 6. Pay Bills sayfasina gidin
    // 7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
    // 8. tarih kismina “2020-09-10”
    // 9. Pay buttonuna tiklayin
    // 10. “The payment was successfully submitted.” mesajinin ciktigini control edin
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        // 2. Signin buttonuna tiklayin
        driver.findElement(By.id("signin_button")).click();

        // 3. Login alanine  “username” yazdirin
        WebElement userNameTexBox = driver.findElement(By.id("user_login"));
        userNameTexBox.sendKeys("username");
        // 4. Password alanine “password” yazdirin
        WebElement passwordTextBox=driver.findElement(By.id("user_password"));
        passwordTextBox.sendKeys("password");
        // 5. Sign in buttonuna tiklayin
        driver.findElement(By.name("submit")).click();
        // 6. Pay Bills sayfasina gidin
        driver.findElement(By.linkText("Pay Bills")).click();

        // 7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amauntTextBox= driver.findElement(By.id("sp_amount"));
        amauntTextBox.sendKeys("250");

        // 8. tarih kismina “2020-09-10”
        WebElement tarihKutusu=driver.findElement(By.id("sp_date"));
        tarihKutusu.sendKeys("2020-09-10");

        // 9. Pay buttonuna tiklayin

        driver.findElement(By.id("pay_saved_payees")).click();
        // 10. “The payment was successfully submitted.” mesajinin ciktigini kontrol edin

        WebElement basariliYazisi=driver.findElement(By.id("alert_content"));
        if (basariliYazisi.isDisplayed()){
            System.out.println("havale basarili yazisi testi PASS");
        } else {
            System.out.println("havale basarili yazisi testi FAILED");
        }
        driver.close();
    }

}
