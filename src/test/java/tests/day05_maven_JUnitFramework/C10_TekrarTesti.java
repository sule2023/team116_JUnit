package tests.day05_maven_JUnitFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C10_TekrarTesti {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.example.com");

        // Örneğin, bir Webelement'in metin içeriği
        WebElement webelement = driver.findElement(By.id("element_id"));
        String metin = webelement.getText();

        // Sadece rakam değerlerini içeren bir metin oluşturmak için regex kullanabilirsiniz
        String sadeceRakamlar = metin.replaceAll("[^0-9]", "");

        // Sadece rakam değerlerini içeren metni yazdırma
        System.out.println(sadeceRakamlar);

        driver.quit();
    }
}

