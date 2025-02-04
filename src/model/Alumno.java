package model;

import java.util.Scanner;

public class Alumno extends Persona {
    private Curso curso;

    public Alumno(String dni, String nombre, int edad, Curso curso) {
        super(dni, nombre, edad);
        this.curso = curso;
    }

    public Alumno() {}

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void leerDatos() {
        leerDatosPersona();
        this.curso = leerCurso();
    }

    private Curso leerCurso() {
        Scanner scan = new Scanner(System.in);
        int opc;
        do {
            System.out.println("Introduzca el curso:\n" +
                    "1. DAM\n" +
                    "2. DAW\n" +
                    "3. SMR");
            while (!scan.hasNextInt()) {
                System.out.println("Entrada inválida. Ingrese un número:");
                scan.next();
            }
            opc = scan.nextInt();
            switch (opc) {
                case 1 -> curso = Curso.DAM;
                case 2 -> curso = Curso.DAW;
                case 3 -> curso = Curso.SMR;
                default -> System.out.println("Opción no válida.");
            }
        } while (opc < 1 || opc > 3);
        return curso;
    }
}
