package day08_testbase_alert_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_Alert extends TestBase {
    /*
    Eger bir sayafadaki bir buttona tikladiginizda bir uyari cikiyorsa ve bu cikan uyariya sag click yaparak locate alamiyorsak bu bir JS Alert tür
    JS Alertü handle edebilmek icin driveri mizi o acilan pencereye gecirmemiz gerekir
    driver objemizi kullanarak switchTo() methoduyla alert() methodunu kullanarak js alerte gecis yapmis oluruz

    1) accept() yada dismiss() methodlariyla JS Alert ü onaylar yada iptal ederek kapatiriz

    accept() -->onaylar
    dismiss() --> iptal eder
     */
    
    /*
    https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
       
Bir metod olusturun: acceptAlert
       1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  "You successfully clicked an alert" oldugunu test edin.
       
Bir metod olusturun: dismissAlert
       2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
       "successfuly" icermedigini test edin.
       
Bir metod olusturun: sendKeysAlert
       3. butona tıklayın, uyarıdaki  metin kutusuna isminizi yazin, OK butonuna
       tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
     */

    @Test
    public void acceptAlert() {

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //  1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve
        driver.findElement(By.xpath("(//button)[1]")).click();
        waitForSecond(2);

        driver.switchTo().//driveri gecis yaptirmak icin kullanilir
                alert().//driveri alert e gecis yaptirdik
                accept();//Alert ü onayladik

        //  result mesajının  "You successfully clicked an alert" oldugunu test edin.
        String actualResultMessage = driver.findElement(By.cssSelector("#result")).getText();
        String expectedResultMessage ="You successfully clicked an alert";
        Assert.assertEquals(expectedResultMessage,actualResultMessage);

    }

    @Test
    public void dissmissAlert() {

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //  2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        driver.findElement(By.xpath("(//button)[2]")).click();
        waitForSecond(2);

        driver.switchTo().alert().dismiss();//Acilan alent ten Cancel tusuna bastik

        // "successfuly" icermedigini test edin.
        String actualResultMessage=driver.findElement(By.xpath("(//p)[2]")).getText();
        String unexpectedResultMessage="successfuly";
        Assert.assertFalse(actualResultMessage.contains(unexpectedResultMessage));

    }

    @Test
    public void sendKeysAlert() {

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        // 3. butona tıklayın, uyarıdaki  metin kutusuna isminizi yazin, OK butonuna
        driver.findElement(By.xpath("(//button)[3]")).click();
        waitForSecond(2);

        driver.switchTo().alert().sendKeys("mehmet");
        driver.switchTo().alert().accept();
        waitForSecond(2);

        // tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        String actualResultMessage = driver.findElement(By.xpath("(//p)[2]")).getText();
        Assert.assertTrue(actualResultMessage.contains("mehmet"));

    }
}
