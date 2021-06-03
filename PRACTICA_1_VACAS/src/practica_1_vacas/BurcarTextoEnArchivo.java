package practica_1_vacas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class BurcarTextoEnArchivo {

    public static void main(String[] args) {

        Scanner entrada = null;
        String linea;
        int numeroDeLinea = 1;
        boolean contiene = false;
        Scanner sc = new Scanner(System.in);
        String letras = sc.nextLine();

        //Para seleccionar el archivo
        String text = getContentOfFile(letras);

        //Introducimos el texto a buscar
        System.out.print("Introduce texto a buscar: ");
        Scanner scanner = new Scanner(System.in);
        String texto = scanner.nextLine();
        
        entrada = new Scanner(getContentOfFile(letras));

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
            if(!contiene){ //si el archivo no contienen el texto se muestra un mensaje indicándolo

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
}