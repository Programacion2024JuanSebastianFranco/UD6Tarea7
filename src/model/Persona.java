package model;

import java.util.Objects;
import java.util.Scanner;

/**
 * Clase abstracta Persona que representa una persona generica con atributos comunes
 * como DNI, nombre y edad. Los metodos heredados son utilizados para obtener y modificar
 * estos atributos. Esta clase valida el formato del DNI.
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
        try {
            setDni(dni); // Establece el DNI utilizando la validacion.
        } catch (IllegalArgumentException e) {
            this.dni = "Sin DNI"; // Si hay error, se asigna "Sin DNI"
        }
        this.nombre = nombre;
        this.edad = edad;
    }

    /**
     * Constructor sin parametros, util para instanciacion sin datos iniciales.
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
     * Setter para el DNI de la persona. Si el DNI proporcionado no es valido, se establece
     * como "Sin DNI".
     *
     * @param dni El DNI de la persona.
     */
    public void setDni(String dni) {
        if (esCorrectoNIF(dni)) {
            this.dni = dni; // Si el DNI es valido, se asigna.
        } else {
            throw new IllegalArgumentException("Datos Incorrectos"); // Lanza excepcion sin mensaje si es invalido
        }
    }

    /**
     * Metodo estatico que valida si el formato del DNI es correcto.
     *
     * @param NIF El DNI a validar.
     * @return true si el DNI es valido, false si no lo es.
     */
    public static boolean esCorrectoNIF(String NIF) {
        // Verificacion basica del formato del NIF (9 caracteres: 8 digitos + 1 letra).
        if (NIF.length() != 9) return false;

        for (int i = 0; i < 8; i++) {
            if (!Character.isDigit(NIF.charAt(i))) return false; // Los primeros 8 caracteres deben ser digitos.
        }

        // La ultima posicion debe ser una letra, que se verifica con la lista de letras asociadas a los numeros.
        char letra = Character.toUpperCase(NIF.charAt(8));
        if (!Character.isLetter(letra)) return false;

        // Lista de letras que se corresponden con cada numero del DNI.
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int num = Integer.parseInt(NIF.substring(0, 8)); // Se extraen los primeros 8 caracteres como numero.
        return letra == letras.charAt(num % 23); // Se valida la letra usando el numero y el modulo 23.
    }

    /**
     * Metodo que compara dos objetos Persona para ver si son iguales, basandose en su DNI.
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
     * Metodo que genera un codigo hash basado en el DNI de la persona.
     *
     * @return El codigo hash basado en el DNI.
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(dni); // Devuelve el hashcode del DNI.
    }

    /**
     * Metodo abstracto que debe ser implementado por las clases hijas para leer los datos
     * especificos de cada tipo de persona (alumno, profesor, etc.).
     */
    public abstract void leerDatos();

    /**
     * Metodo protegido para leer los datos comunes de una persona (nombre, DNI, edad).
     * Este metodo es usado por las clases hijas para realizar la lectura de datos de manera
     * consistente.
     */
    protected void leerDatosPersona() {
        // Solicita al usuario que ingrese el nombre, DNI y edad.
        System.out.print("Introduzca el nombre: ");
        nombre = scan.nextLine();
        try {
            this.dni = leerDni(); // Llama al metodo leerDni() para asegurar que el DNI es correcto.
        } catch (IllegalArgumentException e) {
            this.dni = "Sin DNI"; // Si hay error, se asigna "Sin DNI"
        }
        this.edad = leerEdad(); // Llama al metodo leerEdad() para asegurar que la edad es valida.
    }

    /**
     * Metodo privado que lee un DNI valido desde la entrada del usuario.
     *
     * @return El DNI valido introducido por el usuario.
     * @throws IllegalArgumentException si el DNI no es valido.
     */
    private String leerDni() {
        Scanner sc = new Scanner(System.in);
        String dni;
        do {
            System.out.print("Introduzca el DNI: ");
            dni = sc.nextLine();
            if (!esCorrectoNIF(dni)) {
                dni = "Sin DNI"; // No es necesario mensaje de error
            }
        } while (!esCorrectoNIF(dni)); // Asegura que el DNI es valido.
        return dni;
    }

    /**
     * Metodo que lee la edad de la persona desde la entrada del usuario.
     * Si se ingresa un valor no valido, se sigue pidiendo hasta que se ingrese un numero entero
     * mayor o igual a 0.
     *
     * @return La edad valida introducida por el usuario.
     */
    public int leerEdad() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Introduzca la edad: ");
            while (!sc.hasNextInt()) {
                sc.next(); // Limpia la entrada incorrecta.
            }
            edad = sc.nextInt();
        } while (edad < 0); // Asegura que la edad sea mayor o igual a 0.
        return edad;
    }
}
