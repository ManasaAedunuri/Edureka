package com.parameters;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.*;

public class ExcelReader {
    public static Map<String, String> getRowData(String filePath, int sheetNo) {
        Map<String, String> data = new HashMap<>();
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fis)) {
            Sheet sheet = workbook.getSheetAt(sheetNo);
            Row headerRow = sheet.getRow(0);
            Row valueRow = sheet.getRow(1); // Assuming data in second row
            for (int i = 0; i < headerRow.getLastCellNum(); i++) {
                String key = headerRow.getCell(i).getStringCellValue();
                String value = valueRow.getCell(i).getStringCellValue();
                data.put(key, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}