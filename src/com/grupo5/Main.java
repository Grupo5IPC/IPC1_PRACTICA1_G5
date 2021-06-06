package com.grupo5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class VacasP1_01 {

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
        //System.out.println(s);

//--------------------------------------SELECCION DE OPCIONES (SWITCH)-------------------------------------------
        do {
            System.out.println("\n-------MENÚ PRINCIPAL------- \n1-> SUMA DE MATRICES \n2-> RESTA DE MATRICES"
                    + "\n3-> MULTIPLICACION DE MATRICES \n4-> DIVIDIR MATRICES \n5-> TRANSPUESTA DE LA MATRIZ"
                    + "\n6-> MATRIZ INVERSA \n7-> POTENCIA DE UNA MATRIZ \n8-> DETERMINANTE DE UNA MATRIZ \n0-> SALIR"
                    + "\n-----SELECCIONE UNA OPCIÓN:-----");

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
                            MultiplicaciondeMatrices();
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
                    DivisiondeMatrices();
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
                    PotenciaMatriz();
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
    public static double[][] leer_matriz(String archivo, char identificador) {

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
        double matriz[][] = new double[filas][columnas];
        for (int i = 0; i < tmp.length; i++) {
            String celdas[] = tmp[i].split(",");
            for (int j = 0; j < celdas.length; j++) {
                matriz[i][j] = Double.valueOf(celdas[j]);
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
    public static void suma_matriz() {
        //MATRIZ 1
        System.out.println("Ingrese la letra de la primera matriz(A-Z): ");
        char Letra = Escribir.next().charAt(0);
//        String leter = String.valueOf(Letra);
//        leter.toUpperCase();              //AQUI INTENTE PASAR LAS LETRAS MINUSCULAS A MAYUSCULAS PARA QUE NO AFECTARA EN EL PROCESO
        double[][] matriz1 = leer_matriz(s, Letra);

        //MATRIZ 2
        System.out.println("Ingrese la letra de la segunda matriz(A-Z): ");
        char Letra2 = Escribir.next().charAt(0);
        double[][] matriz2 = leer_matriz(s, Letra2);

        //SUMA
        double[][] matrizR = new double[matriz1.length][matriz1[0].length];
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


    }

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
    public static void resta_matriz() {
        //MATRIZ 1
        System.out.println("Ingrese la letra de la primera matriz(A-Z): ");
        char Letra = Escribir.next().charAt(0);
        double[][] matriz1 = leer_matriz(s, Letra);

        //MATRIZ 2
        System.out.println("Ingrese la letra de la segunda matriz(A-Z): ");
        char Letra2 = Escribir.next().charAt(0);
        double[][] matriz2 = leer_matriz(s, Letra2);

        //RESTA
        double[][] matrizR = new double[matriz1.length][matriz1[0].length];
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

    }

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
  public static int[][] MultiplicaciondeMatrices() {
        //MATRIZ 1
        System.out.println("Ingrese la letra de la primera matriz(A-Z): ");
        char Letra = Escribir.next().charAt(0);
        double[][] matriz1 = leer_matriz(s, Letra);

        //MATRIZ 2
        System.out.println("Ingrese la letra de la segunda matriz(A-Z): ");
        char Letra2 = Escribir.next().charAt(0);
        double[][] matriz2 = leer_matriz(s, Letra2);

        //MATRIZ RESULTADO
        int[][] matrizR = new int[matriz1.length][matriz2[0].length];

        //MULTIPLICACIÓN
        if (matriz1[0].length == matriz2.length) {
            for (int i = 0; i < matriz1.length; i++) {
                for (int j = 0; j < matriz2[0].length; j++) {
                    for (int k = 0; k < matriz1[0].length; k++) {
                        matrizR[i][j] += matriz1[i][k] * matriz2[k][j];
                    }
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
        } else {
            System.out.println("No se pueden operar las matrices seleccionadas porque no corresponden sus dimensiones");
        }
        return null;
    }

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
    public static void MultiplicacionMatrizNumero() {
        //MATRIZ 1
        System.out.println("Ingrese la letra de la matriz a operar(A-Z): ");
        char Letra = Escribir.next().charAt(0);
        double[][] matriz1 = leer_matriz(s, Letra);

        //MATRIZ 2
        System.out.println("Ingrese un número para operar con la matriz seleccionada: ");
        int Numero = Escribir.nextInt();

        //MULTIPLICACIÓN
        double[][] matrizR = new double[matriz1.length][matriz1[0].length];
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

    }

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
    public static void Transpuesta() {
        //MATRIZ 1
        System.out.println("Ingrese la letra de la matriz a operar(A-Z): ");
        char Letra = Escribir.next().charAt(0);
        double[][] matriz1 = leer_matriz(s, Letra);

        //TRANSPUESTA
        double matrizR[][] = new double[matriz1.length][matriz1[0].length];
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
    public static void InversadeMatrices() {
        //MATRIZ
        System.out.println("Ingrese la letra de la matriz a operar(A-Z): ");
        char Letra = Escribir.next().charAt(0);
        double[][] matriz1 = leer_matriz(s, Letra);

        if ((matriz1.length == 3 && matriz1[0].length == 3) || (matriz1.length == 2 && matriz1[0].length == 2)) {
            //--------------------------DETERMINANTE--------------------------
            //DIAGONALES POSITIVAS
            double[][] matrizT = new double[matriz1.length][matriz1[0].length];
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
                //MATRICES 3X3
                if (matrizT.length == 3 && matrizT[0].length == 3) {
                    double[][] matrizAdj = new double[matrizT.length][matrizT[0].length];
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

                //MATRICES 2X2
                if (matriz1.length == 2 && matriz1[0].length == 2) {
                    double[][] matrizAdj = new double[matriz1.length][matriz1[0].length];
                    for (int i = 0; i < matriz1.length; i++) {
                        for (int j = 0; j < matriz1[i].length; j++) {
                            if (i == 0 && j == 0) {
                                matrizAdj[i][j] = matriz1[1][1];
                            }
                            if (i == 0 && j == 1) {
                                matrizAdj[i][j] = (matriz1[0][1]) * (-1);
                            }
                            if (i == 1 && j == 0) {
                                matrizAdj[i][j] = (matriz1[1][0]) * (-1);
                            }
                            if (i == 1 && j == 1) {
                                matrizAdj[i][j] = matriz1[0][0];
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
            }
        } else {
            System.out.println("\nLa matriz seleccionada no es cuadrada o es mayor a 3x3");
        }

    }
//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
    public static void Determinante() {
        //MATRIZ
        System.out.println("Ingrese la letra de la matriz a operar(A-Z): ");
        char Letra = Escribir.next().charAt(0);
        double[][] matriz1 = leer_matriz(s, Letra);

        //--------------------------DETERMINANTE--------------------------
        //DIAGONALES POSITIVAS
        int Diagonal = 1;
        int Diagonal2 = 1;
        int Diagonal3 = 1;
        if (matriz1.length == matriz1[0].length) {
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
        } else {
            System.out.println("\nLa matriz seleccionada no es cuadrada o es mayor a 3x3");
        }

    }

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
    public static int[][] DivisiondeMatrices() {
        //MATRIZ 1
        System.out.println("Ingrese la letra de la primera matriz(A-Z): ");
        char Letra = Escribir.next().charAt(0);
        double[][] matriz1 = leer_matriz(s, Letra);

        //MATRIZ 2
        System.out.println("Ingrese la letra de la segunda matriz(A-Z): ");
        char Letra2 = Escribir.next().charAt(0);
        double[][] matriz2 = leer_matriz(s, Letra2);

        //------------------------INVERSA MATRIZ A-----------------------------
        if ((matriz1.length == 3 && matriz1[0].length == 3) || (matriz1.length == 2 && matriz1[0].length == 2)) {
            //--------------------------DETERMINANTE--------------------------
            //DIAGONALES POSITIVAS
            double[][] matrizT = new double[matriz1.length][matriz1[0].length];
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
                //MATRICES 3X3
                if (matrizT.length == 3 && matrizT[0].length == 3) {
                    double[][] matrizAdj = new double[matrizT.length][matrizT[0].length];
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

                //MATRICES 2X2
                if (matriz1.length == 2 && matriz1[0].length == 2) {
                    double[][] matrizAdj = new double[matriz1.length][matriz1[0].length];
                    for (int i = 0; i < matriz1.length; i++) {
                        for (int j = 0; j < matriz1[i].length; j++) {
                            if (i == 0 && j == 0) {
                                matrizAdj[i][j] = matriz1[1][1];
                            }
                            if (i == 0 && j == 1) {
                                matrizAdj[i][j] = (matriz1[0][1]) * (-1);
                            }
                            if (i == 1 && j == 0) {
                                matrizAdj[i][j] = (matriz1[1][0]) * (-1);
                            }
                            if (i == 1 && j == 1) {
                                matrizAdj[i][j] = matriz1[0][0];
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

                    //-------------------MULTIPLICACIÓN A^-1 * B = DIVISIÓN-------------------
                    //MATRIZ RESULTADO
                    double[][] matrizR = new double[matrizInv.length][matriz2[0].length];

                    //MULTIPLICACIÓN
                    if (matrizInv[0].length == matriz2.length) {
                        for (int i = 0; i < matrizInv.length; i++) {
                            for (int j = 0; j < matriz2[0].length; j++) {
                                for (int k = 0; k < matrizInv[0].length; k++) {
                                    matrizR[i][j] += matrizInv[i][k] * matriz2[k][j];
                                }
                            }
                        }
                    } else {
                        System.out.println("No se pueden operar las matrices seleccionadas porque no corresponden sus dimensiones");
                    }

                    System.out.println("\n La división entre la matriz " + Letra + " y la matriz " + Letra2 + " es: ");
                    System.out.println("");
                    for (int i = 0; i < matrizR.length; i++) {
                        for (int j = 0; j < matrizR[i].length; j++) {
                            System.out.print(matrizR[i][j] + "\t");
                        }
                        System.out.println("");
                    }
                    System.out.println("");
                }
            }
        }
        return null;
    }
//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
     public static void PotenciaMatriz() {

        System.out.println("Ingrese la letra de la primera matriz(A-Z): ");
        char Letra = Escribir.next().charAt(0);
        double[][] matriz1 = leer_matriz(s, Letra);
        double[][] aux_matriz = leer_matriz(s, Letra);
        System.out.println("Ingrese un número para elevar la matriz seleccionada: ");
        int Exponente = Escribir.nextInt();

        //--------------------------POTENCIA--------------------------//
        double[][] matrizR = new double[matriz1.length][matriz1[0].length];
        int contador = 0;
        double operacion = 0.0;
        if (matriz1[0].length == matriz1.length) {
            if (Exponente == 1) {
                for (int i = 0; i < matriz1.length; i++) {
                    for (int j = 0; j < matriz1[i].length; j++) {
                        matrizR[i][j] = matriz1[i][j] * 1;
                    }
                }
                System.out.println("");
                System.out.println("La matriz " + Letra + " elevada a " + Exponente + " es:");
                for (int i = 0; i < matrizR.length; i++) {
                    for (int j = 0; j < matrizR[i].length; j++) {
                        System.out.print(matrizR[i][j] + "\t");
                    }
                    {
                        System.out.println("");
                    }
                }
            }
            if (Exponente > 1) {

                for (int m = 1; m < Exponente; m++) {

                    for (int i = 0; i < matriz1.length; i++) {

                        for (int k = 0; k < matriz1[i].length; k++) {

                            operacion = 0;
                            contador = 0;

                            for (int j = 0; j < matriz1[i].length; j++) {
                                contador++;
                                operacion = matriz1[i][j] * aux_matriz[j][k] + operacion;

                                if (contador == matriz1[i].length) {
                                    matrizR[i][k] = operacion;
                                }
                            }
                        }
                    }
                    for (int i = 0; i < matriz1.length; i++) {
                        for (int j = 0; j < matriz1[i].length; j++) {
                            aux_matriz[i][j] = matrizR[i][j];
                        }
                    }
                }

                System.out.println("");
                System.out.println("La matriz " + Letra + " elevada a " + Exponente + " es:");
                for (int i = 0; i < matriz1.length; i++) {
                    for (int j = 0; j < matriz1[i].length; j++) {
                        System.out.print("  " + matrizR[i][j] + "\t");
                    }
                    System.out.println("");
                }

            }
        } else {
            System.out.println("No se puede operar la matriz seleccionada porque no corresponden sus dimensiones");
        }
    }           
}
