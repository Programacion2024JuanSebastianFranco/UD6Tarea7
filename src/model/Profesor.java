package model;

import java.util.Scanner;

public class Profesor extends Persona {
    private int sueldo = 0;

    public Profesor(String dni, String nombre, int edad, int sueldo) {
        super(dni, nombre, edad);
        this.sueldo = sueldo;
    }

    public Profesor() {}

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = Math.max(sueldo, 0);
    }

    public void leerDatos() {
        leerDatosPersona();
        sueldo = leerSueldo();
    }

    private int leerSueldo() {
        Scanner sc = new Scanner(System.in);
        int sueldo;
        do {
            System.out.print("Dime el sueldo: ");
            while (!sc.hasNextInt()) {
                System.out.println("Incorrecto. Introduce un número:");
                sc.next();
            }
            sueldo = sc.nextInt();
        } while (sueldo < 0);
        return sueldo;
    }
}
