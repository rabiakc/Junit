package day17_excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C02_ReadExcel {

    @Test
    public void test01() throws IOException {


        //Örnek 1: Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        FileInputStream fis = new FileInputStream("src\\test\\java\\resources\\Capitals.xlsx");

        Workbook workbook= WorkbookFactory.create(fis);
        //index 0 dan baslar dolayisiyla birinci satiri secmek icin 1 dememiz gerekir
        //ikinci sutunu secmek icin indexe 1 yazmaliyiz
        Cell cell = workbook.getSheet("Sheet1").getRow(0).getCell(1);
        System.out.println("cell = " + cell);//CAPITAL


        //Örnek 2: 3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        String actualCell = workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        String expectedCell ="France";
        Assert.assertEquals(expectedCell,actualCell);


        //Örnek 3: Kullanılan satır sayısın bulun
        //getPhysicalNumberOfRows(); methodu icinde data olan satirlarin sayisini verir ve bize bir sayi verdigi icin index 0 dan baslamaz 1 den baslar
        int icindeDataBulunanSatirSayisi = workbook.getSheet("Sheet1").getPhysicalNumberOfRows();
        System.out.println("icindeDataBulunanSatirSayisi = " + icindeDataBulunanSatirSayisi);


        //Örnek 4: Sayfadaki son satırin index ini yazdırınız
        //getLastRowNum()); methodu bir excel calisma sayfasindaki son satirin indexini verir
        //index 0 dan basladigi icin bu sayfada eger toplam 5 satir varsa bu method 4 verir
        System.out.println(workbook.getSheet("Sheet1").getLastRowNum());


        //Örnek 5: Excel sayfasindaki datalari COUNTRY,CAPITALS (Ülke-Başkent) key-value şeklinde console a yazdiriniz
        // {{USA,D.C},{FRANCE,PARIS}....}
/*
       String county = workbook.getSheet("Sheet1").getRow(0).getCell(0).toString();
       String capital = workbook.getSheet("Sheet1").getRow(0).getCell(1).toString();

        System.out.println(county+" "+capital);


        String county1 = workbook.getSheet("Sheet1").getRow(1).getCell(0).toString();
        String capital1 = workbook.getSheet("Sheet1").getRow(1).getCell(1).toString();

        System.out.println(county1+" "+capital1);



        String county2 = workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        String capital2 = workbook.getSheet("Sheet1").getRow(2).getCell(1).toString();

        System.out.println(county2+" "+capital2);

        */

        Map<String,String> ulkeBaskentleri = new HashMap<>();

        for (int i = 0; i <workbook.getSheet("Sheet1").getPhysicalNumberOfRows() ; i++) {

            String country = workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();
            String capital = workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();

            ulkeBaskentleri.put(country,capital);
        }
        System.out.println("ulkeBaskentleri = " + ulkeBaskentleri);


    }
}
