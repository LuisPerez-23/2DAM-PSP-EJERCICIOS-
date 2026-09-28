package teoria.ejercicio5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hijo2 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String linea=br.readLine();

            if(linea==null){
                System.out.println("Error, linea vacia");
                return;
            }
            if (linea.length() < 8) {
                System.out.println("Error");
            }else {
            System.out.println("OK");}
        }catch(IOException e){
            System.out.println("Error ejecutando hijo2");
        }


    }
}
