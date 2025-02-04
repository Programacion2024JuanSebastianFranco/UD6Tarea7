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
                case 1 -> principal.instituto.nuevoAlumno1(new Alumno());
                case 2 -> principal.instituto.nuevoProfesor1(new Profesor());
                case 3 -> System.out.println(principal.instituto.mostrarAlu());
                case 4 -> System.out.println(principal.instituto.mostrarProfe());
                case 5 -> {
                    Alumno alumno = new Alumno("98765432A", "Carlos", 20, Curso.DAW);
                    principal.instituto.modificarAlumno(alumno);
                }
                case 6 -> {
                    Profesor profesor = new Profesor("45612378B", "Marta", 45, 1200);
                    principal.instituto.modificarProfesor(profesor);
                }
                case 7 -> {
                    System.out.println("Dime el DNI del conserje a modificar");
                    String dniConserMod = scan.nextLine();
                    Conserje conserje = new Conserje(dniConserMod, "Andrés", 38, Turno.MAÑANA);
                    principal.instituto.modificarConserje(conserje);
                }
                case 8 -> {
                    System.out.println("Dime el DNI del profesor a eliminar");
                    String dniProfe = scan.nextLine();
                    if (principal.instituto.existeDniProf(dniProfe)) {
                        principal.instituto.borrarProfe(dniProfe);
                    } else {
                        System.out.println("El profesor con el DNI especificado no existe.");
                    }
                }
                case 9 -> {
                    System.out.println("Dime el DNI del alumno a eliminar");
                    String dniAlu = scan.nextLine();
                    if (principal.instituto.existeDniAlu(dniAlu)) {
                        principal.instituto.borrarAlu(dniAlu);
                    } else {
                        System.out.println("El alumno con el DNI especificado no existe.");
                    }
                }
                case 10 -> {
                    System.out.println("Dime el DNI del conserje a eliminar");
                    String dniCons = scan.nextLine();
                    if (principal.instituto.existeDniConser(dniCons)) {
                        principal.instituto.borrarConserje(dniCons);
                    } else {
                        System.out.println("El conserje con el DNI especificado no existe.");
                    }
                }
                case 11 -> {
                    System.out.println("Dime el DNI del alumno a buscar");
                    String dniAlumno = scan.nextLine();
                    if (principal.instituto.existeDniAlu(dniAlumno)) {
                        System.out.println(principal.instituto.buscarAlumno(dniAlumno));
                    } else {
                        System.out.println("El alumno con el DNI especificado no existe.");
                    }
                }
                case 12 -> {
                    System.out.println("Dime el DNI del profesor a buscar");
                    String dniProfesor = scan.nextLine();
                    if (principal.instituto.existeDniProf(dniProfesor)) {
                        System.out.println(principal.instituto.buscarProfesor(dniProfesor));
                    } else {
                        System.out.println("El profesor con el DNI especificado no existe.");
                    }
                }
                case 13 -> principal.instituto.nuevoConserje1(new Conserje());
                case 14 -> {
                    System.out.println("Dime el DNI del conserje a buscar");
                    String dniConserje = scan.nextLine();
                    if (principal.instituto.existeDniConser(dniConserje)) {
                        System.out.println(principal.instituto.buscarConserje(dniConserje));
                    } else {
                        System.out.println("El conserje con el DNI especificado no existe.");
                    }
                }
                case 15 -> System.out.println(principal.instituto.mostrarConserje());
                case 16 -> {
                    System.out.println("Dime el DNI del alumno para verificar existencia");
                    String dniAlumVer = scan.nextLine();
                    System.out.println(principal.instituto.existeDniAlu(dniAlumVer));
                }
                case 17 -> {
                    System.out.println("Dime el DNI del profesor para verificar existencia");
                    String dniProfVer = scan.nextLine();
                    System.out.println(principal.instituto.existeDniProf(dniProfVer));
                }
                case 18 -> {
                    System.out.println("Dime el DNI del conserje para verificar existencia");
                    String dniConserVer = scan.nextLine();
                    System.out.println(principal.instituto.existeDniConserje(dniConserVer));
                }
                case 19 -> System.out.println("Saliendo");
                default -> System.out.println("Error, valor incorrecto");
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
