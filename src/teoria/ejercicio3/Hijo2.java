package teoria.ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Hijo2 {
    public static void main(String[] args) {
       try
               (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
           String linea = "";
           String ultimalinea = "";

           while ((linea = br.readLine()) != null) {
               ultimalinea = linea;
           }
           System.out.println(ultimalinea);
       }catch (IOException e){
           System.out.println("Error");
       }



    }
}
