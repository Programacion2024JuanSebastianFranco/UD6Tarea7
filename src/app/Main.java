package app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Main main = new Main();
        int opc = main.menu();

        do {

            switch (opc){

                case 1 -> {

                }

                case 2 -> {

                }

                case 3 -> {

                }

                case 4 -> {

                }

                default -> System.out.println("Valor no valido");

            }
        } while (opc != 5);



    }


    public int menu(){
        Scanner scan = new Scanner(System.in);

        int opc;

        do {
            System.out.println("""
                    1. Nuevo Alumno
                    2. Nuevo Profesor
                    3. Mostrar Alumnos
                    4. Mostrar Profesores
                    5. Salir
                    """);
            opc = scan.nextInt();


        } while (opc < 1 || opc > 4);
        return opc;
    }

}
