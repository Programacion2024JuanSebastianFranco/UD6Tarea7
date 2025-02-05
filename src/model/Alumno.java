package model;

import java.util.Scanner;

/**
 * Clase Alumno que hereda de Persona y representa a un estudiante con un curso asociado.
 */
public class Alumno extends Persona {
    private Curso curso; // Curso en el que está inscrito el alumno

    /**
     * Constructor con parámetros.
     * @param dni Documento Nacional de Identidad del alumno.
     * @param nombre Nombre del alumno.
     * @param edad Edad del alumno.
     * @param curso Curso en el que está inscrito.
     */
    public Alumno(String dni, String nombre, int edad, Curso curso) {
        super(dni, nombre, edad); // Llama al constructor de la clase base Persona
        this.curso = curso;
    }

    /**
     * Constructor vacío.
     */
    public Alumno() {}

    /**
     * Obtiene el curso del alumno.
     * @return Curso en el que está inscrito el alumno.
     */
    public Curso getCurso() {
        return curso;
    }

    /**
     * Establece el curso del alumno.
     * @param curso Curso a asignar al alumno.
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    /**
     * Método para leer los datos del alumno desde la entrada estándar.
     */
    public void leerDatos() {
        leerDatosPersona(); // Llama al método de la superclase para leer datos personales
        this.curso = leerCurso(); // Asigna el curso ingresado por el usuario
    }

    /**
     * Método privado para leer el curso desde la entrada estándar.
     * @return Curso seleccionado por el usuario.
     */
    private Curso leerCurso() {
        Scanner scan = new Scanner(System.in);
        int opc;
        do {
            System.out.println("Introduzca el curso:\n" +
                    "1. DAM\n" +
                    "2. DAW\n" +
                    "3. SMR");

            while (!scan.hasNextInt()) { // Valida que la entrada sea un número
                System.out.println("Ingrese un numero:");
                scan.next(); // Limpia la entrada incorrecta
            }
            opc = scan.nextInt();

            switch (opc) {
                case 1 -> curso = Curso.DAM;
                case 2 -> curso = Curso.DAW;
                case 3 -> curso = Curso.SMR;
                default -> System.out.println("Opcion no valida");
            }
        } while (opc < 1 || opc > 3); // Repite hasta que la opción sea válida
        return curso;
    }
}
