import java.io.IOException;
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = 0;

        while (input != 5) {
            System.out.println("Buenas" +
                    " Que accion desea realizar? " +
                    "Presione 1 para crear una nota nueva. " +
                    "Presione 2 para abrir una nota existente." +
                    "Presione 3 para abrir el navegador." +
                    "Presione 4 para abrir el navegador y una pagina de preferencia. " +
                    "Presione 5 para salir. ");

            try {
                input = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero valido");
                continue;// Salta a la siguiente iteración del while
            }
            switch (input) {
                case 1: {
                    String[] comando = {"notepad"};
                    lanzarProcesos(comando);
                    break;
                }
                case 2: {
                    System.out.println("Ingresa el nombre del nota:");
                    String nombreNota = sc.nextLine();
                    String[] comando = {"notepad", ""};
                    comando[1] = nombreNota;
                    lanzarProcesos(comando);
                    break;
                }
                case 3: {
                    String[] comando = {"C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe"};
                    lanzarProcesos(comando);

                    break;
                }
                case 4: {
                    System.out.println("Ingresa la URL de la pagina (www.youtube.com):)");
                    String nombrePagina = sc.nextLine();
                    String[] comando = {"C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe", ""};
                    comando[1] = nombrePagina;
                    lanzarProcesos(comando);
                    break;
                }
                case 5: {
                    System.out.println("Hasta Luego!");
                    break;
                }
                default:
                    System.out.println("Ingresa una opcion valida.");


            }


        }

    }
}
