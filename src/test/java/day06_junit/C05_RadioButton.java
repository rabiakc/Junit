package day06_junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_RadioButton {

    /*
   https://www.facebook.com adresine gidin
           Cookies'i kabul edin
           "Create an Account" button'una basin
           "radio buttons" elementlerini locate edin
           Secili degilse cinsiyet butonundan size uygun olani secin
    */

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.facebook.com");
    }

    @Test
    public void radioButton() throws InterruptedException {
        //"Create an Account" button'una basin
       driver.findElement(By.xpath("(//a[@role ='button'])[2]")).click();
        Thread.sleep(2000);
        //"radio buttons" elementlerini locate edin
        WebElement kadın = driver.findElement(By.xpath("(//input[@type ='radio'])[1]"));
        WebElement erkek =driver.findElement(By.xpath("(//input[@type ='radio'])[2]"));
        //Secili degilse cinsiyet butonundan size uygun olani secin
        if (!kadın.isSelected()) {
            kadın.click();
        }
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }
}
