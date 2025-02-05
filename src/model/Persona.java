package model;

import java.util.Objects;
import java.util.Scanner;

/**
 * Clase abstracta Persona que representa una persona genérica con atributos comunes
 * como DNI, nombre y edad. Los métodos heredados son utilizados para obtener y modificar
 * estos atributos. Esta clase también valida el formato del DNI.
 */
public abstract class Persona {
    // Atributos comunes para todas las personas (DNI, nombre, edad).
    private String dni;
    private String nombre;
    private int edad;

    // Scanner para leer datos desde la consola.
    static final Scanner scan = new Scanner(System.in);

    /**
     * Constructor de la clase Persona que inicializa los atributos con los valores proporcionados.
     *
     * @param dni El DNI de la persona.
     * @param nombre El nombre de la persona.
     * @param edad La edad de la persona.
     */
    public Persona(String dni, String nombre, int edad) {
        setDni(dni); // Establece el DNI utilizando la validación.
        this.nombre = nombre;
        this.edad = edad;
    }

    /**
     * Constructor sin parámetros, útil para instanciación sin datos iniciales.
     */
    public Persona() {}

    /**
     * Getter para el nombre de la persona.
     *
     * @return El nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter para el nombre de la persona.
     *
     * @param nombre El nombre de la persona.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter para la edad de la persona.
     *
     * @return La edad de la persona.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Setter para la edad de la persona.
     *
     * @param edad La edad de la persona.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Getter para el DNI de la persona.
     *
     * @return El DNI de la persona.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Setter para el DNI de la persona. Si el DNI proporcionado no es válido, se establece
     * como "Sin DNI".
     *
     * @param dni El DNI de la persona.
     */
    public void setDni(String dni) {
        if (esCorrectoNIF(dni)) {
            this.dni = dni; // Si el DNI es válido, se asigna.
        } else {
            this.dni = "Sin DNI"; // Si el DNI no es válido, se asigna un valor predeterminado.
        }
    }

    /**
     * Método estático que valida si el formato del DNI es correcto.
     *
     * @param NIF El DNI a validar.
     * @return true si el DNI es válido, false si no lo es.
     */
    public static boolean esCorrectoNIF(String NIF) {
        // Verificación básica del formato del NIF (9 caracteres: 8 dígitos + 1 letra).
        if (NIF.length() != 9) return false;

        for (int i = 0; i < 8; i++) {
            if (!Character.isDigit(NIF.charAt(i))) return false; // Los primeros 8 caracteres deben ser dígitos.
        }

        // La última posición debe ser una letra, que se verifica con la lista de letras asociadas a los números.
        char letra = Character.toUpperCase(NIF.charAt(8));
        if (!Character.isLetter(letra)) return false;

        // Lista de letras que se corresponden con cada número del DNI.
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int num = Integer.parseInt(NIF.substring(0, 8)); // Se extraen los primeros 8 caracteres como número.
        return letra == letras.charAt(num % 23); // Se valida la letra usando el número y el módulo 23.
    }

    /**
     * Método que compara dos objetos Persona para ver si son iguales, basándose en su DNI.
     *
     * @param o El objeto a comparar.
     * @return true si ambos objetos son iguales, false si no lo son.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false; // Verifica que sean del mismo tipo.
        Persona persona = (Persona) o;
        return Objects.equals(dni, persona.dni); // Compara por el DNI.
    }

    /**
     * Método que genera un código hash basado en el DNI de la persona.
     *
     * @return El código hash basado en el DNI.
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(dni); // Devuelve el hashcode del DNI.
    }

    /**
     * Método abstracto que debe ser implementado por las clases hijas para leer los datos
     * específicos de cada tipo de persona (alumno, profesor, etc.).
     */
    public abstract void leerDatos();

    /**
     * Método protegido para leer los datos comunes de una persona (nombre, DNI, edad).
     * Este método es usado por las clases hijas para realizar la lectura de datos de manera
     * consistente.
     */
    protected void leerDatosPersona() {
        // Solicita al usuario que ingrese el nombre, DNI y edad.
        System.out.print("Introduzca el nombre: ");
        nombre = scan.nextLine();
        this.dni = leerDni(); // Llama al método leerDni() para asegurar que el DNI sea correcto.
        this.edad = leerEdad(); // Llama al método leerEdad() para asegurar que la edad sea válida.
    }

    /**
     * Método privado que lee un DNI válido desde la entrada del usuario.
     *
     * @return El DNI válido introducido por el usuario.
     */
    private String leerDni() {
        Scanner sc = new Scanner(System.in);
        String dni;
        do {
            System.out.print("Introduzca el DNI: ");
            dni = sc.nextLine();
        } while (!esCorrectoNIF(dni)); // Asegura que el DNI es válido.
        return dni;
    }

    /**
     * Método que lee la edad de la persona desde la entrada del usuario.
     * Si se ingresa un valor no válido, se sigue pidiendo hasta que se ingrese un número entero
     * mayor o igual a 0.
     *
     * @return La edad válida introducida por el usuario.
     */
    public int leerEdad() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Introduzca la edad: ");
            while (!sc.hasNextInt()) {
                System.out.println("Ingrese un numero:");
                sc.next(); // Limpia la entrada incorrecta.
            }
            edad = sc.nextInt();
        } while (edad < 0); // Asegura que la edad sea mayor o igual a 0.
        return edad;
    }
}
