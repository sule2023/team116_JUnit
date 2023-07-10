package tests.day10_waits_cookies_webTables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C01_ExplicitlyWait {
    //1. Bir class olusturun : WaitTest
    //2. Iki tane metod olusturun : implicitWait() , explicitWait()
    //  Iki metod icin de asagidaki adimlari test edin.
    //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //4. Remove butonuna basin.
    //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    //6. Add buttonuna basin
    //7. It’s back mesajinin gorundugunu test edin


    @Test
    public void implicitlyWaitTest(){
        WebDriverManager.chromedriver().setup();// sirketlerde farkli  drver verrse onu kuklanyrz
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[text()='Remove']"));
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itisGoneElementi = driver.findElement(By.xpath("//*[text()=“It’s gone!“]"));
        Assert.assertTrue(itisGoneElementi.isDisplayed());
        //6. Add buttonuna basin
        driver.findElement(By.xpath("/*[text()=“Add”]")).click();
        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackElementi =driver.findElement(By.xpath("//*[text()=“It’s back!]"));
        Assert.assertTrue(itisGoneElementi.isDisplayed());
        driver.close();



    }
    @Test
    public void ExpilictlyWaitTEst(){
        WebDriverManager.chromedriver().setup();// sirketlerde farkli  drver verrse onu kuklanyrz
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().window().maximize();
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[text()='Remove']"));
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
        /*
        visibilityOf() methodu bize iki senecek sunar;eger
        webelenti locate edebiliyorak once locat edip sonra istenen condition icin beklemesini isteyebiliriz.
        eger kullancagimiz elementi  locate edemiyorsa ozamn locate islemi ile bekleme islemini birlikte yapabiliriz
         */
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's gone!\"]")));
        WebElement itsGoneElementi = driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));
        Assert.assertTrue(itsGoneElementi.isDisplayed());
        //6. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()=\"Add\"]")).click();
        //7. It’s back mesajinin gorundugunu test edin
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's back!\"]")));
        WebElement itsBackElementi = driver.findElement(By.xpath("//*[text()=\"It's back!\"]"));
        Assert.assertTrue(itsBackElementi.isDisplayed());
        driver.close();
    }
}
