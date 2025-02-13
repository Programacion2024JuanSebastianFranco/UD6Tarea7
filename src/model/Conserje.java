package model;

import java.util.Scanner;

/**
 * Clase Conserje que hereda de Persona y representa a un conserje con un turno asignado.
 */
public class Conserje extends Persona {
    private Turno turno; // Turno en el que trabaja el conserje

    /**
     * Constructor vacío.
     */
    public Conserje() {}

    /**
     * Constructor con parámetros.
     * @param dni Documento Nacional de Identidad del conserje.
     * @param nombre Nombre del conserje.
     * @param edad Edad del conserje.
     * @param turno Turno en el que trabaja el conserje.
     */
    public Conserje(String dni, String nombre, int edad, Turno turno) {
        super(dni, nombre, edad); // Llama al constructor de la clase base Persona
        if (turno == null) {
            throw new IllegalArgumentException("El turno no puede ser nulo");
        }
        this.turno = turno;
    }

    /**
     * Obtiene el turno del conserje.
     * @return Turno en el que trabaja el conserje.
     */
    public Turno getTurno() {
        return turno;
    }

    /**
     * Establece el turno del conserje.
     * @param turno Turno a asignar al conserje.
     * @throws IllegalArgumentException si el turno es nulo.
     */
    public void setTurno(Turno turno) {
        if (turno == null) {
            throw new IllegalArgumentException("El turno no puede ser nulo");
        }
        this.turno = turno;
    }

    /**
     * Método para leer los datos del conserje desde la entrada estándar.
     * @throws IllegalArgumentException si alguno de los datos ingresados es inválido.
     */
    public void leerDatos() {
        try {
            leerDatosPersona(); // Llama al método de la superclase para leer datos personales
            this.turno = leerTurno(); // Asigna el turno ingresado por el usuario
        } catch (Exception ex) {
            System.out.println("Error al ingresar los datos");
        }
    }

    /**
     * Método privado para leer el turno desde la entrada estándar.
     * @return Turno seleccionado por el usuario.
     * @throws IllegalArgumentException si la opción seleccionada no es válida.
     */
    private Turno leerTurno() {
        Scanner scan = new Scanner(System.in);
        int opc;
        do {
            System.out.println("Introduzca el turno:\n" +
                    "1. DIURNO\n" +
                    "2. NOCTURNO");
            while (!scan.hasNextInt()) { // Valida que la entrada sea un número
                System.out.println("Ingrese un numero valido:");
                scan.next(); // Limpia la entrada incorrecta
            }
            opc = scan.nextInt();
            switch (opc) {
                case 1 -> turno = Turno.DIURNO;
                case 2 -> turno = Turno.NOCTURNO;
                default -> {
                    System.out.println("Opcion no valida");
                    throw new IllegalArgumentException("Opcion no valida para el turno");
                }
            }
        } while (opc < 1 || opc > 2); // Repite hasta que la opción sea válida
        return turno;
    }
}
