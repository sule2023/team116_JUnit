package tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P03 {
    static WebDriver driver;
    WebElement searchbox;
    WebElement result;
    //BeforeClass ile driver'i oluşturun ve class icinde static yapin
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window();
        //Maximize edin ve 10 sn bekletin

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @AfterClass
    public static void tearDown(){driver.quit();}
    @Before
    public void before(){
        driver.get("http://www.qooqle.com ");
        // her teste buraya gidecek
        driver.findElement(By.xpath("//div[text()='Tümünü reddet']")).click(); // Cookie den kurtulduk
    }


    //Maximize edin ve 10 sn bekletin
    //http://www.qooqle.com adresine gidin
    //1-arama kutusuna "12 Angry Men" yaz ip, cikan sonuc şayisini yazdinin
    //2-arama kutusuna "Vizontele" yaz ip, cikan sonuc şayisini yazdirin
    //3-arama kutusuna "Saving Private Ryan" yaz4p, cikan sonuc şayisini yazdirin
    //AfterClass ile kapatin.

}
