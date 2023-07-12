package tests.practice_tekrar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.sql.Driver;
import java.time.Duration;

public class automation_test10 extends TestBase {


    @Test
    public void Test10() {
           //1. Launch browser(Tarayıcıyı başlatın.)
           //2. Navigate to url 'http://automationexercise.com'('http://automationexercise.com' adresine gidin.)
            driver.get("http://automationexercise.com");
            //3. Verify that home page is visible successfully(Ana sayfanın başarıyla görüntülendiğini doğrulayın.)
            driver.findElement(By.xpath("//section[@id='slider']"));
            WebElement HomePage=driver.findElement(By.xpath("//section[@id='slider']"));
            Assert.assertTrue(HomePage.isDisplayed());
            System.out.println("Home PAGE : testi PASSED");

            //4. Scroll down to footer(Altbilgiye doğru aşağı kaydır)
            // not bu ksisimda Javascrip  sitesinden to footer icin gererkli argumeni almalisin
           JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
           jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

            bekle(3);
            //5. Verify text 'SUBSCRIPTION'('SUBSCRIPTION' metnini doğrula)
            WebElement textSubscription = driver.findElement(By.xpath("//*[text()='Subscription']"));
            Assert.assertTrue(textSubscription.isDisplayed());


             //6. Enter email address in input and click arrow button( E-posta adresini girip ok tuşuna bas)
            //WebElement emailAdres=  driver.findElement(By.xpath("//input[@placeholder='Email']"));//yukardeki  mail adrsi
             WebElement emailAdres = driver.findElement(By.id("susbscribe_email"));
             emailAdres.sendKeys("sule@gmail.com"+Keys.ENTER);

            //7. Verify success message 'You have been successfully subscribed!' is visible
            //WebElement yazi=driver.findElement(By.xpath("//div[@class='status alert alert-success']"));
            //Assert.assertTrue(yazi.isDisplayed());
            Assert.assertTrue(driver.findElement(By.id("success-subscribe")).isDisplayed());



    }

}

