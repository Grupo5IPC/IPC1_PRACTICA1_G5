package com.grupo5;
import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String prueba = getContentOfFile("C:\\Users\\ludwi\\OneDrive\\Escritorio\\prueba.txt");

        prueba.trim();
        prueba.replaceAll("\\s", "");
        String s = prueba.replace(" ", "");
        int [][] matriz = leer_matriz(s,'R');;

    }
    public static String getContentOfFile(String pathname) {
        File archive = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archive = new File(pathname);
            fr = new FileReader(archive);
            br = new BufferedReader(fr);
            // Lectura del fichero
            String content = "";
            String linea;
            while ((linea = br.readLine()) != null) {
                content += linea + "\n";
            }
            return content;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }
    public static int[][] leer_matriz(String archivo, char identificador){
        String[] matrices = archivo.split("\n");
        for (int i = 0; i < matrices.length; i++) {
            System.out.println(matrices[i]);
        }

        boolean encontrado = false;
        int indice = 0;
        for (int i = 0; i < matrices.length; i++) {
            char a[] = matrices[i].toCharArray();
            if (encontrado == true) {
                break;
            }
            for (int j = 0; j < a.length; j++) {
                if (a[j] == identificador) {
                    encontrado = true;
                    indice = i;
                    break;
                }
            }
        }
        System.out.println();



        String tmp[] = matrices[indice].split(";");
        tmp[0] = tmp[0].replace(identificador + ":", "");
        int filas = tmp.length;
        System.out.println(filas);

        int columnas = tmp[0].split(",").length;
        System.out.println(columnas);
        int matriz[][] = new int[filas][columnas];
        for (int i = 0;i< tmp.length; i++){
            String celdas []= tmp[i].split(",");
            for (int j =0; j<celdas.length; j++){
                matriz[i][j] = Integer.parseInt(celdas[j]) ;
            }

        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j =0; j<matriz[0].length; j++){
                System.out.print(matriz[i][j]+ ",");
            }
            System.out.println();
        }
    return matriz;

    }
}
