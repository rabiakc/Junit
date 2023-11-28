package day19_jsexecutor_log4j;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_JsExecutorStyle extends TestBase {

    @Test
    public void test01() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");
        waitForSecond(1);
        driver.navigate().refresh();
        //aramakutusunun style özelliklerini degistirelim
        WebElement searcBox = driver.findElement(By.id("twotabsearchtextbox"));
        searcBox.sendKeys("selenium");

        //searchBox webelementinin etrafina 5 pixel kalinliginda kırmızı bir cerceve ekledik
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='5px solid red'",searcBox);


        //searchBox webelementinin arkaplan rengini yesil yaptik
        js.executeScript("arguments[0].style.backgroundColor='green'",searcBox);

        //searcBox webelementinin metin rengini beyaza cevirdik
        js.executeScript("arguments[0].style.color='white'",searcBox);



        //sayfanin ekran görüntüsünü alalim
        screenShot();


    }
}
