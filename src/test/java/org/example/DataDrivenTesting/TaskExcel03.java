package org.example.DataDrivenTesting;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TaskExcel03 {
    public static void main(String[] args) throws IOException {
        // Create cell at Specific Position


        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Main");

        Row row = sheet.createRow(1);
        Cell cell = row.createCell(1);
        cell.setCellValue("Sherine Antony"); // Replace with your actual value


        FileOutputStream outputStream = new FileOutputStream(new File("CELLSPECIFIC.xlsx"));  // it file will create
        workbook.write(outputStream);
        outputStream.close();
    }
}
