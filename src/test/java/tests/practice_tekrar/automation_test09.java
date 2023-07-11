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

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully(Ana sayfanın başarıyla görüntülendiğini doğrulayın.)
        WebElement homePage = driver.findElement(By.xpath(" //*[text()=' Home' ]"));
       // WebElement homepage=driver.findElement(By.xpath("//section[@id='slider']"));
        Assert.assertTrue(homePage.isDisplayed());

        //4. Click on 'Products' button('Ürünler' düğmesine tıklayın.)
        driver.findElement(By.linkText("//i[@class='fa fa-envelope']")).click();

        //5. Verify user is navigated to ALL PRODUCTS page successfully( Kullanıcının başarıyla TÜM ÜRÜNLER sayfasına yönlendirildiğini doğrulayın.)

        WebElement allProducts=driver.findElement(By.className("features_items"));
        Assert.assertTrue(allProducts.isEnabled());
        //6. Enter product name in search input and click search button(Arama girişine ürün adını girin ve arama düğmesine tıklayın.)
        WebElement searchInput = driver.findElement(By.id("searchInput"));
        searchInput.sendKeys("ürün adı");

        WebElement searchButton = driver.findElement(By.id("searchButton"));
        searchButton.click();
        //7. Verify 'SEARCHED PRODUCTS' is visible('ARANAN ÜRÜNLER' görünür olup olmadığını doğrulayın.)
        WebElement searchedProducts = driver.findElement(By.cssSelector(".search-results"));

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
