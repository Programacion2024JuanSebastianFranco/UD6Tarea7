package app;
import model.alumno;
import model.Curso;
import model.Instituto;
import model.Profesor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Instituto instituto = new Instituto();

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

                case 5 -> {
                    System.out.println("DNI a buscar: ");
                    String dni = scan.nextLine();
                    System.out.println(instituto.buscarAlumno(dni));
                }

                case 6 -> {
                    System.out.println("DNI a buscar: ");
                    String dni = scan.nextLine();
                    System.out.println(instituto.buscarProfesor(dni));
                }

                case 7 -> {
                    System.out.println("Posicion del alumno a borrar: ");
                    int posicion = scan.nextInt();
                    System.out.println(instituto.borrarAlumno(posicion));
                }

                case 8 -> {
                    System.out.println("Posicion del profesor a borrar: ");
                    int posicion = scan.nextInt();
                    System.out.println(instituto.borrarProfesor(posicion));
                }

                case 9 -> {
                    alumno alumno = new alumno("12345678z", "juan", 22, Curso.DAW);
                    instituto.modificarAlumno(alumno);
                }

                case 10 -> {
                     Profesor profesor = new Profesor("11223344C", "jaime", 23, 1300);
                    instituto.modificarProfesor(profesor);
                }




                default -> System.out.println("Valor no valido");

            }
        } while (opc != 11);
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
                    5. Buscar Alumno
                    6. Buscar Profesor
                    7. Borrar Alumno
                    8. Borrar Profesor
                    9. Modificar Alumno
                    10. Modificar Profesor
                    11. Salir
                    """);
            opc = scan.nextInt();


        } while (opc < 1 || opc > 11);
        return opc;
    }

}
