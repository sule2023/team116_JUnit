package tests.day05_maven_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C09_TekrarTesti_google {
    WebDriver driver;
    @Test
    public void googleTesti(){

    setup();
        //1- C01_TekrarTesti isimli bir class olusturun
        //2- https://www.google.com/ adresine gidin
        //3- cookies uyarisini kabul ederek kapatin
        //4- Sayfa basliginin “Google” ifadesi icerdigini test edin
        //5- Arama cubuguna “Nutella” yazip aratin
        //6- Bulunan sonuc sayisini yazdirin
        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        //8- Sayfayi kapatin

        driver.get("https://www.google.com");







    }
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

}
