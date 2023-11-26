package day15_screenshot_extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C03_ExtentReport {

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
        extentReports=new ExtentReports();

        //Oncelikle olusturmak istedigimiz html reprotu projemizde nerede saklamak istiyorsak bir dosya yolu olusturmaliyiz
        //cunku bu pathi kullanarak bir tane html report olusturacağız
        //bunun icinde ExtentHtmlReporter classindan bir object olusturmaliyiz

        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String path ="target/extentReport/"+date+"htmlReport.html";
        extentHtmlReporter = new ExtentHtmlReporter(path);

        //ExtentReports a Html raporlayiciyi ekler, bu raporun html formatinda olusturulmasini saglar
        extentReports.attachReporter(extentHtmlReporter);


        //Html raporunun belge basligini ayarlar, bu baslik sekme uzerinde görünür
        extentHtmlReporter.config().setDocumentTitle("Batch 189 Test Reports");

        //Raporun adini ayarladik, Bu raporda gorunecek olan genel baslik
        extentHtmlReporter.config().setReportName("Smoke Test");

        //Bu html raporunda görmek isteyebileceğimiz herhangi bir bilgiyi asagidaki formatta ekleyebilirz
        extentReports.setSystemInfo("Enviroment","QA");
        extentReports.setSystemInfo("Bowser","Chrome");
        extentReports.setSystemInfo("Test Automation Engineer","Ali Can");

        //"AmazonTest" adinda yeni bir test olusturur ve bu testin aciklamasi olarak "Test Report" ekler
        extentTest=extentReports.createTest("AmazonTest","Test Report");


        //==========Buraya kadar sablon ayarlamalari bitt==================================

        //Bundan sonra extentTest objecti ile log rapara detayli islemleri ekleme islemleri yapacağız


        //Testin basarili oludugunu belirtir ve rapora Pass notu ekler
        extentTest.pass("PASS");

        //Testle alakali bilgilendirici not ekler
        extentTest.info("Bilgilendirme Notu");

        //Testin basarisiz oldugunu belirtiriz ve rapora Fail Mesaji notunu ekleriz
        extentTest.fail("Fail Mesaji");

        //Testle ilgili uyari mesaji ekler
        extentTest.warning("uyari mesaji");

        //Testin atlandigini belirtir ve rapora Atlama Mesaji notunu ekler
        extentTest.skip("Atlama mesaji");

        //Test sirasinda ciddi bir hata oldugunu belirtir
        extentTest.fatal("Ciddi Hata Mesaji");


        extentReports.flush();


    }
}
