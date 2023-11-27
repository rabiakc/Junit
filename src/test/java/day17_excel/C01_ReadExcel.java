package day17_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void test01() throws IOException {

        //1- Projemize resources package i altinda bulunan excel dosyamizin yolunu belirtmeliyiz
        String path ="src\\test\\java\\resources\\Capitals.xlsx";

        //2-FileInputStream classini kullanarak bir stream olusturduk ve akis ile dosyamizdan gelen datayi java
        //ortamina aktaracağız
        FileInputStream fis = new FileInputStream(path);

        //3-fis objemiz uzerinden bir excel dosyasini olusturduk
        //Excel dosyasindan verileri okuyabilmek icin bu dosyayi java ortaminda acmis olduk
        Workbook workbook = WorkbookFactory.create(fis);


        //4-Bir excel (=workbook) dosyasinda birden fazla sayfa bulunabilir, bu nedenle
        //"Sheet1"adli calisma sayfasini acmak ve bu sayfadaki datalarla calisabilmek icin bu kodu yazdik
        Sheet sheet =workbook.getSheet("Sheet1");


        //5-Bir excel sayfasinda birden fazla row yani satir bulunur, belirtmis oldugumuz sayfadaki satir
        //bilgisini secmemiz gerekir
        //Bu yazmis oldugumuz kod ile excel dosyamizin ilgili sayfasindaki ilk satiri secmis olduk
        Row row = sheet.getRow(0);//index 0 dan baslar

        //6-Bir satir birden fazla cell icerdigi icin hangi cell ile calismak istedigimiz javaya asagidaki
        //kod ile belirtmis olduk ve NOT index 0 dan baslar
        Cell cell =row.getCell(0);

        System.out.println("cell = " + cell);//COUNTRY


    }

    @Test
    public void test02() throws IOException {

        String path ="src/test/java/resources/Capitals.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fis);

        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(0));

    }
}
