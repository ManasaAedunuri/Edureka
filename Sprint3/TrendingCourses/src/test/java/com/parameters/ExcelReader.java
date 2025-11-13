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




package com.parameters;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import java.util.*;

public class ExcelReader {

    private static Workbook workbook;

    public static void loadExcel(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            workbook = WorkbookFactory.create(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getCellData(String sheetName, int rowIndex, int colIndex) {
        if (workbook == null) {
            throw new IllegalStateException("Workbook not loaded. Call loadExcel() first.");
        }
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowIndex);
        Cell cell = row.getCell(colIndex);
        return cell.toString().trim();
    }

    public static List<List<String>> getSheetData(String sheetName) {
        List<List<String>> data = new ArrayList<>();
        Sheet sheet = workbook.getSheet(sheetName);
        for (Row row : sheet) {
            List<String> rowData = new ArrayList<>();
            for (Cell cell : row) {
                rowData.add(cell.toString().trim());
            }
            data.add(rowData);
        }
        return data;
    }
}