package org.example.backend;

public class Graphic2D {
    private int dotsCount;
    private double[] arrayOfX;
    private double[] arrayOfY;

    public Graphic2D(int dotsCount) {
        this.dotsCount = dotsCount;
        arrayOfX = new double[dotsCount];
        arrayOfY = new double[dotsCount];
    }

    public int getDotsCount() {
        return dotsCount;
    }

    public double[] getArrayOfX() {
        return arrayOfX;
    }

    public void setArrayOfX(double[] arrayOfX) {
        this.arrayOfX = arrayOfX;
    }

    public double[] getArrayOfY() {
        return arrayOfY;
    }

    public void setArrayOfY(double[] arrayOfY) {
        this.arrayOfY = arrayOfY;
    }

    public Table2D<Double> getTable2D() {
        Double[][] array = new Double[2][dotsCount];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < dotsCount; j++) {
                if (i == 0) {
                    array[i][j] = arrayOfX[j];
                } else {
                    array[i][j] = arrayOfY[j];
                }
            }
        }
        return new Table2D<Double>(array);
    }
}
