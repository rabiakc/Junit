package day18_jsexecutor_log4j;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_JsExecutorClick extends TestBase {

    @Test
    public void test01() {
        //amazona gidelim
        driver.get("https://amazon.com");
        waitForSecond(1);
        driver.navigate().refresh();

        //sell linkine tiklayalim
        WebElement sellLinki = driver.findElement(By.xpath("//*[.='Sell']"));
        sellLinki.click();

        /*
        ElementClickInterceptedException
        loate ini almis oldugumuz bir webelementin onunde baska bir webelement acilirsa
        ve bu webelemente click yapilamaz ise bu exception u aliriz
         */
        }

    @Test
    public void test02() {

        //amazona gidelim
        driver.get("https://amazon.com");
        waitForSecond(1);
        driver.navigate().refresh();

        //sell linkine tiklayalim
        WebElement sellLinki = driver.findElement(By.xpath("//*[.='Sell']"));
        //  sellLinki.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", sellLinki);

    }

    @Test
    public void test03() {
        //amazona gidelim
        driver.get("https://amazon.com");
        waitForSecond(1);
        driver.navigate().refresh();

        //sell linkine tiklayalim
        WebElement sellLinki = driver.findElement(By.xpath("//*[.='Sell']"));
        jsClick(sellLinki);
    }
}

