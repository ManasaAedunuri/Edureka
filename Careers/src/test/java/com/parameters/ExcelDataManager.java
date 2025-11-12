package com.parameters;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ExcelDataManager {
    private static List<String[]> excelData;
    private static AtomicInteger rowCounter = new AtomicInteger(0);

    static {
        String filePath = "src/test/resources/Exceldata/Data.xlsx";
        //excelData = ExcelReader.readExcel(filePath);
    }

    public static String[] getNextRow() {
        int index = rowCounter.getAndIncrement();
        if (index >= excelData.size()) {
            throw new RuntimeException("No more rows available in Excel!");
        }
        return excelData.get(index);
    }
}
