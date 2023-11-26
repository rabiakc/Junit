package day11_actions_faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_ActionsTest extends TestBase {


    @Test
    public void test01() {

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Sayfayı istediğimiz bir miktar aşağıya doğru scroll yapalım

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();

        for (int i = 0; i <5 ; i++) {
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            waitForSecond(1);
        }

        //Sayfayı istediğimiz bir miktar yukarıya doğru scroll yapalım
        actions.sendKeys(Keys.PAGE_UP).perform();

        for (int i = 0; i <5 ; i++) {
            actions.sendKeys(Keys.PAGE_UP).perform();
            waitForSecond(1);
        }

    }

    @Test
    public void test02() {

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        Actions actions = new Actions(driver);

        //Sayfanın en altına scroll yapalım
        actions.sendKeys(Keys.END).perform();//sayfanin en altina scroll yapar

        waitForSecond(2);

        //Sayfanın en üstüne scroll yapalım
        actions.sendKeys(Keys.HOME).perform();//sayfanin en ustune scroll yapar

    }


    @Test
    public void test03() {

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        Actions actions = new Actions(driver);
        //Events yazisina kadar scroll yapalim
        WebElement event = driver.findElement(By.xpath("//h2[text()='Events']"));
        actions.scrollToElement(event).perform();

    }
}
