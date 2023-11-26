package day07_assertion_dropdown_testbase;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assertion {
       /*
        https://www.youtube.com adresine gidin
        Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
        TEST1=> Sayfa başlığının "YouTube" oldugunu test edin
             => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        TEST2=> Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        TEST3=> wrongTitleTest  => Sayfa basliginin "youtube" olmadigini dogrulayin

     */
    WebDriver driver;


    @Before
    public void setUp() throws Exception {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");
    }

    @Test
    public void test01() {
        driver.get("https://www.youtube.com");
        String actual = driver.getTitle();
        String expected = "YouTube";
        Assert.assertEquals(expected,actual);
        WebElement logo = driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void tes02() {
        WebElement search = driver.findElement(By.xpath("//input[@id='search']"));
       Assert.assertTrue(search.isEnabled());
    }

    @Test
    public void test03() {

        Assert.assertNotEquals("youtube",driver.getTitle());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
