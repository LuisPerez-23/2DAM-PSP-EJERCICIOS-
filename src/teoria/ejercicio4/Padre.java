package teoria.ejercicio4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Padre {
    public static void main(String[] args) {
        try {
            String[] comandoTex = {"java", "-jar", "out/artifacts/leertxt/leertxt.jar", "nota.txt"};
            String[] comandoInvertir= {"java", "-jar", "out/artifacts/invertirtxt/invertirtxt.jar"};

            Process procesoHijo1= new ProcessBuilder(comandoTex).redirectErrorStream(true).start();
            Process procesoHijo2= new ProcessBuilder(comandoInvertir).redirectErrorStream(true).start();

           BufferedReader leerHijo1 = new BufferedReader(new InputStreamReader(procesoHijo1.getInputStream()));
           BufferedReader leerHijo2 = new BufferedReader(new InputStreamReader(procesoHijo2.getInputStream()));
           PrintStream ps2 = new PrintStream(procesoHijo2.getOutputStream());


           String line;
           while ((line = leerHijo1.readLine()) != null) {
               ps2.println(line);

           }
            ps2.close();

            while ((line = leerHijo2.readLine()) != null) {
                System.out.println(line);

            }

            procesoHijo1.waitFor();
            procesoHijo2.waitFor();
        }catch (Exception e){
            System.out.println("Error al abrir el archivo"+e.getMessage());
            e.printStackTrace();
        }
    }
}
