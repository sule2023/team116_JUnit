package tests.day05_maven_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ZerroWebApp {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
        //2. Signin buttonuna tiklayin
        driver.findElement(By.id("signin_button")).click();
        //3. Login alanine  “username” yazdirin
        WebElement loginKutusu= driver.findElement(By.id("user_login"));
        loginKutusu.sendKeys("username");
        //4. Password alanina “password” yazdirin
        WebElement passwordKutusu= driver.findElement(By.id("user_password"));
        passwordKutusu.sendKeys("password");
        //5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        //6. Back tusu ile sayfaya donun
        driver.navigate().back();
        //7. Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.id("pay_bills_link")).click();
        //8. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement yatirilanMiktar =driver.findElement(By.id("sp_amount"));
        yatirilanMiktar.sendKeys("100");

        //9. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.id("sp_date")).sendKeys("19-6-23");
        //10. Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();
        //1.1. “The payment was successfully submitted.” mesajinin ciktigini test edin
        // testedin dedgi  icin if kullnyrz

        WebElement mesajElement = driver.findElement(By.id("alert_content"));
        String actualElement = mesajElement.getText();
        String expectedMessage = "The payment was successfully submitted.";

        if (actualElement.equals(expectedMessage)){
            System.out.println("Submit mesaj test PASSED");
        }else{
            System.out.println("Submit mesaj test FAILED");

        }




     driver.close();



    }
}
