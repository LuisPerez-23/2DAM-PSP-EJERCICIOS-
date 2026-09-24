package teoria.ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.ScatteringByteChannel;

public class cambioMayuscula {
    public static void main(String[] args) {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String palabra="";
        try {
            palabra = br.readLine();
        } catch (IOException e) {
            System.out.println("No se pueden leer los datos");
        }
        System.out.println(palabra.toUpperCase());

    }
}
