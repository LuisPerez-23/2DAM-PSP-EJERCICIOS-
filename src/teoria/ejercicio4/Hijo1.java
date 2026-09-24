package teoria.ejercicio4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Hijo1 {
    public static void main(String[] args) {

        try (BufferedReader br= new BufferedReader(new FileReader(args[0]))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.equalsIgnoreCase("FIN")) {
                    break;
                }
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al abrir el archivo");
            e.printStackTrace();

        }



    }
}

