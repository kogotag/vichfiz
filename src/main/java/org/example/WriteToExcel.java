package org.example;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class WriteToExcel {
    private static final int[][] array = {{1, 1, 1}, {3, 3, 3}, {2, 2, 2}};

    public static void main(String[] args) throws IOException {
        String path = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParent();
        File wbFile = new File(path + "/test.csv");
        if (!wbFile.exists()) {
            wbFile.createNewFile();
        }
        HSSFWorkbook wb = new HSSFWorkbook();
        wb.createSheet("first sheet");
        HSSFSheet sheet = wb.getSheet("first sheet");
        Iterator<Row> rowIter = sheet.rowIterator();
        for (int i = 0; i < 3; i++) {
            HSSFRow row = sheet.createRow(i);
            for (int j = 0; j < 3; j++) {
                HSSFCell cell = row.createCell(j);
                cell.setCellValue(array[i][j]);
            }
        }
        FileOutputStream out = new FileOutputStream(wbFile);
        wb.write(out);
        out.close();
    }
}
