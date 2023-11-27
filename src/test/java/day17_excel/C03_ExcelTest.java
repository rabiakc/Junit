package day17_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.IOException;

public class C03_ExcelTest extends TestBase {

    @Test
    public void test01() throws IOException {

        //https://www.bluerentalcars.com/ sayfasına gidelim
        driver.get("https://www.bluerentalcars.com/");

        //Login butonuna basalım
        driver.findElement(By.xpath("//a[.=' Login']")).click();

        //Excel dosyasından aldığımız bir kullanıcı adı ve password ile login olalim
        String path ="src\\test\\java\\resources\\mysmoketestdata.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fis);

        String userEmail =workbook.getSheet("customer_info").getRow(1).getCell(0).toString();
        String password =workbook.getSheet("customer_info").getRow(1).getCell(1).toString();

        WebElement emailTextBoxWebelement = driver.findElement(By.cssSelector("#formBasicEmail"));
        WebElement passwordTextBoxWebelement = driver.findElement(By.cssSelector("#formBasicPassword"));
        WebElement loginButton = driver.findElement(By.xpath("//*[@type='submit']"));

        emailTextBoxWebelement.sendKeys(userEmail);
        passwordTextBoxWebelement.sendKeys(password);
        loginButton.click();

        //Login olduğumuzu doğrulayalım
        WebElement loginText = driver.findElement(By.cssSelector("#dropdown-basic-button"));
        Assert .assertEquals("ayhan can",loginText.getText());

    }
}
