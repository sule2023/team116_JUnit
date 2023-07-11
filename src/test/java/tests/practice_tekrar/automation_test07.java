package tests.practice_tekrar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class automation_test07 extends TestBase {
    @Test
    public void test01(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement hp=driver.findElement(By.xpath("//section[@id='slider']"));
        Assert.assertTrue(hp.isDisplayed());

        //4. Click on 'Test Cases' button
        driver.findElement(By.xpath("  //*[text()=' Test Cases']")).click();
        //5. Verify user is navigated to test cases page successfully
        WebElement testCasesPage=driver.findElement(By.xpath("//section[@id='form']"));
        Assert.assertTrue(testCasesPage.isEnabled());

    }
}


