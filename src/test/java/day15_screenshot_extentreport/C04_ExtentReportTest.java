package day15_screenshot_extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C04_ExtentReportTest extends TestBase {


    ExtentReports extentReports;//raporlamayi baslatir

    ExtentHtmlReporter extentHtmlReporter;//html formatinda rapor olusuturur

    ExtentTest extentTest; // Test adimlarina bilgi ekler

    @Test
    public void extentReportTemplate() {

        /*
        1- ExtentReport classindan raporlamayi baslatmasi icin bir object olusturmaliyiz
        2- ExtentHtmlReporter class indan raporlari html formatinda olusturmasi icin bir object olusturmaliyiz
        3- EXtentTest Classindan test adimlarina bilgi ekleyebilmek icin bir object olustururuz
         */

        //bu object i raporlari olusturmak ve yonetmek icin kullanacacğız
        extentReports = new ExtentReports();

        //Oncelikle olusturmak istedigimiz html reprotu projemizde nerede saklamak istiyorsak bir dosya yolu olusturmaliyiz
        //cunku bu pathi kullanarak bir tane html report olusturacağız
        //bunun icinde ExtentHtmlReporter classindan bir object olusturmaliyiz

        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String path = "target/extentReport/" + date + "htmlReport.html";
        extentHtmlReporter = new ExtentHtmlReporter(path);

        //ExtentReports a Html raporlayiciyi ekler, bu raporun html formatinda olusturulmasini saglar
        extentReports.attachReporter(extentHtmlReporter);

        //Html raporunun belge basligini ayarlar, bu baslik sekme uzerinde görünür
        extentHtmlReporter.config().setDocumentTitle("Batch 189 Test Reports");

        //Raporun adini ayarladik, Bu raporda gorunecek olan genel baslik
        extentHtmlReporter.config().setReportName("Smoke Test");

        //Bu html raporunda görmek isteyebileceğimiz herhangi bir bilgiyi asagidaki formatta ekleyebilirz
        extentReports.setSystemInfo("Enviroment", "QA");
        extentReports.setSystemInfo("Bowser", "Chrome");
        extentReports.setSystemInfo("Test Automation Engineer", "Ali Can");

        //"AmazonTest" adinda yeni bir test olusturur ve bu testin aciklamasi olarak "Test Report" ekler
        extentTest = extentReports.createTest("TechproEducation", "Test Report");

        //==========Buraya kadar sablon ayarlamalari bitt==================================
        //Bundan sonra extentTest objecti ile log rapara detayli islemleri ekleme islemleri yapacağız

        //TechproEducation sayfasina gidelim
        driver.get("https://techproeducation.com");
        extentTest.info("Kullanici TechproEducation sayfasina gider");

        //TechproEducation ana sayfada oldugunuzu dogrulayin
        String expectedUrl="https://techproeducation.com/";
        Assert.assertEquals(expectedUrl,driver.getCurrentUrl());
        extentTest.info("Kullanici ana sayfada oldugunu dogrular");
        extentTest.pass("Ana sayfa url testi basarili");

        //Ana Sayfa sag üst kısımda sosyal medya iconlarinin goruntulendigini dogrulayin
        WebElement icons = driver.findElement(By.xpath("//*[@class='toolbar-sl-share']"));
        Assert.assertTrue(icons.isDisplayed());
        extentTest.pass("Kullanici iconlarin goruntulendigini dogrular");

        extentReports.flush();

    }
}
