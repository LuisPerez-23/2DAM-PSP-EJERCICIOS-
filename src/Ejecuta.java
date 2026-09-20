import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Ejecuta {

    private static void lanzarProcesos(String[] comando) {
        ProcessBuilder pb = new ProcessBuilder(comando);
        Process process = null;
        try {
            process = pb.start();
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());

        }

    }
    private static void realizarAccion(String respuesta) {
        switch (respuesta) {
            case "1": {
                String[] comando1 = {"notepad"};
                lanzarProcesos(comando1);
                break;
            }
            case "2": {

                String[] comando2 = {"calc"};
                lanzarProcesos(comando2);
                break;
            }
            case "3": {
                String[] comando3 = recogerDatosWeb();
                lanzarProcesos(comando3);

                break;
            }
            case "4": {
                String[] comando4 = {"paint"};
                lanzarProcesos(comando4);
                break;
            }
            case "5": {
                System.out.println("Hasta Luego!");
                break;
            }
            default:
                System.out.println("Ingresa una opcion valida.");


        }
    }


    private static String[] recogerDatosWeb() {
        System.out.println("Cuantas paginas quieres abrir?");
        boolean numCorrecto=true;
        int numPags=0;
        do {
            try {
                int numPag= Integer.parseInt(recogerOpcion());
            }catch (NumberFormatException e){
                numCorrecto=false;

            }
        }while (!numCorrecto);
        String[]comando=new String[numPags+1];
        comando[0]="C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe";
        System.out.println(comando[0]);


        for (int i = 1; i < numPags+1; i++) {
            System.out.println(comando.length+" "+ i);
            System.out.println("Dime la direccion de la pagina web:(www.youtube.com)");

            String pag = recogerOpcion();
            System.out.println(pag);
            System.out.println(comando[i]);
            comando [i] = pag;
            System.out.println(comando[i]);

        }
        return comando;
    }

    private static String recogerOpcion() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String respuesta = "";
        try {
            respuesta = br.readLine();
        } catch (IOException e) {
            System.out.println("Error al leer desde el teclado");
        }
        return respuesta;
    }
    private static void mostrarMenu() {
        System.out.println("Buenas" +
                " Que accion desea realizar? \n" +
                "Presione 1 para crear una nota nueva. \n" +
                "Presione 2 para abrir una nota existente.\n" +
                "Presione 3 para abrir el navegador.\n" +
                "Presione 4 para abrir el navegador y una pagina de preferencia. \n" +
                "Presione 5 para salir. \n");
    }

    public static void main(String[] args) {

        String opcion ="";
        do {
            mostrarMenu();
            opcion=recogerOpcion();
            realizarAccion(opcion);

        }while (!opcion.equalsIgnoreCase("5"));


        }

    }




