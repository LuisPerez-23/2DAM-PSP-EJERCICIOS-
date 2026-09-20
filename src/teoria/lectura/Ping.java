package teoria.lectura;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ping {
    public static void main(String[] args) {
        String[] comandoWin = {"cmd", "/C", "ping", "-n", "3", "google.com"};
        String[] comandoIos = {"ping","-C","3","google.com"};
        Process proceso=null;
        try {
            proceso = new ProcessBuilder(comandoWin).start();

        }catch (Exception e){
            System.out.println("Error al iniciar proceso:\n "+ Arrays.toString(comandoWin));
        }
        if(proceso != null){
            BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String linea = "";
            try {
                while ((linea = br.readLine()) != null){
                    System.out.println(linea);
            }
            }catch (IOException e){
                System.out.println("error al leer desde subproceso");
            }
            int exitCode =0;
            try {
                exitCode = proceso.waitFor();
            }catch (InterruptedException e){
                System.out.println("error al finalizar proceso");
            }
        }
    }
}
