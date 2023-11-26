package day15_screenshot_extentreport;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_ScreenShotClassWork extends TestBase {
    @Test
    public void test01() {

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Ana sayfanın başarıyla yüklendiğini doğrula.
        String expectedUrl="https://techproeducation.com/";
        Assert.assertEquals(expectedUrl,driver.getCurrentUrl());

        //Sayfanın ekran görüntüsünü alin
        screenShot();

        //Sayfada görüntülenen telefon numarasinin +1 585 304 29 59 oldugunu dogrulayin
        WebElement phoneNumber = driver.findElement(By.xpath("(//a[.='+1 585 304 29 59'])[1]"));
        Assert.assertEquals("+1 585 304 29 59",phoneNumber.getText());
        screenShotOfWebElement(phoneNumber);

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();

        //Techpro ana sayfasi en altta logonun görüntülendigini dogrulayin
        WebElement logo = driver.findElement(By.xpath("//img[@class='footerLogo']"));
        Assert.assertTrue(logo.isDisplayed());

        //logonun ekran goruntusunu alalım
        screenShotOfWebElement(logo);
        
    }

    @Test
    public void amazonSearchBox() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Ve sayfanın resmini alalım
        screenShot();

        //Arama kutusuna metin göndererek ekran goruntusun alalim
        WebElement searchBox =driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("RABİA");
        screenShotOfWebElement(searchBox);
    }
}
