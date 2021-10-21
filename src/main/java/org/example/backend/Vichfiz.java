package org.example.backend;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Vichfiz {
    private static final int[][] array = {{1, 1, 1}, {3, 3, 3}, {2, 2, 2}};
    private static final int harmonicSeriesLimit = 1000000;

    public static void writeToExcel(File file) {
        try {
            FileOutputStream out = new FileOutputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook();
            wb.createSheet("first sheet");
            XSSFSheet sheet = wb.getSheet("first sheet");
            Iterator<Row> rowIter = sheet.rowIterator();
            for (int i = 0; i < 3; i++) {
                XSSFRow row = sheet.createRow(i);
                for (int j = 0; j < 3; j++) {
                    XSSFCell cell = row.createCell(j);
                    cell.setCellValue(array[i][j]);
                }
            }
            wb.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String[][] readFromExcel(File file) {
        try {
            FileInputStream in = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(in);
            XSSFSheet sheet = wb.getSheetAt(0);
            List<Integer> rowIndexes = new ArrayList<>();
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                XSSFRow row = sheet.getRow(i);
                if (row == null) {
                    continue;
                }
                rowIndexes.add(i);
            }

            int columnMaxCount = 0;
            for (Integer rowIndex : rowIndexes) {
                int c = sheet.getRow(rowIndex).getLastCellNum();
                if (c > columnMaxCount) {
                    columnMaxCount = c;
                }
            }

            String[][] result = new String[rowIndexes.size()][columnMaxCount];
            for (Integer rowIndex : rowIndexes) {
                XSSFRow row = sheet.getRow(rowIndex);
                for (int i = 0; i < columnMaxCount; i++) {
                    XSSFCell cell = row.getCell(i);
                    if (cell == null) {
                        result[rowIndex][i] = "";
                        continue;
                    }
                    result[rowIndex][i] = cell.getRawValue();
                }
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static double getStraightHarmonicSum() {
        double s = 0d;
        for (double i = 1d; i <= (double) harmonicSeriesLimit; i++) {
            s += 1d / i;
        }
        return s;
    }

    public static double getReversedHarmonicSum() {
        double s = 0d;
        for (double i = (double) harmonicSeriesLimit; i >= 1d; i--) {
            s += 1d / i;
        }
        return s;
    }

    public static double getHarmonicSum(double termLowerBound) {
        if (termLowerBound <= 0d) {
            return 0d;
        }
        double s = 0d;
        double i = 1d;
        double term = 1d;
        while (term > termLowerBound) {
            term = 1d / i;
            i++;
            s += term;
        }
        return s;
    }

    public static double getSumFromHomework(double termLowerBound) {
        if (termLowerBound <= 0d) {
            return 0d;
        }
        double s = 0d;
        double i = 1d;
        double term = 1d;
        while (term > termLowerBound) {
            term = i / ((i * i) + 2);
            i++;
            s += term;
        }
        return s;
    }

    public static int getHarmonicSeriesLimit() {
        return harmonicSeriesLimit;
    }

    public static String getQuadEquationSolution(double a, double b, double c) {
        double discriminant = Math.pow(b, 2d) - 4d * a * c;
        if (discriminant < 0) {
            return "Нет действительных решений";
        } else {
            if (a == 0d) {
                if (b == 0d) {
                    if (c == 0d) {
                        return "все действительные числа";
                    }
                    return "нет решений";
                }
                return "x = " + (-1d * c / b);
            }
            double d = Math.sqrt(discriminant);
            return "x1 = " + ((-1d * b + d) / (2d * a)) + "; x2 = " + ((-1d * b - d) / (2d * a));
        }
    }

    public static List<Solution> getLinearSystem2by2Solutions(
            double a,
            double b,
            double c,
            double d,
            double f,
            double g) {
        List<Solution> solutionList = new ArrayList<>();
        double det = a * d - b * c;
        if (det == 0d) {
            solutionList.add(new Solution("бесконечно много решений", ""));
            return solutionList;
        }
        double detX = f * d - g * b;
        double detY = g * a - f * c;
        solutionList.add(new Solution("", "x = "+detX/det));
        solutionList.add(new Solution("", "y = "+detY/det));
        return solutionList;
    }
}
