package tests.practice;

import org.junit.Test;

public class P01 {

    /*
    @BeforeClass rotasyonu: testen once 1 kez calisip tum ayarlari yapar her teste surekli  calismaz
       biz test yazdigimizda yapacagimiz test kodlarini calistrck , sadece bir kez calisip devam edecek
    @Before : her test basinda her kez calisacak
    @AfterClas : butun testler bitince 1 kez calisir
    @After: her testin sonunda calisacak
     */

    @Test
    public void Ali(){System.out.println("Ali");}
    @Test
    public void Sule(){System.out.println("sule");}
    @Test
    public void Said(){System.out.println("Said");}


}
