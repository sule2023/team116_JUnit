package tests.day05_maven_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_JUnikOtamatikRaporlama {
    /*
        Junit framework'unde
        bir class veya test method'u calistirildiginda
        JUnit tum class veya istenen method'un
        sorunsuz olarak sonuna kadar calisip calismadigini kontrol eder
        - sorunsuz calisirsa test PASSED
        - kodlar sorun ciktigi icin calistirilamazsa test FAILED
        olarak isaretlenir
        Eger if-else ile yaptigimiz testlerde
        JUnit'in raporlarinin da test sonuclari ile uyumlu olmasini isterseniz
        FAILED durumlarinda throw keyword ile herhangi bir exception olustuttabiliriz.
     */

    @Test
    public void amazontesti(){
        // amazona gidelim ve url icerdigini test edip
        // sayfayi  kapatalim
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
        String ecpectedUrlicerik = "Ramazon";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(ecpectedUrlicerik)){
            System.out.println("Amazon testi  gecti");
        }else {
            System.out.println("Amazon testi kaldi");
            throw new RuntimeException();
        }
        driver.close();


    }
    @Test
    public void wisequarterTesti(){
        // Wise quarter anasayfaya gidip
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.wisequarter.com");
        // Title'in Wise Quarter icerdigini test edin
        String expectedTitleIcerik = "Wise Quarter";
        String actualTitle= driver.getTitle();
        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Wise Quarter title testi PASSED" );
        }else{
            System.out.println("Wise Quarter title testi FAILED" );
            throw new RuntimeException();
        }
        // ve sayfayi kapatin
        driver.close();
    }
}
