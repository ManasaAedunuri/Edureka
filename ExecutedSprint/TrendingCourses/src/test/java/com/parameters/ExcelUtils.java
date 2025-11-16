/*package com.parameters;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader1 {
	
	 // Read email (column 0)
    public static String getLocalityByRow0(String filePath, int sheetIndex, int rowIndex) {
        return getCellValue(filePath, sheetIndex, rowIndex,0);
    }

    // Read email (column 1)
    public static String getLocalityByRow1(String filePath, int sheetIndex, int rowIndex) {
        return getCellValue(filePath, sheetIndex, rowIndex,0);
    }

    // Read phone (column 2)
    public static String getLocalityByRow2(String filePath, int sheetIndex, int rowIndex) {
        return getCellValue(filePath, sheetIndex, rowIndex,0);
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
    
 
}*/


/*package com.parameters;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader1 {

    // Read Name (column 0)
    public static String getLocalityByRow0(String filePath, int sheetIndex, int rowIndex) {
        return getCellValue(filePath, sheetIndex, rowIndex, 0);
    }

    // Read Email (column 1)
    public static String getLocalityByRow1(String filePath, int sheetIndex, int rowIndex) {
        return getCellValue(filePath, sheetIndex, rowIndex, 1);
    }

    // Read Phone (column 2)
    public static String getLocalityByRow2(String filePath, int sheetIndex, int rowIndex) {
        return getCellValue(filePath, sheetIndex, rowIndex, 2);
    }

    // Generic method to read any cell value
    private static String getCellValue(String filePath, int sheetIndex, int rowIndex, int colIndex) {
        File file = new File(filePath);
        System.out.println("Excel file exists: " + file.exists());

        try (FileInputStream fis = new FileInputStream(file);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(sheetIndex);
            Row row = sheet.getRow(rowIndex);

            if (row != null) {
                Cell cell = row.getCell(colIndex);
                if (cell != null) {
                    if (cell.getCellType() == CellType.NUMERIC) {
                        return String.valueOf((long) cell.getNumericCellValue()); // Handles phone numbers
                    } else if (cell.getCellType() == CellType.STRING) {
                        return cell.getStringCellValue().trim();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}*/


/*package com.parameters;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader1 {

    // Read Name from row 0
	public static String getName(String filePath, int sheetIndex) {
	    return getCellValue(filePath, sheetIndex, 0, 0); // row 0, col 0
	}

	public static String getEmail(String filePath, int sheetIndex) {
	    return getCellValue(filePath, sheetIndex, 0, 1); // row 1, col 0
	}

	public static String getPhone(String filePath, int sheetIndex) {
	    return getCellValue(filePath, sheetIndex, 0, 2); // row 2, col 0
	}

	private static String getCellValue(String filePath, int sheetIndex, int rowIndex, int colIndex) {
	    File file = new File(filePath);
	    System.out.println("Excel file exists: " + file.exists());

	    try (FileInputStream fis = new FileInputStream(file);
	         Workbook workbook = new XSSFWorkbook(fis)) {

	        Sheet sheet = workbook.getSheetAt(sheetIndex);
	        Row row = sheet.getRow(rowIndex);

	        if (row != null) {
	            Cell cell = row.getCell(colIndex);
	            if (cell != null) {
	                if (cell.getCellType() == CellType.NUMERIC) {
	                    return String.valueOf((long) cell.getNumericCellValue());
	                } else if (cell.getCellType() == CellType.STRING) {
	                    return cell.getStringCellValue().trim();
	                }
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return null;
	}
}*/


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





