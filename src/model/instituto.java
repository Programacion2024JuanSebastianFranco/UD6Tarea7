package model;
import java.util.Arrays;
import java.util.Scanner;
import static model.curso.*;

public class instituto {

    Scanner scan = new Scanner(System.in);


    private  alumno[] alumnos;
    private static int MAX_ALUMNOS = 2;
    private int totalAlumnos;
    private profesor[] profesores;
    private static int MAX_PROFESORES = 2;
    private int totalProfesores;


    public instituto() {
        this.alumnos = new alumno[MAX_ALUMNOS];
        this.profesores = new profesor[MAX_PROFESORES];
        totalProfesores = 0;
        totalAlumnos = 0;
    }


    public void cargarDatosPrueba() {
        if (totalAlumnos < MAX_ALUMNOS) {
            alumnos[totalAlumnos++] = new alumno("12345678A", "Alumno1", 18, DAM);
            alumnos[totalAlumnos++] = new alumno("87654321B", "Alumno2", 20, DAW);
        }

        if (totalProfesores < MAX_PROFESORES) {
            profesores[totalProfesores++] = new profesor("11223344C", "Profesor1", 40, 2000);
            profesores[totalProfesores++] = new profesor("44332211D", "Profesor2", 35, 2500);
        }
    }


    public void nuevoAlumno(){
        if (totalAlumnos < MAX_ALUMNOS){

            System.out.println("Ingrese el nombre del alumno:");
            String nombre = scan.nextLine();

            int edad = leerEdad();
            String dni = leerDNI();
            curso curso = leerCurso();

            alumno nuevo = new alumno(dni, nombre, edad, curso);

            alumnos[totalAlumnos] = nuevo;
            totalAlumnos++;
        } else {
            System.out.println("Limite maximo de alumnos alcanzado");
        }
    }


    public void nuevoProfesor(){
        if (totalProfesores < MAX_PROFESORES){

            System.out.println("Ingrese el nombre del Profesor:");
            String nombre = scan.nextLine();
            int edad = leerEdad();
            String dni = leerDNI();
            System.out.println("Ingrese sueldo:");
            int sueldo = scan.nextInt();

            profesor nuevo = new profesor(dni, nombre, edad, sueldo);
            profesores[totalProfesores] = nuevo;
            totalProfesores++;
        } else {
            System.out.println("Limite maximo de profesores alcanzado");
        }
    }


    public String mostrarAlumnos() {
        StringBuilder salida = new StringBuilder();
        int contadorAlumnos = 0;

        for (alumno alumno : alumnos) {
            if (alumno != null) {
                salida.append("Alumno: ").append(alumno).append("\n");
                contadorAlumnos++;
            }
        }

        if (contadorAlumnos == 0) {
            salida.append("No hay alumnos registrados.\n");
        }

        return salida.toString();
    }


    public String mostrarProfesores() {
        StringBuilder salida = new StringBuilder();
        int contadorProfesores = 0;

        for (profesor profesor : profesores) {
            if (profesor != null) {
                salida.append("Profesor: ").append(profesor).append("\n");
                contadorProfesores++;
            }
        }

        if (contadorProfesores == 0) {
            salida.append("No hay profesores registrados.\n");
        }

        return salida.toString();
    }


    private int leerEdad(){

        int edad;

        System.out.println("Introduce la edad:");

        while (!scan.hasNextInt()) {
            System.out.println("Introduce un valor:");
            scan.next();
        }

        edad = scan.nextInt();

        if (edad <= 0){
            System.out.println("La edad debe ser un numero positivo: ");
            scan.next();
        }
        scan.nextLine();

        return edad;
    }

    private String leerDNI(){

        String dni;

        System.out.println("Introduce el DNI:");
        do {
            dni = scan.nextLine();
            if (!persona.validarNIF(dni)){
                System.out.println("DNI invalido, introducelo denuevo:");
            }
        } while (!persona.validarNIF(dni));

        return dni;
    }

    private curso leerCurso(){

        int cur;
        curso cursos = null;

        do {
            System.out.println("Introduce el curso (1. DAM, 2. DAW, 3. SMR):");

            while (!scan.hasNextInt()) {
                System.out.println("Entrada inválida. Introduce un número del 1 al 3:");
                scan.next();
            }

            cur = scan.nextInt();
            scan.nextLine();

            if (cur < 1 || cur > 3) {
                System.out.println("Curso inválido. Introdúcelo de nuevo.");
            }

        } while (cur < 1 || cur > 3);

        switch (cur) {
            case 1 -> cursos = DAM;
            case 2 -> cursos = DAW;
            case 3 -> cursos = SMR;
        }

        return cursos;

    }
}
