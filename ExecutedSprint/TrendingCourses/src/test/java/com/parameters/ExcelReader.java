/*package com.parameters;


	import java.io.FileInputStream;
	import java.util.*;
	import org.apache.poi.ss.usermodel.*;
	 
	public class ExcelReader {
	    public static List<List<String>> getExcelData(String filePath, int sheetIndex) {
	        List<List<String>> data = new ArrayList<>();
	        try (FileInputStream fis = new FileInputStream(filePath);
	             Workbook workbook = WorkbookFactory.create(fis)) {
	            Sheet sheet = workbook.getSheetAt(sheetIndex);
	            for (Row row : sheet) {
	                List<String> rowData = new ArrayList<>();
	                for (Cell cell : row) {
	                    rowData.add(cell.toString());
	                }
	                data.add(rowData);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return data;
	    }
	}*/
	
	
	
	//=============================
	/*package com.parameters;

	import java.io.FileInputStream;
	import org.apache.poi.ss.usermodel.*;

	public class ExcelReader {
	    public static String getCellData(String sheetName, int row, int col) {
	        try (FileInputStream fis = new FileInputStream("src/test/resources/testdata.xlsx")) {
	            Workbook wb = WorkbookFactory.create(fis);
	            Sheet sheet = wb.getSheet(sheetName);
	            Row r = sheet.getRow(row);
	            Cell c = r.getCell(col);
	            return c.toString();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "";
	        }
	    }
	}*/




//package com.parameters;
// 
//import java.io.File;
//
//import java.io.FileInputStream;
// 
//import org.apache.poi.ss.usermodel.Cell;
//
//import org.apache.poi.ss.usermodel.Row;
//
//import org.apache.poi.ss.usermodel.Sheet;
//
//import org.apache.poi.ss.usermodel.Workbook;
//
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
// 
//public class ExcelReader {
//
//public static String getLocalityByRow(String filePath, int sheetIndex, int rowIndex) {
//
//	File file = new File(filePath);
//
//    System.out.println("Excel file exists: " + file.exists());
//
//    try (FileInputStream fis = new FileInputStream(filePath);
//
//         Workbook workbook = new XSSFWorkbook(fis)) {
//
//        Sheet sheet = workbook.getSheetAt(sheetIndex);
//
//        Row row = sheet.getRow(rowIndex);
//
//        if (row != null) {
//
//            Cell cell = row.getCell(0);
//
//            if (cell != null) {
//
//                return cell.getStringCellValue().trim();
//
//            }
//
//        }
//
//    } catch (Exception e) {
//
//        e.printStackTrace();
//
//    }
//
//return null;
//
//}
//
//public static String getLocalityByRow1(String filePath, int sheetIndex, int rowIndex) {
//
//	File file = new File(filePath);
//
//    System.out.println("Excel file exists: " + file.exists());
//
//    try (FileInputStream fis = new FileInputStream(filePath);
//
//         Workbook workbook = new XSSFWorkbook(fis)) {
//
//        Sheet sheet = workbook.getSheetAt(sheetIndex);
//
//        Row row = sheet.getRow(rowIndex);
//
//        if (row != null) {
//
//            Cell cell = row.getCell(0);
//
//            if (cell != null) {
//
//                return cell.getStringCellValue().trim();
//
//            }
//
//        }
//
//    } catch (Exception e) {
//
//        e.printStackTrace();
//
//    }
//
//return null;
//
//}
//
//public static String getLocalityByRow(String excelPath, int i, Integer rowIndex, int j) {
//	// TODO Auto-generated method stub
//	return null;
//}
//
//}
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