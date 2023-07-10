package tests.day11_excelOtomasyon;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C04_GetScreenshotTumSayfa extends TestBase {
    @Test
    public void test01() throws IOException {
        // amazon ana sayfaya gidin
        driver.get("https://www.Amazon.com");
        // nutelle icin arama yaptirin
        WebElement aramaKutusu  = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        //  sonuclarin nutella icerdigini test edin
        WebElement sonucElementi  = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal'] "));
        String expectedIcerik = "Nutella";
        String actuelSonucYazisi =sonucElementi.getText();
        TakesScreenshot tss = (TakesScreenshot) driver;// ekran goruntumuzu almasini sagladik
        // tum sayfa foto almak icin dort adima ihtycmz var;
        //1.adim driveri takeScreenshot objesine cast edelim.
        // 2.adim ekran resminin kaydedilecegi bir file olusutralim
        File tumSayfaSS = new File("target\\ekranScrenshot\\tumsayfaSS.png");
        // 3.adim yukardaki  olusan tss objesini aullara scheenshot alalim ve gecici bir dosyay kaydelerim
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);
        // 4.adim gecici dosyayi olusturdugumuz tumSayfaSS e kopyalayim
        FileUtils.copyFile(geciciDosya,tumSayfaSS);

        Assert.assertTrue(actuelSonucYazisi.contains(expectedIcerik));


    }


}
