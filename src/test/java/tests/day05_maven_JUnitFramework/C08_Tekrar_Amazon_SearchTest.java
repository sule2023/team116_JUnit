package tests.day05_maven_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08_Tekrar_Amazon_SearchTest {
    /*
    Class Work Amazon Search Test
1- https://www.amazon.com/ sayfasina gidelim
2- arama kutusunu locate edelim
3- “Samsung headphones” ile arama yapalim
4- Bulunan sonuc sayisini yazdiralim
5- Ilk urunu tiklayalim
6- Sayfadaki tum basliklari yazdiralim

     */
    WebDriver driver;

    @Test
    public void amazonTesti() {
        setup();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Samsung Headphones");
        driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']")).click();
        WebElement sonucSayisi = driver.findElement(By.xpath("//span[text()='1-16 of 198 results for']"));
        System.out.println("Arama Sonuc Sayisi: " + sonucSayisi.getText());
        driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();
        driver.findElement(By.id("productTitle"));
        System.out.println(driver.getTitle());
        driver.close();
    }
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
}

