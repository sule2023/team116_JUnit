package tests.practice_tekrar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

public class automation_test09 extends TestBase {


    @Test
    public  void Test09(){

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully(Ana sayfanın başarıyla görüntülendiğini doğrulayın.)
        WebElement homepage=driver.findElement(By.xpath("//section[@id='slider']"));
        Assert.assertTrue(homepage.isDisplayed());

        //4. Click on 'Products' button('Ürünler' düğmesine tıklayın.)
        driver.findElement(By.xpath("//*[text()=' Products']")).click();


        //5. Verify user is navigated to ALL PRODUCTS page successfully( Kullanıcının başarıyla TÜM ÜRÜNLER sayfasına yönlendirildiğini doğrulayın.)
        WebElement ALLPRODUCTS=driver.findElement(By.className("features_items"));
        Assert.assertTrue(ALLPRODUCTS.isEnabled());

        //6. Enter product name in search input and click search button(Arama girişine ürün adını girin ve arama düğmesine tıklayın.)
        WebElement searchInput = driver.findElement(By.id("search_product"));
        searchInput.sendKeys("etek");

        WebElement searchButton = driver.findElement(By.xpath("//button[@type='button']"));
        searchButton.click();


        //7. Verify 'SEARCHED PRODUCTS' is visible('ARANAN ÜRÜNLER' görünür olup olmadığını doğrulayın.)
        WebElement searchedProducts = driver.findElement(By.xpath("//*[text()='Searched Products']"));
        Assert.assertTrue(searchedProducts.isDisplayed());



        //8. Verify all the products related to search are visible( Aramayla ilgili tüm ürünlerin görünür olduğunu doğrulayın.)
        //  WebElement allproducts=driver.findElement(By.xpath(" //*[@class='features_items']"));
        WebElement allProducts=driver.findElement(By.className("features_items"));
        Assert.assertTrue(allProducts.isDisplayed());
        System.out.println("all products: testi passed");


        }






    }

