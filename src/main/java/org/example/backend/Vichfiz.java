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
    /** Двумерный массив для проверки записи в Excel*/
    private static final Integer[][] testArray = {{1, 1, 1}, {3, 3, 3}, {2, 2, 2}};

    /** Количество слагаемых в гармоническом ряде*/
    private static final int harmonicSeriesLimit = 1000000;

    /** Запись массива testArray в выбранный Excel файл в самых верхних левых ячейках*/
    public static void writeToExcel(File file) {
        Table2D<Integer> testTable = new Table2D<Integer>(testArray);
        writeToExcel(file, 0, testTable);
    }

    /** Метод записи таблицы table объектов класс T в Excel файл file с отступом вправо offset*/
    public static <T> void writeToExcel(File file, int offset, Table2D<T> table) {
        try {
            // Открывает выходной поток для записи в файл
            FileOutputStream out = new FileOutputStream(file);

            // Создаём книгу и лист в экселе
            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet sheet;

            // Если лист 0 не найден, создаём свой
            if (wb.getNumberOfSheets() <= 0) {
                sheet = wb.createSheet("first sheet");
            } else {
                sheet = wb.getSheetAt(0);
            }

            // Запись таблицы в выбранный лист с помощью двух циклов по i, j
            for (int i = 0; i < table.getWidth(); i++) {
                //создаём строку в i
                XSSFRow row = sheet.createRow(i);

                for (int j = 0; j < table.getLength(); j++) {
                    // Создаём ячейку в строке i в j+offset столбце
                    XSSFCell cell = row.createCell(j + offset);

                    // Получаем значение таблицы в j, i
                    T val = table.getTable()[j][i];

                    // Если значение число, ток в ячейку запишем число
                    if (val instanceof Number) {
                        cell.setCellValue(((Number) val).doubleValue());

                        // Иначе вызываем toString() объекта, который вернёт строку,
                        // описывающую данный объект
                    } else {
                        cell.setCellValue(val.toString());
                    }
                }
            }

            // Записываем книгу Excel в поток записи
            wb.write(out);
            // Закрываем поток
            out.close();
            // Если появилось исключение, просто выводим его информацию
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** Метод для чтения таблицы из файла Excel.
     * Этот метод возвращает максимально найденную таблицу в первом листе Excel файла.*/
    public static String[][] readFromExcel(File file) {
        try {
            // Открываем входной поток
            FileInputStream in = new FileInputStream(file);

            // Получаем книгу и лист из файла
            XSSFWorkbook wb = new XSSFWorkbook(in);
            XSSFSheet sheet = wb.getSheetAt(0);

            // Получаем список индексов строк
            List<Integer> rowIndexes = new ArrayList<>();
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                // Получаем строку под номером i
                XSSFRow row = sheet.getRow(i);

                // Если строка не найдена, переходим к следующей итерации цикла
                if (row == null) {
                    continue;
                }

                // Если найдена, добавляем в список номер i
                rowIndexes.add(i);
            }

            // Определяем максимальный номер столбца в листе
            int columnMaxCount = 0;
            for (Integer rowIndex : rowIndexes) {
                int c = sheet.getRow(rowIndex).getLastCellNum();
                if (c > columnMaxCount) {
                    columnMaxCount = c;
                }
            }

            // Создаём двумерный массив строк, в который будем записывать результат чтения из файла
            String[][] result = new String[rowIndexes.size()][columnMaxCount];

            // Цикл for-each по индексам строк
            for (Integer rowIndex : rowIndexes) {
                // Получаем строку по индексу
                XSSFRow row = sheet.getRow(rowIndex);

                // Цикл по столбцам
                for (int i = 0; i < columnMaxCount; i++) {
                    // Получаем ячейку под номером i в данной строке
                    XSSFCell cell = row.getCell(i);

                    // Если ячейка не найдена, добавляем пустую строку в результирующий массив
                    if (cell == null) {
                        result[rowIndex][i] = "";
                        // Пропускаем дальнейший код и переходим к следующей итерации цикла
                        continue;
                    }

                    // Записываем в результирующий массив значение ячейки
                    result[rowIndex][i] = cell.getRawValue();
                }
            }

            // Метод возвращает полученный массив строк
            return result;

            // Если было найдено исключение, выводим о нём информацию
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Если метод не вернул значение из-за ошибки, возвращаем нулевой объект
        return null;
    }

    /** Метод для чтения таблицы из файла Excel.
     * Этот метод возвращает таблицу с отступом вправо в документе offset,
     * размерами rows строк и cols столбцов*/
    public static String[][] readFromExcel(File file, int offset, int rows, int cols) {
        try {
            // Открываем входной поток
            FileInputStream in = new FileInputStream(file);

            // Получаем книгу и лист Excel из файла
            XSSFWorkbook wb = new XSSFWorkbook(in);
            XSSFSheet sheet = wb.getSheetAt(0);

            // Если нижняя граница таблицы находится ниже последней строки в файле, возвращаем нулевой объект
            if (rows - 1 > sheet.getLastRowNum()) {
                return null;
            }

            // Создаём список индексов строк
            List<Integer> rowIndexes = new ArrayList<>();
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                // Получаем строку под номером i
                XSSFRow row = sheet.getRow(i);

                // Если строка не найдена, переходим к следующей итерации цикла
                if (row == null) {
                    continue;
                }

                // Если строка найдена, добавляем в список её номер
                rowIndexes.add(i);
            }

            // Создаём двумерный массив строк, в который будем записывать результаты чтения из файла
            String[][] result = new String[rowIndexes.size()][cols];

            // Цикл по строкам
            for (Integer rowIndex : rowIndexes) {
                // Получаем строку
                XSSFRow row = sheet.getRow(rowIndex);

                //Цикл по столбцам со смещением вправо на offset
                for (int i = offset; i < cols + offset; i++) {
                    // Получаем ячейку под номером i
                    XSSFCell cell = row.getCell(i);

                    // Если ячейка не найдена
                    if (cell == null) {
                        // Записываем в результирующий массив пустую строку
                        result[rowIndex][i] = "";
                        // Переходим к следующей итерации цикла
                        continue;
                    }

                    // Если ячейка найдена, записываем в результирующий массив значение ячейки
                    result[rowIndex][i] = cell.getRawValue();
                }
            }

            // Метод возвращает полученный массив
            return result;
            // Если появилось исключение, выводим о нём информацию
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Если метод не вернул массив, возвращаем нулевой объект
        return null;
    }

    /** Метод, преобразующий прочитанный из файла Excel массив в Graphic2D.
     * offset — смещение данных в файле вправо,
     * dotsCount — количество точек графика*/
    public static Graphic2D getGraphicFromExcel(File file, int offset, int dotsCount) {
        // Получаем двумерный массив строк из файла Excel
        String[][] stringDots = readFromExcel(file, offset, dotsCount, 2);

        // Если был получен нулевой объект, либо массив меньшей длинны, возвращаем нулевой объект
        if (stringDots == null || stringDots.length < dotsCount) {
            return null;
        }

        // Создаём график, в который будем записывать значения
        Graphic2D graphic2D = new Graphic2D(dotsCount);
        // Одномерный массив для координат X
        double[] arrayOfX = new double[dotsCount];
        // Одномерный массив для координат Y
        double[] arrayOfY = new double[dotsCount];
        try {
            // Цикл с двумя итерациями
            for (int i = 0; i < 2; i++) {
                // Цикл по всем точкам графика
                for (int j = 0; j < dotsCount; j++) {
                    // Получаем численное значение из строкового
                    // Если строка не может быть преобразована, бросается исключение NumberFormatException
                    // Его мы пока не обрабатываем
                    double val = Double.parseDouble(stringDots[j][i]);
                    // В первом массиве значения X
                    if (i == 0) {
                        arrayOfX[j] = val;
                    }
                    // Во втором Y
                    else {
                        arrayOfY[j] = val;
                    }
                }
            }
        } catch (NumberFormatException ignored) {
        }
        // Присваиваем полям объекта график полученные массивы
        graphic2D.setArrayOfX(arrayOfX);
        graphic2D.setArrayOfY(arrayOfY);

        // Возврщааем полученный график
        return graphic2D;
    }

    /** Метод, вычисляющий значение суммы гармонического ряда с 1 000 000 слагаемых
     * при суммировании от первого элемента к последнему*/
    public static double getStraightHarmonicSum() {
        // Инициализируем сумму как 0
        double s = 0d;

        // Цикл от 1 до 1 000 000
        for (double i = 1d; i <= (double) harmonicSeriesLimit; i++) {
            // Прибавляем к сумме значение элемента гармонического ряда
            s += 1d / i;
        }

        // Возвращаем сумму
        return s;
    }

    /** Метод, вычисляющий значение суммы гармонического ряда с 1 000 000 слагаемых
     * при суммировании от последнего элемента к первому*/
    public static double getReversedHarmonicSum() {
        // Инициализируем сумму как 0
        double s = 0d;

        // Цикл от 1 000 000 до 1
        for (double i = (double) harmonicSeriesLimit; i >= 1d; i--) {
            // Прибавляем к сумме значение элемента гармонического ряда
            s += 1d / i;
        }

        // Возвращаем сумму
        return s;
    }

    /** Метод, вычисляющий значение суммы гармонического ряда
     * при суммировании до тех пора, пока элемент суммы не станет меньше значения termLowerBound*/
    public static double getHarmonicSum(double termLowerBound) {
        // Если передано неположительное значение, сразу возвращаем 0,
        // чтобы избежать бесконечного цикла
        if (termLowerBound <= 0d) {
            return 0d;
        }

        // Сумма
        double s = 0d;
        // Номер элемента
        double i = 1d;
        // Слагаемое
        double term = 1d;
        // Пока слагаемое больше termLowerBound
        while (term > termLowerBound) {
            // Вычисляем значение элемента гармонического ряда
            term = 1d / i;

            // Увеличиваем номер на 1
            i++;

            // Прибавляем к сумме слагаемое
            s += term;
        }

        // Возвращаем сумму
        return s;
    }

    /** Метод, вычисляющий значение суммы ряда из домашнего задания
     * при суммировании до тех пора, пока элемент суммы не станет меньше значения termLowerBound*/
    public static double getSumFromHomework(double termLowerBound) {
        // Если передано неположительное значение, сразу возвращаем 0,
        // чтобы избежать бесконечного цикла
        if (termLowerBound <= 0d) {
            return 0d;
        }

        // Сумма
        double s = 0d;
        // Номер элемента
        double i = 1d;
        // Слагаемое
        double term = 1d;
        // Пока слагаемое больше termLowerBound
        while (term > termLowerBound) {
            // Вычисляем значение элемента данного ряда
            term = i / ((i * i) + 2);

            // Увеличиваем номер на 1
            i++;

            // Прибавляем к сумме слагаемое
            s += term;
        }

        // Возвращаем сумму
        return s;
    }

    public static int getHarmonicSeriesLimit() {
        return harmonicSeriesLimit;
    }

    /** Метод, возвращающий строку, содержащую решение квадратного уравнения ax^2 + bx + c = 0*/
    public static String getQuadEquationSolution(double a, double b, double c) {
        // Вычисляем дискриминант
        double discriminant = Math.pow(b, 2d) - 4d * a * c;

        // Если дискриминант меньше нуля, действительных решений нет
        if (discriminant < 0) {
            return "Нет действительных решений";
        }
        else {
            if (a == 0d) {
                if (b == 0d) {
                    if (c == 0d) {
                        // Если все коэффициенты равны нулю, уравнение принимает вид 0 = 0,
                        // что справедливо на множестве всех чисел
                        return "все действительные числа";
                    }
                    // a и b равны нулю, а c не равно нулю. const = 0 не выполняется ни при каких условиях
                    return "нет решений";
                }
                // Линейное уравнение
                return "x = " + (-1d * c / b);
            }
            // Классическое квадратное уравнение с положительным дискриминантом
            // (или равным нулю, что даст кратные корни)

            // Вычисляем корень из дискриминанта
            double d = Math.sqrt(discriminant);

            // Возвращаем решение квадратного уравнения
            return "x1 = " + ((-1d * b + d) / (2d * a)) + "; x2 = " + ((-1d * b - d) / (2d * a));
        }
    }

    /** Метод, возвращающий решение системы линейных уравнений 2 на 2.
     * Данный метод ещё не завершён.*/
    public static List<Solution> getLinearSystem2by2Solutions(
            double a,
            double b,
            double c,
            double d,
            double f,
            double g) {
        List<Solution> solutionList = new ArrayList<>();
        double det = a * d - b * c;
        double detX = f * d - g * b;
        double detY = g * a - f * c;
        if (det == 0d) {
            if(detX == 0 && detY == 0){
                solutionList.add(new Solution("бесконечно много решений", ""));
                return solutionList;
            }
            solutionList.add(new Solution("нет решений", ""));
            return solutionList;
        }
        solutionList.add(new Solution("", "x = " + detX / det));
        solutionList.add(new Solution("", "y = " + detY / det));
        return solutionList;
    }

    /** Метод, возвращающий график двумерной функции, полученной путём интерполяции
     * с помощью полинома Лагранжа из другого графика*/
    public static Graphic2D getLagrangePolynomialInterpolation(Graphic2D interpolationDots,
                                                               double abscissaStep,
                                                               double functionDomainLeftBorder,
                                                               double functionDomainRightBorder) {
        // Если левая граница функции правее правой границы или
        // шаг по оси абсцисс меньше либо равен нулю или
        // график, по которому будет произведена интерполяция не найден
        if (functionDomainLeftBorder >= functionDomainRightBorder
                || abscissaStep <= 0d
                || interpolationDots == null) {
            // Возвращаем нулевой объект
            return null;
        }

        // Вычисляем количество точек результирующего графика
        int dotsCount = (int) ((functionDomainRightBorder - functionDomainLeftBorder) / abscissaStep);

        // Создаём график, в который будет записан результат
        Graphic2D graphic = new Graphic2D(dotsCount);

        // Цикл по всем точкам с индексом i
        for (int i = 0; i < dotsCount; i++) {
            // Вычисляем значение x
            double x = functionDomainLeftBorder + abscissaStep * i;

            // y как сумму приравнием к нулю
            double y = 0d;

            // Цикл по j по всем точкам
            for (int j = 0; j < interpolationDots.getDotsCount(); j++) {
                // Инициализируем слагаемое как значение y в данной точке
                double term = interpolationDots.getArrayOfY()[j];

                // Цикл по k по всем точкам
                for (int k = 0; k < interpolationDots.getDotsCount(); k++) {
                    if (j == k) {
                        // Переходим к следующей итерации данного цикла
                        continue;
                    }

                    // Домножаем слагаемое на значение произведения в полиноме лагранжа
                    term *= (x - interpolationDots.getArrayOfX()[k])
                            / (interpolationDots.getArrayOfX()[j] - interpolationDots.getArrayOfX()[k]);
                }

                // Прибавляем к y слагаемое
                y += term;
            }

            // Результаты записываем в график
            graphic.getArrayOfX()[i] = x;
            graphic.getArrayOfY()[i] = y;
        }

        // Возвращаем график
        return graphic;
    }
}
