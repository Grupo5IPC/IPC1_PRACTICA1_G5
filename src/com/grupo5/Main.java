package practica_1_vacas;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("INGRESE EL NOMBRE DEL ARCHIVO QUE CONTIENE LAS MATRICES");
        Scanner sc = new Scanner(System.in);
        String texto = sc.nextLine();
        String prueba = getContentOfFile(texto);
        System.out.println(prueba);
//        System.out.println(prueba.length());
        prueba.trim();
        prueba.replaceAll("\\s", "");
        String s = prueba.replace(" ", "");
        System.out.println(s);

        System.out.println("SELECCIONE UNA DE LAS SIGUIENTES OPCIONES \n1-> SUMA DE MATRICES \n2-> RESTA DE MATRICES"
                + "\n3-> MULTIPLICACION DE MATRICES \n4-> DIVIDIR MATRICES \n5-> TRANSPUESTA DE LA MATRIZ"
                + "\n6-> MATRIZ INVERSA \n7-> POTENCIA DE UNA MATRIZ \n8-> DETERMINANTE DE UNA MATRIZ");

        Scanner opcion = new Scanner(System.in);
        String op = opcion.nextLine();

        switch (op) {
            case "1":
                System.out.println("------SUMA DE MATRICES------");
                System.out.println("INGRESE LA LETRA DE LA MATRIZ QUE DESEA LLAMAR");
//            Scanner llamarMatriz = new Scanner(System.in);
//        String llamada = opcion.nextLine();
                int[][] matriz = leer_matriz(s, 'C');
                break;
                
            case "2":
                System.out.println("Resta");
                break;

            case "3":
                System.out.println("Multiplicacion");
                break;

            case "4":
                System.out.println("Dividir");
                break;

            case "5":
                System.out.println("Transpuesta");
                break;

            case "6":
                System.out.println("Inversa");
                break;

            case "7":
                System.out.println("Transpuesta");
                break;

            case "8":
                System.out.println("Determinante");
                break;

            default:
                System.out.println("SELECCIONE UNA DE LAS OPCIONES");
                break;
        }

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

    public static int[][] leer_matriz(String archivo, char identificador) {
        char a[] = archivo.toCharArray();

        boolean encontrado = false;
        int indice = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == identificador) {

                indice = i;
                encontrado = true;
            }
        }
        int columnas = 0;
        int filas = 0;
        for (int i = indice; i < a.length; i++) {
            if (a[i] == '\n') {
                filas++;
                break;
            }

            if (a[i] == ':') {

                for (int j = i + 1; j < a.length; j++) {
                    if (a[j] == ';') {
                        break;
                    }
                    if (a[j] != ',') {
                        columnas++;
                    }

                }

            }
            if (a[i] == ';') {
                filas++;
            }
        }
        int[][] matriz = new int[filas][columnas];
        int auxiliar = indice + 1;

        System.out.println("Matriz = " + identificador);
        System.out.println("Columnas= " + columnas);
        System.out.println("Filas = " + filas);
        for (int i = 0; i < matriz.length; i++) {
//            System.out.println("fila");
            auxiliar++;

            for (int j = 0; j < matriz[0].length; j++) {
                if (a[auxiliar] == ';') {
                    System.out.println("break");
                    break;
                }
                if (Character.isDigit(a[auxiliar])) {
                    matriz[i][j] = Character.getNumericValue(a[auxiliar]);
                } else {
                    j--;
                }
                auxiliar++;
            }

        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + ",");
            }
            System.out.println();
        }

        return matriz;

    }
}
