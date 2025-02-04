package model;

import java.util.Scanner;

public class Conserje extends Persona {
    private Turno turno;

    public Conserje() {}

    public Conserje(String dni, String nombre, int edad, Turno turno) {
        super(dni, nombre, edad);
        this.turno = turno;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public void leerDatos() {
        leerDatosPersona();
        this.turno = leerTurno();
    }

    private Turno leerTurno() {
        Scanner scan = new Scanner(System.in);
        int opc;
        do {
            System.out.println("Introduzca el turno:\n" +
                    "1. DIURNO\n" +
                    "2. NOCTURNO");
            while (!scan.hasNextInt()) {
                System.out.println("Entrada inválida. Ingrese un número:");
                scan.next();
            }
            opc = scan.nextInt();
            switch (opc) {
                case 1 -> turno = Turno.DIURNO;
                case 2 -> turno = Turno.NOCTURNO;
                default -> System.out.println("Opción no válida.");
            }
        } while (opc < 1 || opc > 2);
        return turno;
    }
}
