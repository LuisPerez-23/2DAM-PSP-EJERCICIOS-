package teoria.escritura;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;

public class Padre {
    private static Process crearProcesohijo() {
        String [] comandoJava={"java","-jar","out/artifacts/cuentaletras/cuentaletras.jar"};
        Process proceso=null;
        try {
            proceso= new ProcessBuilder(comandoJava).start();
        } catch (IOException e) {
            System.out.println("Error al crear proceso: \n"+ Arrays.toString(comandoJava));
        }
        return proceso;
    }

    private static void enviarDatosHijo(Process proceso, String respuesta) {
        PrintStream psHijo = new PrintStream(proceso.getOutputStream());
        psHijo.println(respuesta);
        psHijo.close();
    }

    private static String recogerDatosHijos(Process proceso) {
        BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
        String respuesta = "";
        try {
            respuesta = br.readLine();
        } catch (IOException e) {
            System.out.println("Error al leer desde el sub proceso");
        }

        return respuesta;

    }

    private static String solicitarInformacion() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String respuesta = "";
        try {
            respuesta= br.readLine();
        } catch (IOException e) {
            System.out.println("Error al leer desde el teclado");
        }
        return respuesta;
    }
    public static void main(String[] args)  {
        System.out.println("Dime una frase y te digo sus caracteres totales (Espacios incluidos)");
        String respuesta = solicitarInformacion();
        Process proceso = crearProcesohijo();
        enviarDatosHijo(proceso,respuesta);
        String respuestaHijo=recogerDatosHijos(proceso);
        int exit=0;
        try {
            exit=proceso.waitFor();
        } catch (InterruptedException e) {
            System.out.println("Error al terminar el subproceso");
        }
        System.out.println("El hijo ha terminado con condigo de salida"+exit);
        System.out.println("Respuesta: "+respuestaHijo);



    }


}
