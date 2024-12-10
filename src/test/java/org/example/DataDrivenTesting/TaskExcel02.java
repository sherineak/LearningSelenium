package org.example.DataDrivenTesting;

import org.apache.commons.collections4.functors.WhileClosure;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class TaskExcel02 {
    //File Open
    // Read Data
    //Read the Excel file
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("CTD.xlsx");  // file name

        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);   // first sheet , here name "MAIN" we are  given for pgm TaskExcel01

        // Iteration, sheet has Iterator method

        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()){
            Row row =rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()){
                Cell cell = cellIterator.next();
                if(cell.getCellType() == CellType.NUMERIC){
                    System.out.println(cell.getNumericCellValue());
                }
                if(cell.getCellType() == CellType.STRING){
                    System.out.println(cell.getStringCellValue());
                }
            }
        }



    }

}
