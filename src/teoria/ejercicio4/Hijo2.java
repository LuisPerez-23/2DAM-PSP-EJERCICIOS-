package teoria.ejercicio4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Hijo2 {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String comando;


            while ((comando = br.readLine()) != null) {
                lista.add(comando);
            }


        } catch (Exception e) {
            System.out.println("Error al agregar a la lista");
        }

        for (String n : lista.reversed()) {
            System.out.println(n);
        }
    }
}
