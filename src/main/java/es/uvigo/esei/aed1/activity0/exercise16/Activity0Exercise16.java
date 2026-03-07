package es.uvigo.esei.aed1.activity0.exercise16;

import java.util.Scanner;

public class Activity0Exercise16 {
    // Exercise 16

    /**
     * Calcula el máximo de los enteros almacenados en el array
     * 
     * @param array contiene los enteros
     * @return el valor mínimo
     */
    public static int maximum(int[] array) {
        int max = 0;
        for (int n : array) {
            if (n > max)
                max = n;
        }
        return max;
    }

    /**
     * Calcula el mínimo de los enteros almacenados en el array
     * 
     * @param array contiene los enteros
     * @return el valor mínimo
     */
    public static int minimum(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int n : array) {
            if (n < min)
                min = n;
        }
        return min;
    }

    /**
     * Calcula el promedio de los enteros almacenados en el array
     * 
     * @param array contiene los enteros
     * @return el valor promedio
     */
    public static double average(int[] array) {
        int sum = 0;
        for (int n : array) {
            sum += n;
        }
        return sum / array.length;
    }

    public static int readInteger(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextInt();
    }

    /**
     * almacena enteros en el array haciendo uso del método readInteger
     * 
     * @param array que almacenará los enteros
     */
    public static void readArray(int[] array) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            array[i] = readInteger(scanner, "Introduce el valor #" + (i + 1) + ": ");
        }
        scanner.close();
    }
}
