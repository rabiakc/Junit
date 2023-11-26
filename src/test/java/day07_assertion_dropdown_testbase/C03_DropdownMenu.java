package day07_assertion_dropdown_testbase;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_DropdownMenu {
    /*
    Dropdown --> Altbasliklarin oldugu acilir menu listesidir. Dropdown u automate etmek icin
    1- Drowdown menuyu locate edeceğiz
    2- Select objesi olustururuz
    3- Select objesini kullanarak  bazi methodlar ile istedigimiz seceneğe erisim saglariz
    SYNTAX
    Select select = new Select(Dropdown webelement)
    a- selectByVisibleText() ->  Dropdown menudeki elemente gorunen metin ile ulasmak icin kullanilir
    b- selectByIndex() -> Index ile ulasmak icin kullanilir (index 0 (sifir) dan baslar)
    c- selectByValue() -> value attribute deegeri ile ulasmak icin kullanilir (option tagi ile baslar)
    4- getOptions() -> Locate ettigimiz dropdown menu deki tum secenekleri bize verir
    5- getFirstSelectedOption() -> Dropdown menudeki secili olan seceneği bize verir
     */


/*
   Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
   -3 farklı test methodu oluşturalım
       1.Method:
           a. Yil,ay,gün dropdown menu'leri locate ediniz
           b. Select objesi olustur
           c. Select object i kullaarak 3 farkli sekilde secim yapiniz
       2.Method:
           a. Tüm eyalet isimlerini yazdıralım
       3.Method:
           a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim

    */

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void test01() {
        //           a. Yil,ay,gün dropdown menu'leri locate ediniz
        WebElement yil = driver.findElement(By.xpath("//select[@id='year']"));
        WebElement ay = driver.findElement(By.xpath("//select[@id='month']"));
        WebElement gun = driver.findElement(By.xpath("//select[@id='day']"));

        //           b. Select objesi olustur
        Select selectYil = new Select(yil);
        Select selectAy = new Select(ay);
        Select selectGun = new Select(gun);


        //           c. Select object i kullaarak 3 farkli sekilde secim yapiniz
        selectYil.selectByIndex(5); //index 0 dan basladigi icin 5 yazdigiimzda 6 inci element secilr
        selectAy.selectByValue("4");//<option value="4">4</option> buradaki value atribute degerine gore secilir
        selectGun.selectByVisibleText("15");//ekranda gorulen degere gore secilir
    }

    @Test
    public void test02() {
        //  a. Tüm eyalet isimlerini yazdıralım
        WebElement eyaletlerDropDown =  driver.findElement(By.xpath("//*[@id='state']"));
        Select select = new Select(eyaletlerDropDown);
        List<WebElement> eyaletlerListesiWebElement = select.getOptions();

        for ( WebElement w :  eyaletlerListesiWebElement   ) {
            System.out.println(w.getText());
        }

        //ikinci yol
        // eyaletlerListesiWebElement.forEach(t-> System.out.println(t.getText()));
    }

    @Test
    public void test03() {
        List<WebElement> eyaletlerListesiWebElement = driver.findElements(By.xpath("//*[@id='state']/option"));
        eyaletlerListesiWebElement.forEach(t-> System.out.println(t.getText()));
    }

    @Test
    public void test04() {
        //  a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim
        WebElement eyaletlerDropDown =  driver.findElement(By.xpath("//*[@id='state']"));
        Select select = new Select(eyaletlerDropDown);
        String expectedOption ="Select a State";
        String actualOption =select.getFirstSelectedOption().getText();
        System.out.println("actualOption = " + actualOption);
        Assert.assertEquals(expectedOption,actualOption);

    }

    @Test
    public void test05() {
        //genelde dropdown webelementine sendKeys() methodu ile seceneklerden bir tanesini göndererek te secim yapabiliriz
        WebElement eyaletlerDropDown =  driver.findElement(By.xpath("//*[@id='state']"));
        eyaletlerDropDown.sendKeys("Alabama");

    }

    @After
    public void tearDown() throws Exception {
        // driver.close();
    }















}
