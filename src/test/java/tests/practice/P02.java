package tests.practice;

import org.junit.*;

public class P02 {
    @BeforeClass
    public static void beforeClass(){
        System.out.println(" Test sureci basliyor .Before calss calisti");
    }
    @AfterClass
    public static void afterClass() {
        System.out.println(" Tum testler run edildi .After class  calisti");
    }
    @Before
    public void before(){
        System.out.println("---Yeni  bir test calisiyor---");
    }
    @After
    public void after(){
        System.out.println(" Test sonlandiriyor .Sirdaki  teste geciyor ");
    }
    @Test
    public void Test01(){
        System.out.println("1 numarali  test calistiriliyor");
    }
    @Test
    public void Test02(){
        System.out.println("2 numarali  test calistiriliyor");
    }

}
