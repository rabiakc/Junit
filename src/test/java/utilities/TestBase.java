package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class TestBase {

    protected WebDriver driver;

    protected ExtentReports extentReports;
    protected ExtentHtmlReporter extentHtmlReporter;
    protected ExtentTest extentTest;


    public void rapor(){
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

    }

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        //  driver.quit();
    }

    //Select Visible Text DropDown
    public void selectVisible(WebElement ddm, String option){
        Select select = new Select(ddm);
        select.selectByVisibleText(option);
    }

    //Select index DropDown
    public void selectIndex(WebElement ddm, int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    //Hard Wait
    public void waitForSecond(int second)  {
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //window handle
    public void window(int index){
        driver.switchTo().window(driver.getWindowHandles().toArray()[index].toString());
    }

    //iframe handle
    public void frameIndex(int index){
        driver.switchTo().frame(index);
    }


    //screenshot
    public void screenShot(){
        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format( LocalDateTime.now() );
        String dosyaYolu="src\\test\\java\\screenShots\\"+date+"screenShot.png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            Files.write(Paths.get(dosyaYolu), ts.getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //webelement screenshot
    public void screenShotOfWebElement(WebElement webElement){

        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format( LocalDateTime.now() );

        String dosyaYolu="src\\test\\java\\screenShots\\"+date+"webElementSS.png";

        try {
            Files.write(  Paths.get(dosyaYolu) , webElement.getScreenshotAs(OutputType.BYTES) );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}