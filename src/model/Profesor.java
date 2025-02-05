package model;

import java.util.Scanner;

/**
 * Clase Profesor que hereda de Persona y representa a un docente con un sueldo asignado.
 */
public class Profesor extends Persona {
    private int sueldo = 0; // Sueldo del profesor, inicializado en 0

    /**
     * Constructor con parámetros.
     * @param dni Documento Nacional de Identidad del profesor.
     * @param nombre Nombre del profesor.
     * @param edad Edad del profesor.
     * @param sueldo Sueldo del profesor.
     */
    public Profesor(String dni, String nombre, int edad, int sueldo) {
        super(dni, nombre, edad); // Llama al constructor de la clase base Persona
        this.sueldo = sueldo;
    }

    /**
     * Constructor vacío.
     */
    public Profesor() {}

    /**
     * Obtiene el sueldo del profesor.
     * @return Sueldo actual del profesor.
     */
    public int getSueldo() {
        return sueldo;
    }

    /**
     * Establece el sueldo del profesor, asegurando que no sea negativo.
     * @param sueldo Nuevo sueldo a asignar.
     */
    public void setSueldo(int sueldo) {
        this.sueldo = Math.max(sueldo, 0); // Evita valores negativos
    }

    /**
     * Método para leer los datos del profesor desde la entrada estándar.
     */
    public void leerDatos() {
        leerDatosPersona(); // Llama al método de la superclase para leer datos personales
        sueldo = leerSueldo(); // Asigna el sueldo ingresado por el usuario
    }

    /**
     * Método privado para leer el sueldo desde la entrada estándar.
     * @return Sueldo introducido por el usuario, garantizando que sea válido.
     */
    private int leerSueldo() {
        Scanner sc = new Scanner(System.in);
        int sueldo;
        do {
            System.out.print("Introduzca el sueldo: ");
            while (!sc.hasNextInt()) { // Valida que la entrada sea un número entero
                System.out.println("Introduce un numero:");
                sc.next(); // Limpia la entrada incorrecta
            }
            sueldo = sc.nextInt();
        } while (sueldo < 0); // Asegura que el sueldo no sea negativo
        return sueldo;
    }
}