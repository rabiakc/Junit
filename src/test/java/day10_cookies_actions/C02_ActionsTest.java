package day10_cookies_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_ActionsTest extends TestBase {

    @Test
    public void actions() {

        //https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");


        //Kutuya sag tıklayın
        WebElement box = driver.findElement(By.cssSelector("#hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(box).perform();
        //Kullandigimiz action i isleme almasi icin perform() methodunu kullanmamiz gerekiyor


        //Alert'te cikan yazinin"You selected a context menu"oldugunu test edin
        String expectedResult ="You selected a context menu";
        String actualdResult = driver.switchTo().alert().getText();
        Assert.assertEquals("Actual Result ile Expected Result uyumlu degil",expectedResult,actualdResult);

        //Tamam diyerek alert'i kapatın
        driver.switchTo().alert().accept();

    }

}
