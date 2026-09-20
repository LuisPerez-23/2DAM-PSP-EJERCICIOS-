package teoria.escritura;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hijo {
    public static void main(String[] args) {
        //vamos a contar letras de una frase

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String frase ="";
        try {
            frase= br.readLine();
        }catch (IOException e){
            System.out.println("No se puede leer los datos");
        }
        System.out.println(frase.length());



    }
}
