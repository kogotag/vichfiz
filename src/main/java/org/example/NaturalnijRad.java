package org.example;

public class NaturalnijRad {
    public static void main(String[] args) {
        double j = 0;
        for (double i = 1d; i <= 1000000d; i++) {
            j += 1d / i;
        }
        System.out.println(j);
        j = 0;
        for (double i = 1000000d; i >= 1d; i--) {
            j += 1d / i;
        }
        System.out.println(j);
        j = 0;
        double i = 0d, k = 0d;
        do {
            k += 1d;
            i = 1d / k;
            j += i;
        } while (i > 0.1d);
        System.out.println(j);
    }
}
