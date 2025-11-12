package com.parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
    private XSSFWorkbook wb;
    private XSSFSheet sh;

    // Constructor with validation
    public ExcelReader(String filepath) {
        try {
            File file = new File(filepath);
            if (!file.exists()) {
                throw new IOException("Excel file not found at: " + filepath);
            }
            FileInputStream fis = new FileInputStream(file);
            wb = new XSSFWorkbook(fis);
        } catch (IOException e) {
            System.out.println("Error loading Excel file: " + filepath);
            e.printStackTrace();
            wb = null; // Ensure wb stays null if loading fails
        }
    }

    // Get cell data safely
    public String getCellData(int sheetno, int row, int col) {
        validateWorkbook();
        sh = wb.getSheetAt(sheetno);
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(sh.getRow(row).getCell(col));
    }

    // Get row count safely
    public int getRowcount(int sheetno) {
        validateWorkbook();
        sh = wb.getSheetAt(sheetno);
        return sh.getLastRowNum();
    }

    // Get column count safely
    public int getColcount(int sheetno) {
        validateWorkbook();
        sh = wb.getSheetAt(sheetno);
        return sh.getRow(0).getLastCellNum();
    }

    // Validate workbook before any operation
    private void validateWorkbook() {
        if (wb == null) {
            throw new IllegalStateException("Workbook is not initialized. Check file path.");
        }
    }
}