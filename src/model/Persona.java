package model;

import java.util.Objects;
import java.util.Scanner;

public abstract class Persona {
    private String dni;
    private String nombre;
    private int edad;
    static final Scanner scan = new Scanner(System.in);


    public Persona(String dni, String nombre, int edad) {
        setDni(dni);
        this.nombre = nombre;
        this.edad = edad;
    }

    public Persona() {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        if (esCorrectoNIF(dni)) {
            this.dni = dni;
        } else {
            this.dni = "Sin DNI";
        }
    }

    public static boolean esCorrectoNIF(String NIF) {
        if (NIF.length() != 9) return false;

        for (int i = 0; i < 8; i++) {
            if (!Character.isDigit(NIF.charAt(i))) return false;
        }

        char letra = Character.toUpperCase(NIF.charAt(8));
        if (!Character.isLetter(letra)) return false;

        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int num = Integer.parseInt(NIF.substring(0, 8));
        return letra == letras.charAt(num % 23);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(dni, persona.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dni);
    }

    public abstract void leerDatos();

    protected void leerDatosPersona() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca el nombre: ");
        nombre = sc.nextLine();
        this.dni = leerDni();
        this.edad = leerEdad();
    }

    private String leerDni() {
        String dni;
        do {
            System.out.print("Introduce el DNI: ");
            dni = scan.nextLine();
        } while (!esCorrectoNIF(dni));
        return dni;
    }

    public int leerEdad() {
        do {
            System.out.print("Dime la edad: ");
            while (!scan.hasNextInt()) {
                System.out.println("Entrada incorrecta. Ingrese un número:");
                scan.next();
            }
            edad = scan.nextInt();
        } while (edad < 0);
        return edad;
    }
}
