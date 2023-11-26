package day13_seleniumwaits_exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C04_TimeOutException extends TestBase {
    /*
    TimeOutException

    Explicit wait kullanildiginda ve webelement bulunamadiginda alinan bir hatadir, implictlywait te sure yeterli olmazsa
    NoSuchElementException aliriz

    Eger TimeOutException aliyorsak
    1- Explicit wait te kullandigimiz maximum sureyi kontrol etmeliyiz
    2- Explicit wait te almis oldugumutz locate i kontrol etmeliyiz
    3- Explicit wait te kullandigimiz methodu kontrol etmeliyiz
    4- Explicit wait te locate ini aldigimiz webelement iframe icinde olabilir, dolayisiyla iframe e gecis yapmaliyiz
     */

    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();


        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorld = driver.findElement(By.xpath("//h4[.='Hello World!']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
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

        WebElement helloWorld = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.visibilityOfElementLocated(By.id("YANLIS LOCATE")));
        Assert.assertEquals("Hello World!", helloWorld.getText());
    }


}
