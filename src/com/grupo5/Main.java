package com.grupo5;
import java.io.*;
public class Main {

    public static void main(String[] args) {
	// write your code here
        String prueba = getContentOfFile("C:\\Users\\ludwi\\OneDrive\\Escritorio\\prueba.txt");
        System.out.println(prueba);
        System.out.println(prueba.length());
        prueba.trim();
        prueba.replaceAll("\\s", "");
        String s = prueba.replace(" ", "");
        System.out.println(s);
        int [][] matriz = leer_matriz(s,'C');;


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
        char a[] = archivo.toCharArray();

        boolean encontrado = false;
        int indice =0;
        for (int i = 0;i<a.length; i++){
            if(a[i] == identificador){

                indice = i;
                encontrado = true;
            }
        }
        int columnas = 0;
        int filas =0;
        for (int i = indice; i<a.length; i++){
            if (a[i] == '\n'){
                filas++;
                break;
            }

            if(a[i] == ':'){

                for (int j=i+1; j<a.length; j++){
                    if (a[j] == ';'){
                        break;
                    }
                    if(a[j] != ',' ) {
                        columnas++;
                    }

                }

            }
            if (a[i] == ';'){
                filas ++;
            }
        }
        int [][] matriz = new int[filas][columnas];
        int auxiliar =indice+1;

        System.out.println("Matriz = " +  identificador);
        System.out.println("Columnas= "+columnas);
        System.out.println("Filas = "+ filas);
        for (int i = 0; i<matriz.length;i++){
            System.out.println("fila");
            auxiliar++;

            for (int j = 0; j<matriz[0].length; j++){
                if (a[auxiliar] == ';'){
                    System.out.println("break");
                    break;
                }
                if (Character.isDigit(a[auxiliar])){
                    matriz[i][j] = Character.getNumericValue(a[auxiliar]);
                }else{
                    j--;
                }
                auxiliar++;
            }

        }
        for (int i = 0; i<matriz.length;i++){
            for (int j = 0; j<matriz[0].length; j++){
                System.out.print(matriz[i][j]+ ",");
            }
            System.out.println();
        }

    return matriz;

    }
}
