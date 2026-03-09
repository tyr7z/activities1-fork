package es.uvigo.esei.aed1.activity0.exercise17;

import java.util.Scanner;

public class Activity0Exercise17 {
    // Exercise 17
    /**
     * muestra un mensaje por pantalla y lee un número entero de teclado
     * 
     * @param message el mensaje a visualizar
     * @return el número entero leido de teclado
     */
    public static int readNumber(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextInt();
    }

    /**
     * muestra un mensaje por pantalla y lee un número real de teclado
     * 
     * @param message el mensaje a visualizar
     * @return el número real leido de teclado
     */
    public static double readDouble(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextDouble();
    }

    /**
     * muestra un mensaje por pantalla y lee una matriz de números reales
     * 
     * @param matrix  que almacena números reales
     * @param message el mensaje a visualizar
     */
    public static void readGrades(Scanner scanner, double[][] matrix, String message) {
        System.out.println(message);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println("Alumno " + (i + 1) + ":");
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = readDouble(scanner, "Introduce una nota: ");
            }
        }
    }

    /**
     * muestra por pantalla un mensaje y el contenido de una matriz de números
     * reales
     * 
     * @param matrix  que almacena numeros reales
     * @param message el mensaje a visualizar
     */
    public static void printGrades(double[][] matrix, String message) {
        System.out.println(message);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println("Alumno " + (i + 1) + ":");
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.println(matrix[i][j]);
            }
        }
    }
}
