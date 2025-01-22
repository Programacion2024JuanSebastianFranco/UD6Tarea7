package model;

import java.util.Scanner;

import static model.curso.*;

public class instituto {

    Scanner scan = new Scanner(System.in);


    private  alumno[] alumnos;
    private static int MAX_ALUMNOS;
    private int totalAlumnos;
    private profesor[] profesores;
    private static int MAX_PROFESORES;
    private int totalProfesores;


    public instituto() {
        this.alumnos = new alumno[MAX_ALUMNOS];
        this.profesores = new profesor[MAX_PROFESORES];
        totalProfesores = 0;
        totalAlumnos = 0;
    }

    public void nuevoAlumno(){
        if (totalAlumnos < MAX_ALUMNOS){

            System.out.println("Ingrese el nombre del alumno:");
            String nombre = scan.nextLine();
            int edad = leerEdad();
            String dni = leerDNI();
            curso curso = leerCurso();

            alumno nuevo = new alumno(dni, nombre, edad, curso);


        }

    }


    private int leerEdad(){

        int edad;

        System.out.println("Introduce la edad:");

        while (!scan.hasNextInt()) {
            System.out.println("Introduce un valor:");
        }

        edad = scan.nextInt();

        if (edad <= 0){

        }


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
            cur = scan.nextInt();
            if (!scan.hasNextInt()){
                System.out.println("curso invalido, introducelo denuevo");
            }
        } while (cur < 1 || cur > 3);


        switch (cur){
            case 1 -> cursos = DAM;
            case 2 -> cursos = DAW;
            case 3 -> cursos = SMR;
        }

        return cursos;

    }


}
