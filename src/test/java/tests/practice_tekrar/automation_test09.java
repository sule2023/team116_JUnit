package tests.practice_tekrar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class automation_test09 {

    static WebDriver driver;
    @Before
    public void setUp(){
        //1. Launch browser(Tarayıcıyı başlatın.)
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @After
    public void tearDown(){driver.close();}
    @Test
    public  void Test09(){

        //2. Navigate to url 'http://automationexercise.com'('http://automationexercise.com' URL'sine gidin.)
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully(Ana sayfanın başarılı bir şekilde görüntülendiğini doğrulayın)
        WebElement homePage = driver.findElement(By.xpath(" //*[text()=' Home' ]"));
        if (homePage.getText().equals("Home Page")) {
            System.out.println("Ana sayfa başarıyla yüklendi.");
        } else {
            System.out.println("Ana sayfa yüklenirken bir hata oluştu.");
        }
        //4. Click on 'Products' button('Ürünler' düğmesine tıklayın.)
        WebElement productsButton = driver.findElement(By.linkText("Products"));
        productsButton.click();
        //5. Verify user is navigated to ALL PRODUCTS page successfully( Kullanıcının başarıyla TÜM ÜRÜNLER sayfasına yönlendirildiğini doğrulayın.)
        WebElement allProductsPage = driver.findElement(By.cssSelector("h2"));
        if (allProductsPage.getText().equals("ALL PRODUCTS")) {
            System.out.println("TÜM ÜRÜNLER sayfasına başarıyla yönlendirildi.");
        } else {
            System.out.println("TÜM ÜRÜNLER sayfasına yönlendirilirken bir hata oluştu.");
        }
        //6. Enter product name in search input and click search button(Arama girişine ürün adını girin ve arama düğmesine tıklayın.)
        WebElement searchInput = driver.findElement(By.id("searchInput"));
        searchInput.sendKeys("ürün adı");

        WebElement searchButton = driver.findElement(By.id("searchButton"));
        searchButton.click();
        //7. Verify 'SEARCHED PRODUCTS' is visible('ARANAN ÜRÜNLER' görünür olup olmadığını doğrulayın.)
        WebElement searchedProducts = driver.findElement(By.cssSelector(".search-results"));
        if (searchedProducts.isDisplayed()) {
            System.out.println("'ARANAN ÜRÜNLER' bölümü görünür.");
        } else {
            System.out.println("'ARANAN ÜRÜNLER' bölümü görünür değil.");
        }
        //8. Verify all the products related to search are visible( Aramayla ilgili tüm ürünlerin görünür olduğunu doğrulayın.)
        List<WebElement> searchResults = driver.findElements(By.cssSelector(".search-results .product"));
        if (searchResults.size() > 0) {
            System.out.println("Arama sonuçları görünür.");
        } else {
            System.out.println("Arama sonuçları görünür değil.");
        }

        driver.quit();
    }
}
