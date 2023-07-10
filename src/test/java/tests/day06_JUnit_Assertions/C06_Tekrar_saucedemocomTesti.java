package tests.day06_JUnit_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_Tekrar_saucedemocomTesti {

    //1. “https://www.saucedemo.com Adresine gidin
    //        2. Username kutusuna “standard_user” yazdirin
    //        3. Password kutusuna “secret_sauce” yazdirin
    //        4. Login tusuna basin
    //        5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
    //        6. Add to Cart butonuna basin
    //        7. Alisveris sepetine tiklayin
    //        8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
    //        9. Sayfayi kapatin


    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.saucedemo.com");

    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }
    @Test
    public void test(){

        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");

    }
    @Test
    public void test2(){
        //3. Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

    }
    @Test
    public void test3(){
        //4. Login tusuna basin
        driver.findElement(By.xpath("//input[@id=\"login-button\"]")).click();

    }
    @Test
    public void test4(){
        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement Ilkurun= driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        Ilkurun.click();
    }
    @Test
    public void test5(){
        //6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
    }
    @Test
    public void test6(){
        //7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    }
    @Test
    public void test7(){
        ////8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement sepet= driver.findElement(By.xpath("//div[@class='cart_item_label']"));
        Assert.assertTrue(sepet.isEnabled());

    }
}
