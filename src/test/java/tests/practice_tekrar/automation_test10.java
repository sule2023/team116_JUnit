package tests.practice_tekrar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
        String expectedTitle = "Automation Exercise";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Ana sayfa başarıyla görüntülendi.");
        } else {
            System.out.println("Ana sayfa görüntülenirken bir hata oluştu.");
        }
        //4. Scroll down to footer(Sayfanın alt kısmına doğru kaydırın.)
        WebElement footer = driver.findElement(By.id("footer"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footer);

        //5. Verify text 'SUBSCRIPTION'('ABONELİK' metninin görünürlüğünü doğrulayın.)
        WebElement subscriptionText = driver.findElement(By.xpath("//div[contains(text(), 'SUBSCRIPTION')]"));
        if (subscriptionText.isDisplayed()) {
            System.out.println("'SUBSCRIPTION' metni görünür.");
        } else {
            System.out.println("'SUBSCRIPTION' metni görünürken bir hata oluştu.");
        }


        //6. Enter email address in input and click arrow button(Giriş kutusuna e-posta adresini girin ve ok işaretli düğmeye tıklayın.)
        WebElement emailInput = driver.findElement(By.id("email-input"));
        WebElement arrowButton = driver.findElement(By.id("arrow-button"));

        String emailAddress = "test@example.com";
        emailInput.sendKeys(emailAddress);
        arrowButton.click();

        //7. Verify success message 'You have been successfully subscribed!' is visible('Başarıyla abone oldunuz!' mesajının görünür olduğunu doğrulayın.)
        WebElement successMessage = driver.findElement(By.xpath("//div[contains(text(), 'You have been successfully subscribed!')]"));
        if (successMessage.isDisplayed()) {
            System.out.println("'Başarıyla abone oldunuz!' mesajı görünür.");
        } else {
            System.out.println("'Başarıyla abone oldunuz!' mesajı görünürken bir hata oluştu.");
        }












    }
}


