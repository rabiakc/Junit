package day18_jsexecutor_log4j;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_JsExecutorLocate extends TestBase {

    @Test
    public void test01() {

        //https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html   adresine gidelim
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html");


        //Hello Shadow DOM elementini locate edelim
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement helloShadowDomWe = (WebElement) js.executeScript("return document.getElementById('content');");
        Assert.assertEquals("Hello Shadow DOM",helloShadowDomWe.getText());

    }

    @Test
    public void amazonTest() {
        //amazon a gidin
        driver.get("https://amazon.com");


        //arama kutusunda selenium yazin
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("selenium");

        /*
        <input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off" placeholder="Search Amazon"
        class="nav-input nav-progressive-attribute" dir="auto" tabindex="0" aria-label="Search Amazon" spellcheck="false">
         */

        //arama kutusuna basarili bir sekilde yazinin gönderildigini test edin

        JavascriptExecutor js = (JavascriptExecutor) driver;

        String searchBoxValue =js.executeScript("return document.getElementById('twotabsearchtextbox').value").toString();
        System.out.println("searchBoxValue = " + searchBoxValue);
        Assert.assertEquals("selenium",searchBoxValue);



        String typeAttributeDegeri =js.executeScript("return document.getElementById('twotabsearchtextbox').type").toString();
        System.out.println(typeAttributeDegeri);

        String nameAttributeDegeri =js.executeScript("return document.getElementById('twotabsearchtextbox').name").toString();
        System.out.println(nameAttributeDegeri);


        String classAttributeDegeri =js.executeScript("return document.getElementById('twotabsearchtextbox').className").toString();
        System.out.println(classAttributeDegeri);

    }

}
