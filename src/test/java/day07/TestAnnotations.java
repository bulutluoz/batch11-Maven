package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAnnotations {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }

    @Test
    public void test01(){
        driver.get("https://www.techproeducation.com");
    }

    @Test
    @Ignore
    public void test02(){
        driver.get("https://www.google.com");
    }

    @Test
    public void test03(){
        driver.get("https://www.youtube.com");
    }

    @After
    public void tearDown(){
        driver.close();
    }


}
