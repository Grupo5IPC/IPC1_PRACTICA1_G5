package com.grupo5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static Scanner Escribir = new Scanner(System.in);
    public static String s = "";
    public static Reportes rep = new Reportes();
    public static String op = "";

    public static void main(String[] args) {

        Animacion();
        System.out.println("INGRESE EL NOMBRE DEL ARCHIVO QUE CONTIENE LAS MATRICES");
        Scanner sc = new Scanner(System.in);
        String texto = sc.nextLine();
        String prueba = getContentOfFile(texto);
        prueba.trim(); //QUITAMOS LOS ESPACIOS
        s = prueba.replace(" ", "");
        System.out.println(s);

//--------------------------------------SELECCION DE OPCIONES (SWITCH)-------------------------------------------
        do {
            System.out.println("SELECCIONE UNA DE LAS SIGUIENTES OPCIONES \n1-> SUMA DE MATRICES \n2-> RESTA DE MATRICES"
                    + "\n3-> MULTIPLICACION DE MATRICES \n4-> DIVIDIR MATRICES \n5-> TRANSPUESTA DE LA MATRIZ"
                    + "\n6-> MATRIZ INVERSA \n7-> POTENCIA DE UNA MATRIZ \n8-> DETERMINANTE DE UNA MATRIZ \n0-> SALIR");

            Scanner opcion = new Scanner(System.in);
            op = opcion.nextLine();

            switch (op) {
//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------

                case "1":
                    System.out.println("------SUMA DE MATRICES------");
                    suma_matriz();
                    break;

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
                case "2":
                    System.out.println("------RESTA DE MATRICES------");
                    resta_matriz();
                    break;

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
                case "3":
                    System.out.println("------MULTIPLICACION DE MATRICES------");
                    System.out.println("SELECCIONE UNA DE LAS SIGUIENTES OPCIONES \n1-> MULTIPLICAION DE MATRICES \n2-> MULTIPLICACION DE MATRIZ CON UN NUMERO");
                    Scanner scanner = new Scanner(System.in);
                    String option = scanner.nextLine();
                    switch (option) {
                        case "1":
                            //MultiplicaciondeMatrices();
                            break;
                        case "2":
                            MultiplicacionMatrizNumero();
                            break;
                    }
                    break;

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
                case "4":
                    System.out.println("------DIVISION DE MATRICES------");
                    break;

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
                case "5":
                    System.out.println("------TRANSPUESTA DE LA MATRIZ------");
                    Transpuesta();
                    break;

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
                case "6":
                    System.out.println("------INVERSA DE LA MATRIZ------");
                    InversadeMatrices();
                    break;

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
                case "7":
                    System.out.println("------POTENCIA DE LA MATRIZ------");
                    break;

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
                case "8":
                    System.out.println("------DETERMINANTE DE LA MATRIZ------");
                    Determinante();
                    break;

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
                case "0":
                    System.out.println("------FIN DEL PROGRAMA------");
                    break;

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
                default:
                    System.out.println("SELECCIONE UNA DE LAS OPCIONES");
                    break;
            }
        } while (op == "0");

    }

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
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
            } catch (NullPointerException e) {
                System.out.println(e.toString() + "No ha seleccionado ningún archivo");
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        return "";
    }

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
    public static int[][] leer_matriz(String archivo, char identificador) {

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
        for (int i = 0; i < tmp.length; i++) {
            String celdas[] = tmp[i].split(",");
            for (int j = 0; j < celdas.length; j++) {
                matriz[i][j] = Integer.parseInt(celdas[j]);
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

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
    public static int[][] suma_matriz() {
        //MATRIZ 1
        System.out.println("Ingrese la letra de la primera matriz(A-Z): ");
        char Letra = Escribir.next().charAt(0);
        int[][] matriz1 = leer_matriz(s, Letra);

        //MATRIZ 2
        System.out.println("Ingrese la letra de la segunda matriz(A-Z): ");
        char Letra2 = Escribir.next().charAt(0);
        int[][] matriz2 = leer_matriz(s, Letra2);

        //SUMA
        int[][] matrizR = new int[matriz1.length][matriz1[0].length];
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[i].length; j++) {
                matrizR[i][j] = matriz1[i][j] + matriz2[i][j];
            }

        }

        //IMPRIMIR MATRIZ SUMA
        System.out.println("");
        System.out.println("La suma de las matrices " + Letra + " y " + Letra2 + " es:");
        System.out.println("");
        for (int i = 0; i < matrizR.length; i++) {
            for (int j = 0; j < matrizR[i].length; j++) {
                System.out.print(matrizR[i][j] + "\t");

            }
            System.out.println("");
        }

        System.out.println();
        rep.add_suma(matriz1, matriz2, matrizR, Letra, Letra2);

        return matrizR;

    }

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
    public static int[][] resta_matriz() {
        //MATRIZ 1
        System.out.println("Ingrese la letra de la primera matriz(A-Z): ");
        char Letra = Escribir.next().charAt(0);
        int[][] matriz1 = leer_matriz(s, Letra);

        //MATRIZ 2
        System.out.println("Ingrese la letra de la segunda matriz(A-Z): ");
        char Letra2 = Escribir.next().charAt(0);
        int[][] matriz2 = leer_matriz(s, Letra2);

        //RESTA
        int[][] matrizR = new int[matriz1.length][matriz1[0].length];
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[i].length; j++) {
                matrizR[i][j] = matriz1[i][j] - matriz2[i][j];

            }

        }

        //IMPRIMIR MATRIZ SUMA
        System.out.println("");
        System.out.println("La resta de las matrices " + Letra + " y " + Letra2 + " es:");
        System.out.println("");
        for (int i = 0; i < matrizR.length; i++) {
            for (int j = 0; j < matrizR[i].length; j++) {
                System.out.print(matrizR[i][j] + "\t");

            }
            System.out.println("");
        }
        rep.add_resta(matriz1, matriz2, matrizR, Letra, Letra2);

        return matrizR;
    }

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
    public static int[][] MultiplicaciondeMatrices() {
        //MATRIZ 1
        System.out.println("Ingrese la letra de la primera matriz(A-Z): ");
        char Letra = Escribir.next().charAt(0);
        int[][] matriz1 = leer_matriz(s, Letra);

        //MATRIZ 2
        System.out.println("Ingrese la letra de la segunda matriz(A-Z): ");
        char Letra2 = Escribir.next().charAt(0);
        int[][] matriz2 = leer_matriz(s, Letra2);

        //MULTIPLICACIÓN
        int[][] matrizR = new int[3][3];
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[i].length; j++) {
                matrizR[i][j] += matriz1[i][j] * matriz2[j][i];
            }

        }

        //IMPRIMIR MATRIZ MULTIPLICACIÓN
        System.out.println("");
        System.out.println("La multiplicacion de las matrices " + Letra + " y " + Letra2 + " es:");
        System.out.println("");
        for (int i = 0; i < matrizR.length; i++) {
            for (int j = 0; j < matrizR[i].length; j++) {
                System.out.print(matrizR[i][j] + "\t");
            }
            System.out.println("");
        }
        rep.add_multi_matriz(matriz1, matriz2, matrizR, Letra, Letra2);
        return matrizR;
    }

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
    public static int[][] MultiplicacionMatrizNumero() {
        //MATRIZ 1
        System.out.println("Ingrese la letra de la matriz a operar(A-Z): ");
        char Letra = Escribir.next().charAt(0);
        int[][] matriz1 = leer_matriz(s, Letra);

        //MATRIZ 2
        System.out.println("Ingrese un número para operar con la matriz seleccionada: ");
        int Numero = Escribir.nextInt();

        //MULTIPLICACIÓN
        int[][] matrizR = new int[matriz1.length][matriz1[0].length];
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[i].length; j++) {
                matrizR[i][j] = matriz1[i][j] * Numero;
            }

        }

        //IMPRIMIR MATRIZ MULTIPLICADA CON EL NUMERO
        System.out.println("");
        System.out.println("La multiplicacion de la matriz " + Letra + " con el número " + Numero + " es:");
        System.out.println("");
        for (int i = 0; i < matrizR.length; i++) {
            for (int j = 0; j < matrizR[i].length; j++) {
                System.out.print(matrizR[i][j] + "\t");
            }
            System.out.println("");
        }
        rep.add_multi_numero(matriz1, matrizR, Letra, Numero);
        return matrizR;
    }

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
    public static int[][] Transpuesta() {
        //MATRIZ 1
        System.out.println("Ingrese la letra de la matriz a operar(A-Z): ");
        char Letra = Escribir.next().charAt(0);
        int[][] matriz1 = leer_matriz(s, Letra);

        //TRANSPUESTA
        int matrizR[][] = new int[matriz1.length][matriz1[0].length];
        for (int i = 0; i < matrizR.length; i++) {
            for (int j = 0; j < matrizR.length; j++) {
                matrizR[i][j] = matriz1[j][i];

            }
        }

        //IMPRIMIR MATRIZ MULTIPLICADA CON EL NUMERO
        System.out.println("");
        System.out.println("La transpuesta de la matriz " + Letra + " es:");
        System.out.println("");
        for (int i = 0; i < matrizR.length; i++) {
            for (int j = 0; j < matrizR[i].length; j++) {
                System.out.print(matrizR[i][j] + "\t");
            }
            System.out.println("");
        }
        rep.add_transpuesta(matriz1, matrizR, Letra);
        return matrizR;
    }

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
    public static void Animacion() {

        try {
            System.out.println("  __  __              _______             _____              _         _____ ");
            Thread.sleep(200);
            System.out.println(" |  \\/  |     /\\     |__   __|           / ____|     /\\     | |       / ____|");
            Thread.sleep(200);
            System.out.println(" | \\  / |    /  \\       | |     ______  | |         /  \\    | |      | |     ");
            Thread.sleep(200);
            System.out.println(" | |\\/| |   / /\\ \\      | |    |______| | |        / /\\ \\   | |      | |     ");
            Thread.sleep(200);
            System.out.println(" | |  | |  / ____ \\     | |             | |____   / ____ \\  | |____  | |____ ");
            Thread.sleep(200);
            System.out.println(" |_|  |_| /_/    \\_\\    |_|              \\_____| /_/    \\_\\ |______|  \\_____|");
            Thread.sleep(200);
            System.out.println();
            System.out.print("\007");
            System.out.flush();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
    public static int[][] InversadeMatrices() {
        //MATRIZ
        System.out.println("Ingrese la letra de la matriz a operar(A-Z): ");
        char Letra = Escribir.next().charAt(0);
        int[][] matriz1 = leer_matriz(s, Letra);

        //--------------------------DETERMINANTE--------------------------
        //DIAGONALES POSITIVAS
        int[][] matrizT = new int[matriz1.length][matriz1[0].length];
        int Diagonal = 1;
        int Diagonal2 = 1;
        int Diagonal3 = 1;
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[i].length; j++) {
                if (i == j) {
                    Diagonal *= matriz1[i][j];
                }
                if ((i == 1 && j == 0) || (i == 2 && j == 1) || (i == 0 && j == 2)) {
                    Diagonal2 *= matriz1[i][j];
                }
                if ((i == 0 && j == 1) || (i == 1 && j == 2) || (i == 2 && j == 0)) {
                    Diagonal3 *= matriz1[i][j];
                }
            }
        }

        //DIAGONALES CONTRARIAS
        int Diagonal4 = 1;
        int Diagonal5 = 1;
        int Diagonal6 = 1;
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[i].length; j++) {
                if ((i == 0 && j == 2) || (i == 1 && j == 1) || (i == 2 && j == 0)) {
                    Diagonal4 *= matriz1[i][j];
                }
                if ((i == 1 && j == 2) || (i == 2 && j == 1) || (i == 0 && j == 0)) {
                    Diagonal5 *= matriz1[i][j];
                }
                if ((i == 0 && j == 1) || (i == 1 && j == 0) || (i == 2 && j == 2)) {
                    Diagonal6 *= matriz1[i][j];
                }
            }
        }

        double Det = ((Diagonal + Diagonal2 + Diagonal3) - (Diagonal4 + Diagonal5 + Diagonal6));
        if (Det == 0) {
            System.out.println("La matriz ingresada no tiene inversa porque su determinante es cero");
        } else {

            //--------------------------TRANSPUESTA--------------------------
            for (int i = 0; i < matriz1.length; i++) {
                for (int j = 0; j < matriz1[i].length; j++) {
                    matrizT[i][j] = matriz1[j][i];
                }
            }

            //-------------------ADJUNTA DE LA TRANSPUESTA-------------------
            int[][] matrizAdj = new int[matrizT.length][matrizT[0].length];
            for (int i = 0; i < matrizT.length; i++) {
                for (int j = 0; j < matrizT[i].length; j++) {
                    if (i == 0 && j == 0) {
                        matrizAdj[i][j] = ((matrizT[1][1] * matrizT[2][2]) - (matrizT[1][2] * matrizT[2][1]));
                    }
                    if (i == 0 && j == 1) {
                        matrizAdj[i][j] = ((matrizT[1][0] * matrizT[2][2]) - (matrizT[1][2] * matrizT[2][0])) * (-1);
                    }
                    if (i == 0 && j == 2) {
                        matrizAdj[i][j] = ((matrizT[1][0] * matrizT[2][1]) - (matrizT[1][1] * matrizT[2][0]));
                    }
                    if (i == 1 && j == 0) {
                        matrizAdj[i][j] = ((matrizT[0][1] * matrizT[2][2]) - (matrizT[0][2] * matrizT[2][1])) * (-1);
                    }
                    if (i == 1 && j == 1) {
                        matrizAdj[i][j] = ((matrizT[0][0] * matrizT[2][2]) - (matrizT[0][2] * matrizT[2][0]));
                    }
                    if (i == 1 && j == 2) {
                        matrizAdj[i][j] = ((matrizT[0][0] * matrizT[2][1]) - (matrizT[0][1] * matrizT[2][0])) * (-1);
                    }
                    if (i == 2 && j == 0) {
                        matrizAdj[i][j] = ((matrizT[0][1] * matrizT[1][2]) - (matrizT[0][2] * matrizT[1][1]));
                    }
                    if (i == 2 && j == 1) {
                        matrizAdj[i][j] = ((matrizT[0][0] * matrizT[1][2]) - (matrizT[0][2] * matrizT[1][0])) * (-1);
                    }
                    if (i == 2 && j == 2) {
                        matrizAdj[i][j] = ((matrizT[0][0] * matrizT[1][1]) - (matrizT[0][1] * matrizT[1][0]));
                    }
                }
            }
            //-------------------ADJUNTA DIVIDIDA POR DETERMINANTE = INVERSA-------------------
            double[][] matrizInv = new double[matrizAdj.length][matrizAdj[0].length];
            for (int i = 0; i < matrizAdj.length; i++) {
                for (int j = 0; j < matrizAdj[i].length; j++) {
                    matrizInv[i][j] = (double) (matrizAdj[i][j] / Det);
                }
            }
            System.out.println("\n La Matriz Inversa de " + Letra + " es: ");
            System.out.println("");
            for (int i = 0; i < matrizInv.length; i++) {
                for (int j = 0; j < matrizInv[i].length; j++) {
                    System.out.print(matrizInv[i][j] + "\t");
                }
                System.out.println("");
            }
            System.out.println("");
        }
        return matrizT;
    }

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
    public static int[][] Determinante() {
        //MATRIZ
        System.out.println("Ingrese la letra de la matriz a operar(A-Z): ");
        char Letra = Escribir.next().charAt(0);
        int[][] matriz1 = leer_matriz(s, Letra);

        //--------------------------DETERMINANTE--------------------------
        //DIAGONALES POSITIVAS
        int Diagonal = 1;
        int Diagonal2 = 1;
        int Diagonal3 = 1;
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[i].length; j++) {
                if (i == j) {
                    Diagonal *= matriz1[i][j];
                }
                if ((i == 1 && j == 0) || (i == 2 && j == 1) || (i == 0 && j == 2)) {
                    Diagonal2 *= matriz1[i][j];
                }
                if ((i == 0 && j == 1) || (i == 1 && j == 2) || (i == 2 && j == 0)) {
                    Diagonal3 *= matriz1[i][j];
                }
            }
        }

        //DIAGONALES CONTRARIAS
        int Diagonal4 = 1;
        int Diagonal5 = 1;
        int Diagonal6 = 1;
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[i].length; j++) {
                if ((i == 0 && j == 2) || (i == 1 && j == 1) || (i == 2 && j == 0)) {
                    Diagonal4 *= matriz1[i][j];
                }
                if ((i == 1 && j == 2) || (i == 2 && j == 1) || (i == 0 && j == 0)) {
                    Diagonal5 *= matriz1[i][j];
                }
                if ((i == 0 && j == 1) || (i == 1 && j == 0) || (i == 2 && j == 2)) {
                    Diagonal6 *= matriz1[i][j];
                }
            }
        }

        double Det = ((Diagonal + Diagonal2 + Diagonal3) - (Diagonal4 + Diagonal5 + Diagonal6));
        System.out.println("\n El Determinante de la matriz " + Letra + " es = " + Det);
        System.out.println("");
        return null;
    }
}
