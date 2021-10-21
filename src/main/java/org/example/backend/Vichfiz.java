package org.example.backend;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Vichfiz {
    private static final Integer[][] testArray = {{1, 1, 1}, {3, 3, 3}, {2, 2, 2}};
    private static final int harmonicSeriesLimit = 1000000;

    public static void writeToExcel(File file) {
        Table2D<Integer> testTable = new Table2D<Integer>(testArray);
        writeToExcel(file, 0, testTable);
    }

    public static <T> void writeToExcel(File file, int offset, Table2D<T> table) {
        try {
            FileOutputStream out = new FileOutputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet sheet;
            if (wb.getNumberOfSheets() <= 0) {
                sheet = wb.createSheet("first sheet");
            } else {
                sheet = wb.getSheetAt(0);
            }
            for (int i = 0; i < table.getWidth(); i++) {
                XSSFRow row = sheet.createRow(i);
                for (int j = 0; j < table.getLength(); j++) {
                    XSSFCell cell = row.createCell(j + offset);
                    T val = table.getTable()[j][i];
                    if (val instanceof Number) {
                        cell.setCellValue(((Number) val).doubleValue());
                    } else {
                        cell.setCellValue(val.toString());
                    }
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

    //not tested yet
    public static String[][] readFromExcel(File file, int offset, int rows, int cols) {
        try {
            FileInputStream in = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(in);
            XSSFSheet sheet = wb.getSheetAt(0);
            if (rows - 1 > sheet.getLastRowNum()) {
                return null;
            }
            List<Integer> rowIndexes = new ArrayList<>();
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                XSSFRow row = sheet.getRow(i);
                if (row == null) {
                    continue;
                }
                rowIndexes.add(i);
            }

            String[][] result = new String[rowIndexes.size()][cols];
            for (Integer rowIndex : rowIndexes) {
                XSSFRow row = sheet.getRow(rowIndex);
                for (int i = offset; i < cols + offset; i++) {
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

    public static Graphic2D getGraphicFromExcel(File file, int offset, int dotsCount) {
        String[][] stringDots = readFromExcel(file, offset, dotsCount, 2);
        if (stringDots == null || stringDots.length < 1) {
            return null;
        }
        Graphic2D graphic2D = new Graphic2D(dotsCount);
        double[] arrayOfX = new double[dotsCount];
        double[] arrayOfY = new double[dotsCount];
        try {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < dotsCount; j++) {
                    double val = Double.parseDouble(stringDots[j][i]);
                    if (i == 0) {
                        arrayOfX[j] = val;
                    } else {
                        arrayOfY[j] = val;
                    }
                }
            }
        } catch (NumberFormatException ignored) {
        }
        graphic2D.setArrayOfX(arrayOfX);
        graphic2D.setArrayOfY(arrayOfY);
        return graphic2D;
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
        solutionList.add(new Solution("", "x = " + detX / det));
        solutionList.add(new Solution("", "y = " + detY / det));
        return solutionList;
    }

    public static Graphic2D getLagrangePolynomialInterpolation(Graphic2D interpolationDots,
                                                               double abscissaStep,
                                                               double functionDomainLeftBorder,
                                                               double functionDomainRightBorder) {
        if (functionDomainLeftBorder >= functionDomainRightBorder
                || abscissaStep <= 0d
                || interpolationDots == null) {
            return null;
        }
        int dotsCount = (int) ((functionDomainRightBorder - functionDomainLeftBorder) / abscissaStep);

        Graphic2D graphic = new Graphic2D(dotsCount);

        for (int i = 0; i < dotsCount; i++) {
            double x = functionDomainLeftBorder + abscissaStep * i;

            double y = 0d;

            for (int j = 0; j < interpolationDots.getDotsCount(); j++) {
                double term = interpolationDots.getArrayOfY()[j];

                for (int k = 0; k < interpolationDots.getDotsCount(); k++) {
                    if (j == k) {
                        continue;
                    }

                    term *= (x - interpolationDots.getArrayOfX()[k])
                            / (interpolationDots.getArrayOfX()[j] - interpolationDots.getArrayOfX()[k]);
                }
                y += term;
            }

            graphic.getArrayOfX()[i] = x;
            graphic.getArrayOfY()[i] = y;
        }
        return graphic;
    }
}
