package org.example;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFromExcel {
    private static final String path = "C:\\Users\\kogot\\Desktop\\1.xlsx";

    public static void main(String[] args) throws IOException {
        int[][] array = new int[3][3];

        FileInputStream input = new FileInputStream(path);
        XSSFWorkbook wb = new XSSFWorkbook(input);
        input.close();

        XSSFSheet sheet = wb.getSheetAt(0);

        for (int i = 0; i < 3; i++) {
            XSSFRow row = sheet.getRow(i);
            for (int j = 0; j < 3; j++) {
                XSSFCell cell = row.getCell(j);
                array[i][j] = (int) cell.getNumericCellValue();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(array[i][j]).append(" ");
            }
            sb.append("\n");
        }
        String s = sb.toString().trim();
        System.out.println(s);
    }
}
