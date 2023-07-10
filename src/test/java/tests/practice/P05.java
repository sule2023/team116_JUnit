package tests.practice;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static tests.practice.P03.driver;

public class P05 {
    @Test
    public void paraKarsilastir(){
        driver.get("https://www.google.com");
        WebElement searchbox= driver.findElement(By.xpath("//*[@id='APjFqb']"));
        //Arama işlemini gerçekleştirelim
        searchbox.sendKeys("usd to tl"+ Keys.TAB);
        driver.findElement(By.xpath("(//input[@class='gNO89b'])[2]")).click();
        WebElement resultElement= driver.findElement(By.xpath("//*[@class='DFlfde SwHCTb']"));
        String result=resultElement.getText().replaceAll(",",".");
        double sonuc =Double.parseDouble(result);
        Assert.assertTrue(sonuc<27.0);
        if (sonuc<27){
            System.out.println("Çok şükür 27 olmadı daha");
        }else{
            System.out.println("Allah Yardımcımız olsun");
        }
    }
    @After
    public void tearDown(){driver.close();}
}
