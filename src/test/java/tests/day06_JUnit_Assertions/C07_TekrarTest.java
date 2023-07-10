package tests.day06_JUnit_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_TekrarTest {
    //1) Bir class oluşturun: BestBuyAssertions
    //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak
    //asagidaki testleri yapin
    //○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    //○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    //○ logoTest => BestBuy logosunun görüntülendigini test edin
    //○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
   static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/ ");

    }

    @Test
    public void BestBuyAssertionsTesti(){


        String expectedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);


    }
    @Test
    public void titeltesti(){
        String expectedtitel = "Rest";
        String actualtitel = driver.getTitle();
        Assert.assertNotEquals(expectedtitel,actualtitel);

    }
    @Test
    public void logotest(){
        //○ logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logoTest = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logoTest.isDisplayed());
    }
    @Test
    public void  FrancaisLinkTest(){
        //○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement Francaislinkelementi = driver.findElement(By.xpath("//button[@lang='fr']"));
        Assert.assertTrue(Francaislinkelementi.isDisplayed());
    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }

}
