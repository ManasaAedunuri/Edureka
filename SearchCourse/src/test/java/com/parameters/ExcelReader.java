package com.parameters;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.ss.usermodel.*;
import java.util.HashMap;
import java.util.Map;

public class ExcelReader {

	/* Scenario Outline 1 excel */
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
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static final String FILE_PATH = "src\\test\\resources\\ExcelData\\scenario_outline_wb.xlsx";
	public static Map<String, String> getRowData(String sheetName, int rowNum) {
		Map<String, String> data = new HashMap<>();
		try (FileInputStream fis = new FileInputStream(FILE_PATH);
				Workbook workbook = new XSSFWorkbook(fis)) {
			Sheet sheet = workbook.getSheet(sheetName);
			if (sheet == null) {
				throw new RuntimeException("Sheet " + sheetName + " not found in Excel file");
			}
			Row headerRow = sheet.getRow(0);
			Row dataRow = sheet.getRow(rowNum);
			if (headerRow == null || dataRow == null) {
				throw new RuntimeException("Invalid row index: " + rowNum);
			}
			for (int i = 0; i < headerRow.getLastCellNum(); i++) {
				Cell headerCell = headerRow.getCell(i);
				Cell valueCell = dataRow.getCell(i);
				if (headerCell != null && valueCell != null) {
					String key = headerCell.getStringCellValue().trim();
					String value = getCellValue(valueCell);
					data.put(key, value);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("Error reading Excel: " + e.getMessage());
		}
		return data;
	}

	private static String getCellValue(Cell cell) {
		if (cell == null) return "";
		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue().trim();
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				return cell.getDateCellValue().toString();
			} else {
				// Convert numeric to long if it's an integer-like value
				double numericValue = cell.getNumericCellValue();
				if (numericValue == Math.floor(numericValue)) {
					return String.valueOf((long) numericValue);
				} else {
					return String.valueOf(numericValue);
				}
			}
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case FORMULA:
			return cell.getCellFormula();

		default:
			return "";
		}
	}	 
}

