package day06_junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_CheckBox {


    /*
   Verilen web sayfasına gidin.
           https://the-internet.herokuapp.com/checkboxes
           Checkbox1 ve checkbox2 elementlerini locate edin.
           Checkbox1 seçili değilse onay kutusunu tıklayın
           Checkbox2 seçili değilse onay kutusunu tıklayın

    */

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @Test
    public void checkBox() throws InterruptedException {
       // Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkBox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        Thread.sleep(3000);
       // Checkbox1 seçili değilse onay kutusunu tıklayın
        if (!checkBox1.isSelected()){
            checkBox1.click();
        }
       // Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!checkBox2.isSelected()){
            checkBox2.click();
        }
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }
}
