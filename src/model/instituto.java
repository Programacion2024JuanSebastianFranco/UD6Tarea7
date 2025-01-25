package model;
import java.util.Scanner;
import static model.curso.*;

/**
 * Clase que gestiona un instituto con alumnos y profesores.
 * Permite agregar nuevos alumnos y profesores, y mostrar los registros.
 */
public class instituto {

    Scanner scan = new Scanner(System.in); // Instancia para la entrada del usuario

    // Declaración de variables privadas (no comentadas, como pediste).
    private alumno[] alumnos;
    private static int MAX_ALUMNOS = 2;
    private int totalAlumnos;
    private profesor[] profesores;
    private static int MAX_PROFESORES = 2;
    private int totalProfesores;

    /**
     * Constructor que inicializa los arreglos de alumnos y profesores,
     * y establece los contadores de total de alumnos y profesores.
     */
    public instituto() {
        this.alumnos = new alumno[MAX_ALUMNOS];
        this.profesores = new profesor[MAX_PROFESORES];
        totalProfesores = 0;
        totalAlumnos = 0;
    }

    /**
     * Método para cargar datos de prueba para alumnos y profesores.
     * Este método llena el instituto con datos predeterminados.
     */
    public void cargarDatosPrueba() {
        if (totalAlumnos < MAX_ALUMNOS) {
            // Se cargan dos alumnos de prueba.
            alumnos[totalAlumnos++] = new alumno("12345678A", "Alumno1", 18, DAM);
            alumnos[totalAlumnos++] = new alumno("87654321B", "Alumno2", 20, DAW);
        }

        if (totalProfesores < MAX_PROFESORES) {
            // Se cargan dos profesores de prueba.
            profesores[totalProfesores++] = new profesor("11223344C", "Profesor1", 40, 2000);
            profesores[totalProfesores++] = new profesor("44332211D", "Profesor2", 35, 2500);
        }
    }

    /**
     * Método para registrar un nuevo alumno en el instituto.
     * Permite al usuario ingresar nombre, edad, DNI y curso.
     */
    public void nuevoAlumno() {
        if (totalAlumnos < MAX_ALUMNOS) {
            // Solicita los datos del alumno.
            System.out.println("Ingrese el nombre del alumno:");
            String nombre = scan.nextLine();
            int edad = leerEdad();
            String dni = leerDNI();
            curso curso = leerCurso();

            // Se crea y agrega un nuevo alumno al arreglo.
            alumno nuevo = new alumno(dni, nombre, edad, curso);
            alumnos[totalAlumnos] = nuevo;
            totalAlumnos++;
        } else {
            System.out.println("Limite maximo de alumnos alcanzado");
        }
    }

    /**
     * Método para registrar un nuevo profesor en el instituto.
     * Permite al usuario ingresar nombre, edad, DNI y sueldo.
     */
    public void nuevoProfesor() {
        if (totalProfesores < MAX_PROFESORES) {
            // Solicita los datos del profesor.
            System.out.println("Ingrese el nombre del Profesor:");
            String nombre = scan.nextLine();
            int edad = leerEdad();
            String dni = leerDNI();
            System.out.println("Ingrese sueldo:");
            int sueldo = scan.nextInt();

            // Se crea y agrega un nuevo profesor al arreglo.
            profesor nuevo = new profesor(dni, nombre, edad, sueldo);
            profesores[totalProfesores] = nuevo;
            totalProfesores++;
        } else {
            System.out.println("Limite maximo de profesores alcanzado");
        }
    }

    /**
     * Método para mostrar la lista de alumnos registrados.
     * Si no hay alumnos registrados, muestra un mensaje adecuado.
     *
     * @return Una cadena con la lista de alumnos o un mensaje indicando que no hay alumnos.
     */
    public String mostrarAlumnos() {
        StringBuilder salida = new StringBuilder();
        int contadorAlumnos = 0;

        // Se recorre el arreglo de alumnos y se añaden los que no sean nulos.
        for (alumno alumno : alumnos) {
            if (alumno != null) {
                salida.append("Alumno: ").append(alumno).append("\n");
                contadorAlumnos++;
            }
        }

        // Si no se han encontrado alumnos, se agrega el mensaje correspondiente.
        if (contadorAlumnos == 0) {
            salida.append("No hay alumnos registrados.\n");
        }

        return salida.toString();
    }

    /**
     * Método para mostrar la lista de profesores registrados.
     * Si no hay profesores registrados, muestra un mensaje adecuado.
     *
     * @return Una cadena con la lista de profesores o un mensaje indicando que no hay profesores.
     */
    public String mostrarProfesores() {
        StringBuilder salida = new StringBuilder();
        int contadorProfesores = 0;

        // Se recorre el arreglo de profesores y se añaden los que no sean nulos.
        for (profesor profesor : profesores) {
            if (profesor != null) {
                salida.append("Profesor: ").append(profesor).append("\n");
                contadorProfesores++;
            }
        }

        // Si no se han encontrado profesores, se agrega el mensaje correspondiente.
        if (contadorProfesores == 0) {
            salida.append("No hay profesores registrados.\n");
        }

        return salida.toString();
    }

    /**
     * Método auxiliar para leer la edad del usuario, asegurándose de que sea un número válido.
     *
     * @return La edad ingresada por el usuario.
     */
    private int leerEdad() {
        int edad;

        System.out.println("Introduce la edad:");

        // Se asegura que la entrada sea un número entero.
        while (!scan.hasNextInt()) {
            System.out.println("Introduce un valor:");
            scan.next();
        }

        edad = scan.nextInt();

        // Valida que la edad sea un número positivo.
        if (edad <= 0) {
            System.out.println("La edad debe ser un número positivo: ");
            scan.next();
        }
        scan.nextLine();

        return edad;
    }

    /**
     * Método auxiliar para leer el DNI del usuario, asegurándose de que sea válido.
     *
     * @return El DNI ingresado por el usuario.
     */
    private String leerDNI() {
        String dni;

        System.out.println("Introduce el DNI:");
        do {
            dni = scan.nextLine();
            if (!persona.validarNIF(dni)) {
                System.out.println("DNI invalido, introducelo de nuevo:");
            }
        } while (!persona.validarNIF(dni));

        return dni;
    }

    /**
     * Método auxiliar para leer el curso del alumno, asegurándose de que sea válido.
     *
     * @return El curso seleccionado por el usuario.
     */
    private curso leerCurso() {
        int cur;
        curso cursos = null;

        do {
            System.out.println("Introduce el curso (1. DAM, 2. DAW, 3. SMR):");

            // Se asegura que la entrada sea un número válido.
            while (!scan.hasNextInt()) {
                System.out.println("Entrada inválida. Introduce un número del 1 al 3:");
                scan.next();
            }

            cur = scan.nextInt();
            scan.nextLine();

            // Valida que el número del curso esté dentro del rango permitido.
            if (cur < 1 || cur > 3) {
                System.out.println("Curso inválido. Introdúcelo de nuevo.");
            }

        } while (cur < 1 || cur > 3);

        // Asigna el valor del curso según la opción seleccionada.
        switch (cur) {
            case 1 -> cursos = DAM;
            case 2 -> cursos = DAW;
            case 3 -> cursos = SMR;
        }

        return cursos;
    }
}