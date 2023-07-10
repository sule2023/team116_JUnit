package tests.day05_maven_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class C11_TekrarTesti {
    WebDriver driver;
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
 @Test
    public void Test01(){
        //amazon gidiniz
     driver.get("https://www.amazon.com");
     // arama sonuclari  nutelle iceriyormu
     WebElement sonucyaziElementi  = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
     String actualYaziStr = sonucyaziElementi.getText();
     String expectedBulunacakKelime = "Nutella";
     Assert.assertTrue(actualYaziStr.contains(expectedBulunacakKelime));


 }


}
