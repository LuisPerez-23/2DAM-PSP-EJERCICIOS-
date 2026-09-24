package teoria.ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;

public class Padre {
    public static void main(String[] args)  {
        try {
            String[] comandoWind = {"cmd", "/C", "dir"}; //
            String[] ultimalinea = {"java", "-jar", "out/artifacts/linea/linea.jar"};// Cambia la ruta para que apunte exactamente a donde tienes el JAR que acabas de generar
            Process procesoDir= new ProcessBuilder(comandoWind).start();
            Process procesoLinea= new ProcessBuilder(ultimalinea).start();
            // Lector para capturar lo que dice el dir
            BufferedReader br1 = new BufferedReader(new InputStreamReader(procesoDir.getInputStream()));
            // Escritor para inyectarle datos al JAR
            BufferedReader br2 = new BufferedReader(new InputStreamReader(procesoLinea.getInputStream()));
            PrintStream ps = new PrintStream(procesoLinea.getOutputStream());

            //  EL PASAMANOS
            String linea;
            while((linea=br1.readLine()) != null){
                // Enviamos al hijo
                ps.println(linea);
            }
            ps.close();
            //mostramos lo del hijo
            System.out.println( br2.readLine());

            procesoDir.waitFor();
            procesoLinea.waitFor();
            System.out.println("Por fin comunicamos todo");

        }catch (IOException | InterruptedException e ){
            System.out.println("Error");
        }



    }
}


