package day09_iframe_windowhandle_basicauthentication;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C03_WindowHandle extends TestBase {


    @Test
    public void test01() {

        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfasının Handle degerini alın yazdırın
        String ilkSayfaHandleDegeri= driver.getWindowHandle();

        //  ilk sayfadaki textin “Opening a new window” olduğunu test edin.
        String text = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window",text);

        //  ilk sayfa Title'ının “The Internet” olduğunu test edin.
        Assert.assertEquals("The Internet",driver.getTitle());


        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();

        //  ikinci sayfa Title'ının “New Window” olduğunu test edin.

        Set<String> windows = driver.getWindowHandles();

        for ( String w :  windows ) {
            if(!w.equals(ilkSayfaHandleDegeri)){
                driver.switchTo().window(w);

            }
        }

        /*
        yukarida yazmis oldugumuz kod ile Handle degeri ilk sayfaya esit olmayana geciş yap diyerek kontrolumuz dısında acilan pencereye
        driveri gecirdik
         */
        Assert.assertEquals("New Window",driver.getTitle());
        String ikinciSayfaHandleDegeri=driver.getWindowHandle();

        waitForSecond(2);
        //  ilk sayfaya dönün ve Title'ının “The Internet” olduğunu test edin.
        driver.switchTo().window(ilkSayfaHandleDegeri);
        Assert.assertEquals("The Internet",driver.getTitle());

        waitForSecond(2);
        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(ikinciSayfaHandleDegeri);
        waitForSecond(2);

        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(ilkSayfaHandleDegeri);
    }

    @Test
    public void test02() {

        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfadaki textin “Opening a new window” olduğunu test edin.
        String text = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window",text);

        //  ilk sayfa Title'ının “The Internet” olduğunu test edin.
        Assert.assertEquals("The Internet",driver.getTitle());


        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();

        //  ikinci sayfa Title'ının “New Window” olduğunu test edin.

        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        Assert.assertEquals("New Window",driver.getTitle());

        waitForSecond(2);

        //  ilk sayfaya dönün ve Title'ının “The Internet” olduğunu test edin.
        driver.switchTo().window(windows.get(0));
        Assert.assertEquals("The Internet",driver.getTitle());
        waitForSecond(2);
        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(windows.get(1));
        waitForSecond(2);
        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(windows.get(0));
    }


    @Test
    public void test03() {

        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfadaki textin “Opening a new window” olduğunu test edin.
        String text = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window",text);
        //  ilk sayfa Title'ının “The Internet” olduğunu test edin.
        Assert.assertEquals("The Internet",driver.getTitle());

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();

        //  ikinci sayfa Title'ının “New Window” olduğunu test edin.

        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        Assert.assertEquals("New Window",driver.getTitle());

        waitForSecond(2);

        //  ilk sayfaya dönün ve Title'ının “The Internet” olduğunu test edin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        Assert.assertEquals("The Internet",driver.getTitle());
        waitForSecond(2);

        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        waitForSecond(2);

        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
    }


    @Test
    public void test04() {

        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfadaki textin “Opening a new window” olduğunu test edin.
        String text = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window",text);

        //  ilk sayfa Title'ının “The Internet” olduğunu test edin.
        Assert.assertEquals("The Internet",driver.getTitle());


        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();

        //  ikinci sayfa Title'ının “New Window” olduğunu test edin.
        window(1);
        Assert.assertEquals("New Window",driver.getTitle());
        waitForSecond(2);
        //  ilk sayfaya dönün ve Title'ının “The Internet” olduğunu test edin.
        window(0);
        Assert.assertEquals("The Internet",driver.getTitle());
        waitForSecond(2);
        //  ikinci sayfaya tekrar geçin.
        window(1);
        waitForSecond(2);

        //  ilk sayfaya tekrar dönün.
        window(0);
    }


}
