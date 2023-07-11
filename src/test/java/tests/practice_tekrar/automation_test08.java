package tests.practice_tekrar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class automation_test08 extends TestBase {
    @Test
    public void test01(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement hp=driver.findElement(By.xpath("//section[@id='slider']"));
        Assert.assertTrue(hp.isDisplayed());
        //4. Click on 'Products' button
        driver.findElement(By.xpath("//*[text()=' Products']")).click();
        //5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProducts=driver.findElement(By.className("features_items"));
        Assert.assertTrue(allProducts.isEnabled());
        //6. The products list is visible
        WebElement allProducts1=driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(allProducts1.isDisplayed());
        //7. Click on 'View Product' of first product
        //  WebElement viewProduct=driver.findElement(By.xpath("//a[@href='/product_details/1']"));
        //viewProduct.click();
        bekle(5);
        WebElement firstProduct=driver.findElement(By.xpath("//*[text()='View Product'][1]"));
        firstProduct.click();
        //8. User is landed to product detail page
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='product-information']")).isEnabled());
        //9. Verify that detail  is visible: product name, category, price, availability, condition, brand
        WebElement productName=driver.findElement(By.xpath("//*[text()='Blue Top']"));
        WebElement category=driver.findElement(By.xpath("//*[text()='Category: Women > Tops']"));
        WebElement price=driver.findElement(By.xpath("//*[text()='Rs. 500']"));
        WebElement availability=driver.findElement(By.xpath("//*[text()='Availability:']"));
        WebElement condition=driver.findElement(By.xpath("//*[text()='Condition:']"));
        WebElement brand=driver.findElement(By.xpath("//*[text()='Brand:']"));
        if (productName.isDisplayed()& category.isDisplayed()& price.isDisplayed()& availability.isDisplayed()& condition.isDisplayed()& brand.isDisplayed()){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }
        // diger cevabi
        // Assert.assertTrue(productName.isDisplayed());
        //        Assert.assertTrue(category.isDisplayed());
        //        Assert.assertTrue(price.isDisplayed());
        //        Assert.assertTrue(availability.isDisplayed());
        //        Assert.assertTrue(condition.isDisplayed());
        //        Assert.assertTrue(brand.isDisplayed());
    }

    }

