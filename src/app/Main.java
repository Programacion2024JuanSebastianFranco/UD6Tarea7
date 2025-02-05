package app;

import model.*;

import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);
    Instituto instituto = new Instituto();

    public static void main(String[] args) {
        Main principal = new Main();
        int opcion;
        do {
            opcion = mostrarMenu();
            switch (opcion) {
                case 1 -> principal.instituto.nuevoAlumno(new Alumno());
                case 2 -> principal.instituto.nuevoProfesor(new Profesor());
                case 3 -> System.out.println(principal.instituto.mostrarAlumno());
                case 4 -> System.out.println(principal.instituto.mostrarProfesor());
                case 5 -> {
                    Alumno alumno = new Alumno("98765432A", "Carlos", 20, Curso.DAW);
                    principal.instituto.modificarAlumno(alumno);
                }
                case 6 -> {
                    Profesor profesor = new Profesor("45612378B", "Marta", 45, 1200);
                    principal.instituto.modificarProfesor(profesor);
                }
                case 7 -> {
                    System.out.println("Ingresa el DNI del conserje que quieres modificar");
                    String dniConserjeModificar = scan.nextLine();
                    Conserje conserje = new Conserje(dniConserjeModificar, "Andres", 38, Turno.DIURNO);
                    principal.instituto.modificarConserje(conserje);
                }

                case 8 -> {
                    System.out.println("Ingresa el DNI del profesor que quieres eliminar");
                    String dniProfesor = scan.nextLine();
                    if (principal.instituto.existeDniProfesor(dniProfesor)) {
                        principal.instituto.borrarProfesor(dniProfesor);
                    } else {
                        System.out.println("No se encontro un profesor con ese DNI");
                    }
                }

                case 9 -> {
                    System.out.println("Ingresa el DNI del alumno que quieres eliminar");
                    String dniAlumno = scan.nextLine();
                    if (principal.instituto.existeDniAlumno(dniAlumno)) {
                        principal.instituto.borrarAlumno(dniAlumno);
                    } else {
                        System.out.println("No se encontro un alumno con ese DNI");
                    }
                }

                case 10 -> {
                    System.out.println("Ingresa el DNI del conserje que quieres eliminar");
                    String dniConserje = scan.nextLine();
                    if (principal.instituto.existeDniConserje(dniConserje)) {
                        principal.instituto.borrarConserje(dniConserje);
                    } else {
                        System.out.println("No se encontro un conserje con ese DNI");
                    }
                }

                case 11 -> {
                    System.out.println("Ingresa el DNI del alumno que buscas");
                    String dniAlumnoBuscar = scan.nextLine();
                    if (principal.instituto.existeDniAlumno(dniAlumnoBuscar)) {
                        System.out.println(principal.instituto.buscarAlumno(dniAlumnoBuscar));
                    } else {
                        System.out.println("No se encontro un alumno con ese DNI");
                    }
                }

                case 12 -> {
                    System.out.println("Ingresa el DNI del profesor que buscas");
                    String dniProfesorBuscar = scan.nextLine();
                    if (principal.instituto.existeDniProfesor(dniProfesorBuscar)) {
                        System.out.println(principal.instituto.buscarProfesor(dniProfesorBuscar));
                    } else {
                        System.out.println("No se encontro un profesor con ese DNI");
                    }
                }

                case 13 -> principal.instituto.nuevoConserje1(new Conserje());

                case 14 -> {
                    System.out.println("Ingresa el DNI del conserje que buscas");
                    String dniConserjeBuscar = scan.nextLine();
                    if (principal.instituto.existeDniConserje(dniConserjeBuscar)) {
                        System.out.println(principal.instituto.buscarConserje(dniConserjeBuscar));
                    } else {
                        System.out.println("No se encontro un conserje con ese DNI");
                    }
                }

                case 15 -> System.out.println(principal.instituto.mostrarConserje());

                case 16 -> {
                    System.out.println("Ingresa el DNI del alumno para verificar si existe");
                    String dniAlumnoVerificar = scan.nextLine();
                    System.out.println(principal.instituto.existeDniAlumno(dniAlumnoVerificar));
                }

                case 17 -> {
                    System.out.println("Ingresa el DNI del profesor para verificar si existe");
                    String dniProfesorVerificar = scan.nextLine();
                    System.out.println(principal.instituto.existeDniProfesor(dniProfesorVerificar));
                }

                case 18 -> {
                    System.out.println("Ingresa el DNI del conserje para verificar si existe");
                    String dniConserjeVerificar = scan.nextLine();
                    System.out.println(principal.instituto.existeDniConserje(dniConserjeVerificar));
                }

                case 19 -> System.out.println("Adios");
                default -> System.out.println("Valor incorrecto");

            }
        } while (opcion != 19);
    }

    private static int mostrarMenu() {
        int opcion;
        do {
            System.out.println("Elige una opción");
            System.out.println("""
                    1. Nuevo Alumno
                    2. Nuevo Profesor
                    3. Mostrar Alumnos
                    4. Mostrar Profesores
                    5. Modificar Alumno
                    6. Modificar Profesor
                    7. Modificar Conserje
                    8. Borrar Profesor
                    9. Borrar Alumno
                    10. Borrar Conserje
                    11. Buscar Alumno
                    12. Buscar Profesor
                    13. Nuevo Conserje
                    14. Buscar Conserje
                    15. Mostrar Conserjes
                    16. Existe DNI Alumno
                    17. Existe DNI Profesor
                    18. Existe DNI Conserje
                    19. Salir
                    """);
            while (!scan.hasNextInt()) {
                System.out.println("Invalido, ingrese un numero entero:");
                scan.next();
            }
            opcion = scan.nextInt();
            scan.nextLine();
        } while (opcion < 1 || opcion > 19);
        return opcion;
    }
}
