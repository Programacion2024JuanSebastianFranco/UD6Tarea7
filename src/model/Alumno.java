package model;

import java.util.Scanner;

/**
 * Clase Alumno que hereda de Persona y representa a un estudiante con un curso asociado.
 */
public class Alumno extends Persona {
    private Curso curso; // Curso en el que esta inscrito el alumno

    /**
     * Constructor con parametros.
     * @param dni Documento Nacional de Identidad del alumno.
     * @param nombre Nombre del alumno.
     * @param edad Edad del alumno.
     * @param curso Curso en el que esta inscrito.
     */
    public Alumno(String dni, String nombre, int edad, Curso curso) {
        super(dni, nombre, edad); // Llama al constructor de la clase base Persona
        this.curso = curso;
    }

    /**
     * Constructor vacio.
     */
    public Alumno() {}

    /**
     * Obtiene el curso del alumno.
     * @return Curso en el que esta inscrito el alumno.
     */
    public Curso getCurso() {
        return curso;
    }

    /**
     * Establece el curso del alumno.
     * @param curso Curso a asignar al alumno.
     * @throws IllegalArgumentException Si el curso es null o invalido.
     */
    public void setCurso(Curso curso) throws IllegalArgumentException {
        if (curso == null) {
            throw new IllegalArgumentException("El curso no puede ser nulo");
        }
        this.curso = curso;
    }

    /**
     * Metodo para leer los datos del alumno desde la entrada estandar.
     */
    public void leerDatos() {
        try {
            leerDatosPersona(); // Llama al metodo de la superclase para leer datos personales
            this.curso = leerCurso(); // Asigna el curso ingresado por el usuario
        } catch (IllegalArgumentException e) {
            System.out.println("Datos incorrectos"); // Muestra el mensaje del error si la entrada es incorrecta
        }
    }

    /**
     * Metodo privado para leer el curso desde la entrada estandar.
     * @return Curso seleccionado por el usuario.
     * @throws IllegalArgumentException Si la opcion seleccionada no es valida.
     */
    private Curso leerCurso() throws IllegalArgumentException {
        Scanner scan = new Scanner(System.in);
        int opc;
        do {
            System.out.println("Introduzca el curso:\n" +
                    "1. DAM\n" +
                    "2. DAW\n" +
                    "3. SMR");

            if (!scan.hasNextInt()) { // Valida que la entrada sea un numero
                throw new IllegalArgumentException("Entrada no valida, se espera un numera");
            }
            opc = scan.nextInt();

            switch (opc) {
                case 1 -> curso = Curso.DAM;
                case 2 -> curso = Curso.DAW;
                case 3 -> curso = Curso.SMR;
                default -> throw new IllegalArgumentException("Opcion no valida, seleccione un numero entre 1 y 3");
            }
        } while (opc < 1 || opc > 3); // Repite hasta que la opcion sea valida
        return curso;
    }
}
