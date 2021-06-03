package practica_1_vacas;

import java.io.*;
import java.util.Scanner;

public class PRACTICA_1_VACAS {

    public static void main(String[] args) {
        
        System.out.println("INGRESE EL NOMBRE DEL ARCHIVO QUE CONTIENE LAS MATRICES");
        Scanner sc = new Scanner(System.in);
        String texto = sc.nextLine();
        String text = getContentOfFile(texto); //LEEMOS EL DOCUMENTO Y LO METEMOS EN UNA VARIABLE
        String res = text.replace(" ", ""); //QUITAMOS LOS ESPACIOS DEL ARCHIVO
        System.out.println(res);
        
        System.out.println("SELECCIONE UNA DE LAS SIGUIENTES OPCIONES \n1-> SUMA DE MATRICES \n2-> RESTA DE MATRICES"
                + "\n3-> MULTIPLICACION DE MATRICES \n4-> DIVIDIR MATRICES \n5-> TRANSPUESTA DE LA MATRIZ"
                + "\n6-> MATRIZ INVERSA \n7-> POTENCIA DE UNA MATRIZ \n8-> DETERMINANTE DE UNA MATRIZ");
        Scanner opcion = new Scanner(System.in);
        String option = opcion.nextLine();
        switch (option) {
            
//-----------------------------------------------------------------------------------------------------
            case "1":
                
        int numeroDeLinea = 1;
        boolean contiene = false;
        
        System.out.print("Introduce texto a buscar: ");
        Scanner scanner = new Scanner(System.in);
        String texto1 = scanner.nextLine();

        try {

            while (text != texto1) { //mientras no se llegue al final del fichero
                    if (texto1.contains(texto)) {   //si la línea contiene el texto buscado se muestra por pantalla         
                    System.out.println("Linea " + numeroDeLinea + ": " + texto);
                    contiene = true;
                }
                numeroDeLinea++; //se incrementa el contador de líneas
            }
            if (!contiene) { //si el archivo no contienen el texto se muestra un mensaje indicándolo

                System.out.println(texto1 + " no se ha encontrado en el archivo");
            }
        } catch (NullPointerException e) {
            System.out.println(e.toString() + "No ha seleccionado ningún archivo");
        } catch (Exception e) {
            System.out.println(e.toString());
//        } finally {
//            if (sc != null) {
//                sc.close();
//            }
        }
                break;

//-----------------------------------------------------------------------------------------------------  
              
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

    //LEEMOS EL ARCHIVO
    public static String getContentOfFile(String pathname) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(pathname);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            // Lectura del fichero
            String content = "";
            String linea;
            while ((linea = br.readLine()) != null) {
                content += linea + "\n";
            }
            return content;
//        System.out.println(content);
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

    private static void llamarMatriz() {
        Scanner entrada = null;
        String linea;
        int numeroDeLinea = 1;
        boolean contiene = false;
//        Scanner sc = new Scanner(System.in);
//        String letras = sc.nextLine();

        //Para seleccionar el archivo
//        String text = getContentOfFile(letras);
        //Introducimos el texto a buscar
        System.out.print("Introduce texto a buscar: ");
        Scanner scanner = new Scanner(System.in);
        String texto = scanner.nextLine();

//        entrada = new Scanner(getContentOfFile(letras));

        try {

            //mostramos el texto a buscar
            System.out.println("Texto a buscar: " + texto);
            while (entrada.hasNext()) { //mientras no se llegue al final del fichero
                linea = entrada.nextLine();  //se lee una línea
                if (linea.contains(texto)) {   //si la línea contiene el texto buscado se muestra por pantalla         
                    System.out.println("Linea " + numeroDeLinea + ": " + linea);
                    contiene = true;
                }
                numeroDeLinea++; //se incrementa el contador de líneas
            }
            if (!contiene) { //si el archivo no contienen el texto se muestra un mensaje indicándolo

                System.out.println(texto + " no se ha encontrado en el archivo");
            }
        } catch (NullPointerException e) {
            System.out.println(e.toString() + "No ha seleccionado ningún archivo");
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (entrada != null) {
                entrada.close();
            }
        }
    }
}
