package day09_iframe_windowhandle_basicauthentication;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Iframe extends TestBase {
    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        //Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
        String kalinYazi = driver.findElement(By.tagName("h3")).getText();
        Assert.assertTrue(kalinYazi.contains("Editor"));

        //Textbox içindeki yazıyı siliniz.
        driver.switchTo().frame("mce_0_ifr");
        WebElement textBox = driver.findElement(By.xpath("//p"));
        textBox.clear();

        //Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        textBox.sendKeys("Bu textbox iFrame içinde yer almaktadır");


        //Sayfadaki "Elemental Selenium" yazısının olduğunu doğrulayınız.
        driver.switchTo().defaultContent();
        //driver.navigate().refresh(); sayfayi yeniler ana sayfaya döner ama iframe icinde yapilan degisiklikler varsa bu ilk haline döneceği icin
        //kullanirken dikkatli olmaliyiz
        //driver.get(driver.getCurrentUrl());
        WebElement elementalSelenium = driver.findElement(By.xpath("//*[.='Elemental Selenium']"));
        Assert.assertEquals("Elemental Selenium",elementalSelenium.getText());

    }







}
