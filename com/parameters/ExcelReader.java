
package com.parameters;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    // Read email (column 0)
    public static String getLocalityByRow(String filePath, int sheetIndex, int rowIndex) {
        return getCellValue(filePath, sheetIndex, rowIndex, 0);
    }

    // Read phone (column 1)
    public static String getLocalityByRow1(String filePath, int sheetIndex, int rowIndex) {
        return getCellValue(filePath, sheetIndex, rowIndex, 1);
    }

    // Generic method to read any column
    private static String getCellValue(String filePath, int sheetIndex, int rowIndex, int colIndex) {
        File file = new File(filePath);
        System.out.println("Excel file exists: " + file.exists());

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(sheetIndex);
            Row row = sheet.getRow(rowIndex);

            if (row != null) {
                Cell cell = row.getCell(colIndex);
                if (cell != null) {
                    if (cell.getCellType() == CellType.NUMERIC) {
                        return String.valueOf((long) cell.getNumericCellValue()); // Handles phone numbers
                    }
                    return cell.getStringCellValue().trim();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
 
}