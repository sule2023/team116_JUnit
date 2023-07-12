package tests.practice_tekrar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class automation_test10 {
    static WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }
    @After
    public void tearDown(){driver.close();}

    @Test
    public void Test10(){
        //1. Launch browser(Tarayıcıyı başlatın.)
        //2. Navigate to url 'http://automationexercise.com'('http://automationexercise.com' adresine gidin.)
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully(Ana sayfanın başarıyla görüntülendiğini doğrulayın.)
        driver.findElement(By.xpath("//section[@id='slider']"));



        //4. Scroll down to footer(Sayfanın alt kısmına doğru kaydırın.)
        //scrollDown(driver);
        WebElement footer = driver.findElement(By.id("footer"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footer);

        //5. Verify text 'SUBSCRIPTION'('ABONELİK' metninin görünürlüğünü doğrulayın.)
        WebElement subscriptionText = driver.findElement(By.xpath("//div[contains(text(), 'SUBSCRIPTION')]"));


        //6. Enter email address in input and click arrow button(Giriş kutusuna e-posta adresini girin ve ok işaretli düğmeye tıklayın.)
       driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("abc@yahoo.com");






        //7. Verify success message 'You have been successfully subscribed!' is visible('Başarıyla abone oldunuz!' mesajının görünür olduğunu doğrulayın.)
        WebElement successMessage = driver.findElement(By.xpath("//div[contains(text(), 'You have been successfully subscribed!')]"));
        if (successMessage.isDisplayed()) {
            System.out.println("'Başarıyla abone oldunuz!' mesajı görünür.");
        } else {
            System.out.println("'Başarıyla abone oldunuz!' mesajı görünürken bir hata oluştu.");
        }



     /*
       // 4. Adım: Sayfayı aşağı kaydırın
        scrollDown(driver);

        // 5. Adım: 'SUBSCRIPTION' metnini doğrulayın
        Assert.assertTrue("'SUBSCRIPTION' metni görüntülenemedi.", isElementVisible(driver, By.xpath("//h2[text()='SUBSCRIPTION']")));

        // 6. Adım: E-posta adresini girin ve ok düğmesine tıklayın
        WebElement emailInput = driver.findElement(By.id("email")); // E-posta giriş alanının ID'sini buraya ekleyin
        emailInput.sendKeys("example@example.com"); // E-posta adresini buraya ekleyin

        WebElement arrowButton = driver.findElement(By.className("arrow")); // Ok düğmesinin CSS sınıfını buraya ekleyin
        arrowButton.click();

        // 7. Adım: Başarı mesajının görüntülendiğini doğrulayın
        Assert.assertTrue("Başarı mesajı görüntülenemedi.",
                isElementVisible(driver, By.xpath("//div[contains(text(),'You have been successfully subscribed!')]")));

      */








    }
}


