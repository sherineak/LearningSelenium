package org.example.DataDrivenTesting;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class TaskExcel01SameLogicWithUtlity {

    public static void main(String[] args) throws IOException {
        //WorkBOOK
        //Sheet
        //Row, Cell
        //XSSFWorkBook -xlsx - Latest Version > 2008
        //HSSFWorkBook - xls
        //Task 1 : Create an Excel file and Add Data
        Map<String, Object> data = new TreeMap<>();   // Tree Map Sorted
        data.put("1", new Object[]{"LoginId", "Email", "Password"});
        data.put("2", new Object[]{"1", "sherine@live.com", "Passd12"});
        data.put("3", new Object[]{"2", "test@test.com", "Pass123"});

        // To Take Id using Set
        createExcel("CTD2.xlsx", data);


    }


    public static String createExcel(String name, Map data) throws IOException {
        Set<String> keyset = data.keySet();

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Main");

        int rowNum = 0;
        for (String key : keyset) {
            Row r = sheet.createRow(rowNum++);
            Object[] objectA = (Object[]) data.get(key);
            int cellNum = 0;
            for (Object ob : objectA) {
                Cell cell = r.createCell(cellNum++);
                if (ob instanceof String) {
                    cell.setCellValue((String) ob);     // // In the xl the 'ob ' is string
                }
                if (ob instanceof Integer) {
                    cell.setCellValue((Integer) ob);   //// In the xl the 'ob ' is Integer
                }
            }
            FileOutputStream outputStream = new FileOutputStream(new File(name));  // it file will create
            workbook.write(outputStream);
            outputStream.close();

        }
        return name;
    }
}



