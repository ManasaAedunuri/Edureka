package com.Parameters;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
public static String getLocalityByRow(String filePath, int sheetIndex, int rowIndex) {
    try (FileInputStream fis = new FileInputStream(filePath);
         Workbook workbook = new XSSFWorkbook(fis)) {
 
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        Row row = sheet.getRow(rowIndex);
        if (row != null) {
            Cell cell = row.getCell(0);
            if (cell != null) {
                return cell.getStringCellValue().trim();
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
 
return null;
}
}
