package day16_extentreport_webtable_excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_WebTable extends TestBase {

  /*
    1- <table> bu tag tum tabloyu kapsar, xpath kullanarak //table ifadesiyle tum tablolari bulabilirsiniz,
    Birden fazla tablodan istedigmiiz tabloyu secmek icin index belirtmemiz yeterlidir

    2- <thead> bu tag eger webtable da bir baslik bolumu varsa bu thead tagi icinde olur
        <thead>  tagi icinde <tr> table row baslik satirini <th> tag ise baslik satirindaki her bir hücreyi temsil eder

    3 <tbody> bu tag webtable daki datalarin yogun olarak bulundugu kısımdırb <tr> satirlari ve  <td> bu satirlardaki her bir hücreyi temsil eder
     */



    @Test
    public void webTableTest() {

        //https://the-internet.herokuapp.com/tables sayfasına gidelim
        driver.get("https://the-internet.herokuapp.com/tables");
        //Task 1 : Table1’i print edin
        //Task 1 : Table1’i print edin

        WebElement table1= driver.findElement(By.xpath("//table[1]"));
        System.out.println(table1.getText());
        System.out.println("====================================================");

        //ikinci yol
        //driver.findElements(By.tagName("table")).get(0);

        //Task 2 : 3. Row'(satır) datalarını print edin
        WebElement table2= driver.findElement(By.xpath("//table[1]//tr[3]"));
        System.out.println(table2.getText());
        System.out.println("====================================================");
        //Task 3 : Son row daki dataları print edin
        WebElement lastRow =  driver.findElement(By.xpath("//table[1]//tbody//tr[last()]"));
        System.out.println(lastRow.getText());
        System.out.println("====================================================");
       /*
       xpathy kullaniminda eger bir webtable da son satiri dynamic olarak
       locate etmek istersek index parantezi icinde last() function i kullanabiliriz
        */

        //Task 4 : 5. Column(sütun) datalarini print edin
        List<WebElement> fifthColumn = driver.findElements(By.xpath("//table[1]//td[5]"));

        //1. yol
//        for (WebElement w  : fifthColumn  ) {
//            System.out.println(w.getText());
//        }

        //2.yol
        fifthColumn.forEach(t-> System.out.println(t.getText()));
        System.out.println("====================================================");


        //Task 5 : Iki parametreli bir Java metot oluşturalım: printData  Parameter 1 = row numarasi
        //Parameter 2 = column numarasi
        //printData(2,3);  => 2nd satir, 3rd sutun daki datayı print etsin

        printData(2,3);
        printData(3,2);


    }

    private void printData(int satir, int sutun) {
        WebElement webElement =  driver.findElement(By.xpath("//table[1]//tbody//tr["+satir+"]//td["+sutun+"]"));
        System.out.println(webElement.getText());
    }

}
