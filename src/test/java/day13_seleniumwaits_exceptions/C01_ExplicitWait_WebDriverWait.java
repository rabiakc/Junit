package day13_seleniumwaits_exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitWait_WebDriverWait extends TestBase {

    /*
    SELENIUM WAIT

    1) Implicitly Wait;
        Driver"i bir sayafaya gittikten sonra safyadaki tum webelementler ile etkilesime girebilmesi icin
        belirtmis olduğumuz max. süre kadar bekletir

    2) Explicit Wait
        a) WebDriverWait ;
            Sayfa yüklendikten sonra bir webelementin etkilesime girebilmesi icin max. belirtmis oldugumuz
            süre kadar ve default olarak yarim saniyelik araliklar ile bekler

            Ornegin bir webelemente tikladiktan sonra cikan bir webelement yada bir aler cikmasi testimizi
            calistirirken farkli sürelerde olusabilir, Bu süreyi tam olarak belirleyemedigimizden dolayi
            Thread.sleep () kullanmak profosyonelce olmaz.
            Bu gibi durumlarda Webdriver wait ile bir webelementin olusmasini bekletmek daha profosyonel ve
            dynamic olur

        b)  FluentWait
            Bir webelementin sayfa yüklendikten sonra etkilesime girebilmesi icin max. belirtilen sure kadar
            yine belirtebileceğimiz araliklarla bekler

     */


    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //  waitForSecond(7);==> artik mümkün mertebe bu beklemeyi kullanmamaliyiz

        //Hello World! Yazının sitede oldugunu test et

        /*
        1) Hello World! webelementi gorunur olana kadar beklemek icin bu webelementi locate ettik
        2) Webdriverwait objesi olustururz, ve constructor parantezi icinde driver ve Duration olarak drivera
        max. ne kadar bekletilsin bunu belirtiriz
        3) wait objemiz uzerinden senaryoya özel methodu seciyoruz ve yarim saniyelik araliklarla kontrol ederek
        bekledigimiz kosulun gerceklesmesini bekliyoruz

        ==>Boylece kosul gerceklesmesi durumunda driver i fazla bekletmeyerek dynamic beklemes yapims oluyoruz

         */

        WebElement helloWorld = driver.findElement(By.xpath("//h4[.='Hello World!']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(helloWorld));
        Assert.assertEquals("Hello World!", helloWorld.getText());

    }

    @Test
    public void test02() {

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et


        /*
        Locatini aldigimiz webelement gorunur olana kadar maximum 20 saniye bekle dedik,
        eger belirtilen sure icinde aranan element gorunur hale gelirse bu kod o webelementi bize verir,
        eger beklenen süre icerisinde gorunur olmaz ise o zamanda TimeOutException firlatilir
         */
        WebElement helloWorld = new WebDriverWait(driver,Duration.ofSeconds(20)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[.='Hello World!']")));

        Assert.assertEquals("Hello World!",helloWorld.getText());

    }

    @Test
    public void test03() {

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement loading =driver.findElement(By.xpath("//*[.='Loading... ']"));

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOf(loading));

        WebElement helloWorld = driver.findElement(By.xpath("//h4[.='Hello World!']"));
        Assert.assertEquals("Hello World!",helloWorld.getText());

    }

}
