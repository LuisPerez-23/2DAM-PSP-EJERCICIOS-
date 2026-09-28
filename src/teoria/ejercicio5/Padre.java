package teoria.ejercicio5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Padre {
    static String usuario="";
    static String password="";
    static String compResult1="En espera";
    static String compResult2="En espera";

    public static void main(String[] args) {
        String input="";
        while(!input.equals("5")){
            input= mostrarMenu();
            realizarAccion(input);
        }






    }


    private static String recogerDatoshijo(Process proceso) {
        BufferedReader datos = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
        String respuesta = "";
        try {
            respuesta=datos.readLine();
        } catch (IOException e) {
            System.out.println("Error al recoger los datos del hijo");
        }
        return respuesta;
    }

    private static void enviarDatosHijo(Process proceso, String respuesta) {
        PrintStream psHijo =new PrintStream(proceso.getOutputStream());
        psHijo.println(respuesta);
        psHijo.close();
    }

    private static Process creacionProceso(String [] comando) {
        ProcessBuilder pb = new ProcessBuilder(comando);
        Process proceso = null;
        try {
            proceso = pb.start();
        } catch (IOException e) {
            System.out.println("Error en proceso creacion");
        }
        return proceso;

    }

    private static void realizarAccion(String input) {
        switch (input) {
            case "1":
                try {
                    BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Ingrese su nombre: ");
                    usuario = br1.readLine();
                    System.out.println("Ingrese su contraseña: ");
                    password = br1.readLine();
                    compResult1="En espera";
                    compResult2="En espera";
                }catch (IOException e){
                    System.out.println("Error ingresando  usuario o contraseña");
                }
                break;
                case "2":
                    if(password.isEmpty()){
                        System.out.println("No hay contraseña almacenada");
                        break;
                    }
                    String [] comando={"java","-jar","out/artifacts/verificarmayuscula/verificarmayuscula.jar"};
                    Process hijo= creacionProceso(comando);
                    enviarDatosHijo(hijo,password);
                    compResult1= recogerDatoshijo(hijo);
                    break;
                    case "3":
                        if(password.isEmpty()){
                            System.out.println("No hay contraseña almacenada");
                            break;
                        }
                        String [] comando2 ={"java","-jar","out/artifacts/longitudcontrasena/longitudcontrasena.jar"};
                        Process hijo2 = creacionProceso(comando2);
                        enviarDatosHijo(hijo2,password);
                        compResult2= recogerDatoshijo(hijo2);
                        break;
                        case "4":
                            if(usuario.isEmpty()){
                                System.out.println("No hay usuario registrado");
                            }else {
                                System.out.println("Usuario: "+usuario+
                                        "\n Contraseña: "+password+
                                        "\n Comprobacion1:"+compResult1+
                                        "\n Comprobacion2:"+compResult2);
                            }
                            break;
                            case "5":
                                System.out.println("Hasta luego!");
                                break;
                                default:
                                    System.out.println("No se puede realizar esta accion");
        }
    }

    private static String mostrarMenu() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input="";
        System.out.println("Selecciona una opcion: \n"+
                "1-Identificarse.\n "+
                "2-Primera comprobación.\n "+
                "3-Segunda comprobación.\n "+
                "4-Resumen.\n "+
                "5-Salir.\n ");

        try {
             input = br.readLine();
        } catch (IOException e) {
            System.out.println("Error al leer por teclado");
        }
        return input;
    }
}
