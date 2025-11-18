package com.parameters;
 
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
 
public class ExcelUtils {
 
    public static List<String[]> readExcelData(String filePath) {
        List<String[]> dataList = new ArrayList<>();
 
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
 
            Sheet sheet = workbook.getSheetAt(0);
 
            for (int i = 1; i <= sheet.getLastRowNum(); i++) { // skip header
                Row row = sheet.getRow(i);
                String name = row.getCell(0).getStringCellValue();
                String email = row.getCell(1).getStringCellValue();
                String phone = row.getCell(2).getCellType() == CellType.NUMERIC
                        ? String.valueOf((long) row.getCell(2).getNumericCellValue())
                        : row.getCell(2).getStringCellValue();
 
                dataList.add(new String[]{name, email, phone});
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return dataList;
    }
}





