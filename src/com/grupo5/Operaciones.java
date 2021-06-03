package com.grupo5;

public class Operaciones {

    public static int[][] suma(int [][] matriz1, int [][]matriz2){
        int [][] matriz_r = new int [matriz1.length][matriz2[0].length];
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz2[0].length; j++) {
                matriz_r[i][j] = matriz1[i][j] + matriz2[i][j];

            }

        }
        return matriz_r;
    }

    public static int[][] resta(int [][] matriz1, int [][]matriz2){
        int matriz_r[][] = new int [matriz1.length][matriz2[0].length];
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz2[0].length; j++) {
                matriz_r[i][j] = matriz1[i][j] - matriz2[i][j];

            }

        }
        return matriz_r;
    }

    public static int[][] multiplicacion(int [][] matriz1, int [][]matriz2){
        int matriz_r[][] = new int [matriz1.length][matriz2[0].length];
        for (int a = 0; a < matriz2[0].length; a++) {
            for (int i = 0; i < matriz1.length; i++) {
                int suma = 0;
                for (int j = 0; j < matriz1[0].length; j++) {
                    suma += matriz1[i][j] * matriz2[j][a];
                }
                matriz_r[i][a] = suma;
            }
        }
        return matriz_r;
    }
    public static int[][] transpuesta(int [][] matriz1){
        int matriz_r[][] = new int [matriz1.length][matriz1[0].length];
        for (int i = 0; i <matriz_r.length; i++) {
            for (int j = 0; j < matriz_r.length; j++) {
                matriz_r[i][j] = matriz1[j][i];

            }
        }
        return matriz_r;
    }
}
