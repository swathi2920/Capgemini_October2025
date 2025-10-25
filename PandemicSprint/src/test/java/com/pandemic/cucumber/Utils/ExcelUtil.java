package com.pandemic.cucumber.Utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.*;

public class ExcelUtil {

    public static String readEmailFromExcel(String fileName, String sheetName, int rowNum) {
        String email = "";
        try {
            String filePath = "src/test/resources/config/" + fileName;
            FileInputStream fis = new FileInputStream(new File(filePath));

            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheet(sheetName);

            Row row = sheet.getRow(rowNum); // Row index 1 = second row (after header)
            if (row != null && row.getCell(0) != null) {
                email = row.getCell(0).getStringCellValue();
            }

            workbook.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return email;
    }
}
