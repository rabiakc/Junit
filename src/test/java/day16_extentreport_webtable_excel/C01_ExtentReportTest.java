package day16_extentreport_webtable_excel;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_ExtentReportTest extends TestBase {



    @Test
    public void extentReusableFormatTest() throws InterruptedException {

        rapor("Chrome","AmazonTesti");

        extentReports.createTest("Amazon SearchBox", "Test Steps");


        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        driver.navigate().refresh();
        driver.navigate().refresh();
        Thread.sleep(6000);

        //Arama kutusunda selenium aratalim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("selenium", Keys.ENTER);

        //Sayfa basliginin selenium icerdigini doğrulayalim
        Assert.assertTrue(driver.getTitle().contains("selenium"));

        extentReports.flush();


    }

}
