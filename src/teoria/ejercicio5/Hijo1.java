package teoria.ejercicio5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hijo1 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String linea;
            linea = br.readLine();
            if(linea==null){
                System.out.println("Error linea vacia");
                return;
            }
            boolean letrasMayusculas = false;
            for (char c : linea.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    letrasMayusculas = true;
                    break;
                }
            }
            if (letrasMayusculas) {
                System.out.println("Ok");
            }else {
                System.out.println("Error");
            }
        }catch (IOException e){
            System.out.println("Error al ejecutar primera comprobacion");

        }


    }
}
