package app;
import model.instituto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        instituto instituto = new instituto();

        instituto.cargarDatosPrueba();

        Main main = new Main();
        int opc;

        do {

            opc = main.menu();

            switch (opc){

                case 1 -> instituto.nuevoAlumno();


                case 2 -> instituto.nuevoProfesor();


                case 3 -> System.out.println(instituto.mostrarAlumnos());


                case 4 -> System.out.println(instituto.mostrarProfesores());


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
