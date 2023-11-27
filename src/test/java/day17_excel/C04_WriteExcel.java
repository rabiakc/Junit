package day17_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C04_WriteExcel {

    @Test
    public void writeExcel() throws IOException {

        //mysmoketestdata.xlsx dosyasina STATUS adinda ucuncu bir sutun olusturunuz,
        //Bu sutun altinda satirlara sirasiyla valid valid ve invalid degerlerini yaziniz

        String path ="src\\test\\java\\resources\\mysmoketestdata.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("customer_info");
        Row row =sheet.getRow(0);

        //ucuncu sutun basligini olusturduk
        Cell cell3 = row.createCell(2);

        //ucuncu hucreye STATUS atadik
        cell3.setCellValue("STATUS");

        //ikinci satirin ucuncu hücresini olstur ve degerini valid olarak ata
        sheet.getRow(1).createCell(2).setCellValue("valid");

        sheet.getRow(2).createCell(2).setCellValue("valid");

        //dorduncu satirin ucuncu hücresini olustur ve degerini invalid olarak ata
        sheet.getRow(3).createCell(2).setCellValue("invalid");

        //Dosyaya yazmak icin bir sistemden cıkıs akisi olusturur
        FileOutputStream fos = new FileOutputStream(path);

        //Excel dosyasina yapilan degisiklikleri yazar
        workbook.write(fos);

        fis.close();
        fos.close();

    }
}
