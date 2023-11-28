package day18_jsexecutor_log4j;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JsExecutorSetAttribute extends TestBase {
    @Test
    public void test01() {
        //amazona gidelim
        driver.get("https://amazon.com");
        waitForSecond(1);
        driver.navigate().refresh();

        //jsexecutor ile arama kutusuna selenium yazdiralim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='selenium'",searchBox);

        /*
        eger sendkeys ile bir webelemente text gönderemezsek yukarida yazmis oldugumuz kod sayesinde bunu yapabiliriz
         */
        searchBox.submit();
    }

    @Test
    public void test02() {
        //amazona gidelim
        driver.get("https://amazon.com");

        //jsexecutor ile arama kutusuna selenium yazdiralim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        //jsSendKeys(searchBox,"selenium");
    }

    @Test
    public void setAttribute() {

        //amazon sayfasina gidelim
        driver.get("https://amazon.com");


        //arama kutus id attribute degerini ismimiz ile degistirelim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('id','mehmet')",searchBox);

        //degistirmis oldugumuz id ile arama kutusunu locate ederek java aratalim
        driver.findElement(By.id("mehmet")).sendKeys("java");

    }



}
