package com.parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    // Existing method (unchanged)
    public static String[] getRowData(int sheetNo, int rowNum) throws IOException {
        String filePath = "src/test/resources/ExcelData/testInputs.xlsx"; // Your file path
        FileInputStream file = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(sheetNo);
        DataFormatter formatter = new DataFormatter();

        // Get header row to determine column count
        Row headerRow = sheet.getRow(0);
        int colCount = headerRow.getLastCellNum();

        // Read target row
        Row row = sheet.getRow(rowNum);
        String[] rowData = new String[colCount];
        for (int j = 0; j < colCount; j++) {
            Cell cell = (row != null) ? row.getCell(j) : null;
            rowData[j] = (cell != null) ? formatter.formatCellValue(cell) : "";
        }

        workbook.close();
        file.close();
        return rowData;
    }

    // ✅ New method to return Map<String, String>
    public static Map<String, String> getRowDataAsMap(int sheetNo, int rowNum) throws IOException {
        String filePath = "src/test/resources/ExcelData/testInputs.xlsx";
        FileInputStream file = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(sheetNo);
        DataFormatter formatter = new DataFormatter();

        Row headerRow = sheet.getRow(0);
        Row dataRow = sheet.getRow(rowNum);
        int colCount = headerRow.getLastCellNum();

        Map<String, String> dataMap = new LinkedHashMap<>();
        for (int j = 0; j < colCount; j++) {
            String key = formatter.formatCellValue(headerRow.getCell(j));
            String value = (dataRow != null && dataRow.getCell(j) != null)
                    ? formatter.formatCellValue(dataRow.getCell(j))
                    : "";
            dataMap.put(key, value);
        }

        workbook.close();
        file.close();
        return dataMap;
    }
}
//package com.parameters;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class ExcelReader {
//
//    public static String[] getRowData(int sheetNo, int rowNum) throws IOException {
//        String filePath = "src/test/resources/ExcelData/testInputs.xlsx"; // Your file path
//        FileInputStream file = new FileInputStream(filePath);
//        Workbook workbook = new XSSFWorkbook(file);
//        Sheet sheet = workbook.getSheetAt(sheetNo);
//        DataFormatter formatter = new DataFormatter();
//
//        // Get header row to determine column count
//        Row headerRow = sheet.getRow(0);
//        int colCount = headerRow.getLastCellNum();
//
//        // Read target row
//        Row row = sheet.getRow(rowNum);
//        String[] rowData = new String[colCount];
//        for (int j = 0; j < colCount; j++) {
//            Cell cell = (row != null) ? row.getCell(j) : null;
//            rowData[j] = (cell != null) ? formatter.formatCellValue(cell) : "";
//        }
//
//        workbook.close();
//        file.close();
//        return rowData;
//    }
//}
//package com.parameters;
//
//import java.io.FileInputStream;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class ExcelReader {
//
//    
//    public static Map<String, String> readData(String filepath, int sheetNo, int rowIndex) {
//        Map<String, String> dataMap = new HashMap<>();
//        try (FileInputStream fis = new FileInputStream(filepath);
//             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//            XSSFSheet sheet = workbook.getSheetAt(sheetNo);
//            Row headerRow = sheet.getRow(0); // First row as header
//            Row valueRow = sheet.getRow(rowIndex);
//
//            if (headerRow != null && valueRow != null) {
//                int colCount = headerRow.getLastCellNum();
//                for (int col = 0; col < colCount; col++) {
//                    String key = getCellValue(headerRow.getCell(col));
//                    String value = getCellValue(valueRow.getCell(col));
//                    if (!key.isEmpty()) {
//                        dataMap.put(key, value);
//                    }
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("Error reading Excel data: " + e.getMessage());
//        }
//        return dataMap;
//    }
//
//    /**
//     * Safely retrieves cell value as String.
//     */
//    private static String getCellValue(Cell cell) {
//        if (cell == null) return "";
//        switch (cell.getCellType()) {
//            case STRING:
//                return cell.getStringCellValue().trim();
//            case NUMERIC:
//                return String.valueOf((long) cell.getNumericCellValue()).trim();
//            case BOOLEAN:
//                return String.valueOf(cell.getBooleanCellValue()).trim();
//            default:
//                return "";
//        }
//    }
//}
//package com.parameters;
//
//import java.io.FileInputStream;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class ExcelReader {
//    private XSSFWorkbook wb;
//    private XSSFSheet sh;
//
//    // Constructor with validation
////    public ExcelReader(String filepath) {
////        FileInputStream fis = null;
////        try {
////            File file = new File(filepath);
////            if (!file.exists()) {
////                throw new IOException("Excel file not found at: " + filepath);
////            }
////            fis = new FileInputStream(file);
////            wb = new XSSFWorkbook(fis);
////        } catch (IOException e) {
////            System.out.println("Error loading Excel file: " + filepath);
////            e.printStackTrace();
////            wb = null; // Ensure wb stays null if loading fails
////        } finally {
////            // Close FileInputStream safely
////            try {
////                if (fis != null) fis.close();
////            } catch (IOException e) {
////                System.out.println("Failed to close file input stream.");
////            }
////        }
////    }
////
////    // Get cell data safely
////    public String getCellData(int sheetno, int row, int col) {
////        validateWorkbook();
////        sh = wb.getSheetAt(sheetno);
////        DataFormatter formatter = new DataFormatter();
////
////        if (sh.getRow(row) == null || sh.getRow(row).getCell(col) == null) {
////            return ""; // Return empty if cell is missing
////        }
////        return formatter.formatCellValue(sh.getRow(row).getCell(col));
////    }
////
////    // Get row count safely
////    public int getRowcount(int sheetno) {
////        validateWorkbook();
////        sh = wb.getSheetAt(sheetno);
////        return sh.getLastRowNum();
////    }
////
////    // Get column count safely
////    public int getColcount(int sheetno) {
////        validateWorkbook();
////        sh = wb.getSheetAt(sheetno);
////        return sh.getRow(0).getLastCellNum();
////    }
////
////    // Close workbook to prevent memory leaks
////    public void closeWorkbook() {
////        try {
////            if (wb != null) wb.close();
////        } catch (IOException e) {
////            System.out.println("Failed to close workbook.");
////        }
////    }
////
////    // Validate workbook before any operation
////    private void validateWorkbook() {
////        if (wb == null) {
////            throw new IllegalStateException("Workbook is not initialized. Check file path.");
////        }
////    }
//
////    public static Map<String, String> readData(String filepath, int sheetNo) {
////        Map<String, String> dataMap = new java.util.HashMap<>();
////        FileInputStream fis = null;
////        XSSFWorkbook workbook = null;
////
////        try {
////            File file = new File(filepath);
////            if (!file.exists()) {
////                throw new IOException("Excel file not found at: " + filepath);
////            }
////
////            fis = new FileInputStream(file);
////            workbook = new XSSFWorkbook(fis);
////            XSSFSheet sheet = workbook.getSheetAt(sheetNo);
////            DataFormatter formatter = new DataFormatter();
////
////            // Assuming first row has headers and second row has values
////            int colCount = sheet.getRow(0).getLastCellNum();
////            for (int col = 0; col < colCount; col++) {
////                String key = formatter.formatCellValue(sheet.getRow(0).getCell(col)).trim();
////                String value = formatter.formatCellValue(sheet.getRow(1).getCell(col)).trim();
////                dataMap.put(key, value);
////            }
////        } catch (IOException e) {
////            System.out.println("Error reading Excel data: " + filepath);
////            e.printStackTrace();
////        } finally {
////            try {
////                if (workbook != null) workbook.close();
////                if (fis != null) fis.close();
////            } catch (IOException e) {
////                System.out.println("Failed to close resources.");
////            }
////        }
////
////        return dataMap;
////    }
////    private String excelPath;
////    
////	public ExcelReader(String excelPath) {
////		this.excelPath = excelPath;
////	}
//////
//////	// Read all non-empty cells in a given row
//////	
////	 public List<String> getColumnData(int sheetNo, int colIndex) throws Exception {
////	        List<String> columnData = new ArrayList<>();
////	        try (FileInputStream fis = new FileInputStream(excelPath);
////	             Workbook workbook = new XSSFWorkbook(fis)) {
////	            Sheet sheet = workbook.getSheetAt(sheetNo);
////	            for (Row row : sheet) {
////	                Cell cell = row.getCell(colIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
////	                String value = cell.toString().trim();
////	                if (!value.isEmpty()) {
////	                    columnData.add(value);
////	                }
////	            }
////	        }
//// 
////	        return columnData;
////	}
////	 public static Map<String, String> readData(String property, int sheetNo) {
////		// TODO Auto-generated method stub
////		return null;
////	 }
//// 
////    public static Map<String, String> readData(String filepath, int sheetNo) {
////        Map<String, String> dataMap = new java.util.HashMap<>();
////        FileInputStream fis = null;
////        XSSFWorkbook workbook = null;
////
////        try {
////            fis = new FileInputStream(filepath);
////            workbook = new XSSFWorkbook(fis);
////            XSSFSheet sheet = workbook.getSheetAt(sheetNo);
////
////            // Assuming first row has headers and second row has values
////            Row headerRow = sheet.getRow(0);
////            Row valueRow = sheet.getRow(1);
////
////            if (headerRow != null && valueRow != null) {
////                int colCount = headerRow.getLastCellNum();
////                for (int col = 0; col < colCount; col++) {
////                    String key = headerRow.getCell(col).toString().trim();
////                    String value = valueRow.getCell(col).toString().trim();
////                    if (!key.isEmpty()) {
////                        dataMap.put(key, value);
////                    }
////                }
////            }
////        } catch (Exception e) {
////            System.out.println("Error reading Excel data: " + e.getMessage());
////        } finally {
////            try {
////                if (workbook != null) workbook.close();
////                if (fis != null) fis.close();
////            } catch (Exception e) {
////                System.out.println("Failed to close resources.");
////            }
////        }
////
////        return dataMap;
////    }
////    private String excelPath;
////    
////	public ExcelReader(String excelPath) {
////		this.excelPath = excelPath;
////	}
//////
//////	// Read all non-empty cells in a given row
//////	
////	 public List<String> getColumnData(int sheetNo, int colIndex) throws Exception {
////	        List<String> columnData = new ArrayList<>();
////	        try (FileInputStream fis = new FileInputStream(excelPath);
////	             Workbook workbook = new XSSFWorkbook(fis)) {
////	            Sheet sheet = workbook.getSheetAt(sheetNo);
////	            for (Row row : sheet) {
////	                Cell cell = row.getCell(colIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
////	                String value = cell.toString().trim();
////	                if (!value.isEmpty()) {
////	                    columnData.add(value);
////	                }
////	            }
////	        }
//// 
////	        return columnData;
////	}
//// 
//    public static Map<String, String> readData(String filepath, int sheetNo) {
//        Map<String, String> dataMap = new java.util.HashMap<>();
//        try (FileInputStream fis = new FileInputStream(filepath);
//             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//            XSSFSheet sheet = workbook.getSheetAt(sheetNo);
//            Row headerRow = sheet.getRow(0);
//            Row valueRow = sheet.getRow(1); // Default row for simplicity
//
//            if (headerRow != null && valueRow != null) {
//                int colCount = headerRow.getLastCellNum();
//                for (int col = 0; col < colCount; col++) {
//                    String key = headerRow.getCell(col).toString().trim();
//                    String value = valueRow.getCell(col).toString().trim();
//                    if (!key.isEmpty()) {
//                        dataMap.put(key, value);
//                    }
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("Error reading Excel data: " + e.getMessage());
//        }
//        return dataMap;
//    }
//}