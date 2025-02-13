package model;

/**
 * Clase Instituto que gestiona los alumnos, profesores y conserjes de una institucion educativa.
 * Permite realizar operaciones como agregar, modificar, eliminar y consultar personas.
 */
public class Instituto {
    // Arreglos para almacenar las personas de tipo Alumno, Profesor y Conserje
    Alumno[] alumnos;
    Profesor[] profesores;
    Conserje[] conserjes;

    // Límites máximos para el número de alumnos, profesores y conserjes
    int max_alumnos = 3;
    int max_profesores = 3;
    int max_conserje = 3;

    // Contadores para el número de personas añadidas en cada categoría
    int totalConserjes;
    int totalAlumnos;
    int totalProfesores;

    /**
     * Constructor del Instituto que inicializa los arreglos de personas y sus contadores.
     */
    public Instituto() {
        this.alumnos = new Alumno[max_alumnos];
        this.profesores = new Profesor[max_profesores];
        this.conserjes = new Conserje[max_conserje];
        this.totalProfesores = 0;
        this.totalAlumnos = 0;
        this.totalConserjes = 0;
    }

    /**
     * Método para agregar un nuevo alumno al instituto.
     * @param alumno El objeto Alumno a agregar.
     * @throws IllegalArgumentException si el alumno es nulo.
     */
    public void nuevoAlumno(Alumno alumno) {
        if (alumno == null) {
            throw new IllegalArgumentException("El alumno no puede ser nulo");
        }
        nuevaPersona(alumnos, alumno, totalAlumnos, max_alumnos);
        totalAlumnos++;
    }

    /**
     * Método para agregar un nuevo profesor al instituto.
     * @param profesor El objeto Profesor a agregar.
     * @throws IllegalArgumentException si el profesor es nulo.
     */
    public void nuevoProfesor(Profesor profesor) {
        if (profesor == null) {
            throw new IllegalArgumentException("El profesor no puede ser nulo");
        }
        nuevaPersona(profesores, profesor, totalProfesores, max_profesores);
        totalProfesores++;
    }

    /**
     * Método para agregar un nuevo conserje al instituto.
     * @param conserje El objeto Conserje a agregar.
     * @throws IllegalArgumentException si el conserje es nulo.
     */
    public void nuevoConserje1(Conserje conserje) {
        if (conserje == null) {
            throw new IllegalArgumentException("El conserje no puede ser nulo");
        }
        nuevaPersona(conserjes, conserje, totalConserjes, max_conserje);
        totalConserjes++;
    }

    /**
     * Método general para agregar una nueva persona al arreglo correspondiente.
     * @param personas El arreglo de personas (alumnos, profesores o conserjes).
     * @param persona La persona a agregar (Alumno, Profesor o Conserje).
     * @param totalActual El número actual de personas en el arreglo.
     * @param max El límite máximo de personas en el arreglo.
     * @throws IllegalArgumentException si la persona es nula o si no hay espacio disponible.
     */
    public void nuevaPersona(Persona[] personas, Persona persona, int totalActual, int max) {
        if (persona == null) {
            throw new IllegalArgumentException("La persona no puede ser nula");
        }
        if (totalActual >= max) {
            throw new IllegalArgumentException("No queda espacio para agregar mas personas");
        }
        persona.leerDatos(); // Se asume que leerDatos es un método que llena los datos de la persona.
        personas[totalActual] = persona; // Se agrega la persona al arreglo en la posición correspondiente.
    }

    /**
     * Verifica si un alumno con el DNI proporcionado ya existe en el instituto.
     * @param dni El DNI del alumno.
     * @return true si el alumno con ese DNI ya existe, false en caso contrario.
     * @throws IllegalArgumentException si el DNI es nulo o vacío.
     */
    public boolean existeDniAlumno(String dni) {
        if (dni == null || dni.isEmpty()) {
            throw new IllegalArgumentException("El DNI no puede ser nulo o vacio");
        }
        return existeDni(dni, alumnos); // Llama al método privado que verifica la existencia de un DNI.
    }

    /**
     * Verifica si un profesor con el DNI proporcionado ya existe en el instituto.
     * @param dni El DNI del profesor.
     * @return true si el profesor con ese DNI ya existe, false en caso contrario.
     * @throws IllegalArgumentException si el DNI es nulo o vacío.
     */
    public boolean existeDniProfesor(String dni) {
        if (dni == null || dni.isEmpty()) {
            throw new IllegalArgumentException("El DNI no puede ser nulo o vacio");
        }
        return existeDni(dni, profesores);
    }

    /**
     * Verifica si un conserje con el DNI proporcionado ya existe en el instituto.
     * @param dni El DNI del conserje.
     * @return true si el conserje con ese DNI ya existe, false en caso contrario.
     * @throws IllegalArgumentException si el DNI es nulo o vacío.
     */
    public boolean existeDniConserje(String dni) {
        if (dni == null || dni.isEmpty()) {
            throw new IllegalArgumentException("El DNI no puede ser nulo o vacio");
        }
        return existeDni(dni, conserjes);
    }

    /**
     * Método privado que verifica si el DNI proporcionado ya existe en el arreglo de personas.
     * @param dni El DNI de la persona a verificar.
     * @param personas El arreglo de personas (alumnos, profesores o conserjes).
     * @return true si la persona con el DNI existe, false en caso contrario.
     */
    private boolean existeDni(String dni, Persona[] personas) {
        if (dni == null || dni.isEmpty()) {
            throw new IllegalArgumentException("El DNI no puede ser nulo o vacio");
        }
        boolean existe = false;
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null && dni.equals(personas[i].getDni())) { // Verifica si el DNI coincide.
                System.out.println("Error DNI existente");
                existe = true;
            }
        }
        return existe;
    }

    /**
     * Método para buscar a un alumno por su DNI.
     * @param dni El DNI del alumno a buscar.
     * @return El índice del alumno en el arreglo si se encuentra, -1 si no se encuentra.
     * @throws IllegalArgumentException si el DNI es nulo o vacío.
     */
    public int buscarAlumno(String dni) {
        if (dni == null || dni.isEmpty()) {
            throw new IllegalArgumentException("El DNI no puede ser nulo o vacio");
        }
        return buscarPersonas(dni, alumnos, totalAlumnos);
    }

    /**
     * Método para buscar a un conserje por su DNI.
     * @param dni El DNI del conserje a buscar.
     * @return El índice del conserje en el arreglo si se encuentra, -1 si no se encuentra.
     * @throws IllegalArgumentException si el DNI es nulo o vacío.
     */
    public int buscarConserje(String dni) {
        if (dni == null || dni.isEmpty()) {
            throw new IllegalArgumentException("El DNI no puede ser nulo o vacio");
        }
        return buscarPersonas(dni, conserjes, totalConserjes);
    }

    /**
     * Método para buscar a un profesor por su DNI.
     * @param dni El DNI del profesor a buscar.
     * @return El índice del profesor en el arreglo si se encuentra, -1 si no se encuentra.
     * @throws IllegalArgumentException si el DNI es nulo o vacío.
     */
    public int buscarProfesor(String dni) {
        if (dni == null || dni.isEmpty()) {
            throw new IllegalArgumentException("El DNI no puede ser nulo o vacio");
        }
        return buscarPersonas(dni, profesores, totalProfesores);
    }

    /**
     * Método privado que busca una persona por su DNI en un arreglo dado.
     * @param dni El DNI de la persona a buscar.
     * @param personas El arreglo de personas (alumnos, profesores o conserjes).
     * @param totalActual El número actual de personas en el arreglo.
     * @return El índice de la persona en el arreglo si se encuentra, -1 si no se encuentra.
     */
    public int buscarPersonas(String dni, Persona[] personas, int totalActual) {
        if (dni == null || dni.isEmpty()) {
            throw new IllegalArgumentException("El DNI no puede ser nulo o vacio");
        }
        int posicion = -1;
        int i = 0;
        while (i != totalActual && posicion == -1) {
            if (personas[i] != null && personas[i].getDni().equals(dni)) {
                posicion = i; // Si se encuentra el DNI, se guarda la posición.
            } else {
                i++;
            }
        }
        return posicion;
    }

    /**
     * Método para mostrar la información de las personas en un arreglo.
     * @param personas El arreglo de personas (alumnos, profesores o conserjes).
     * @param totalActual El número actual de personas en el arreglo.
     * @return Una cadena de texto con la información de las personas.
     */
    public String mostrarPersona(Persona[] personas, int totalActual) {
        StringBuilder salida = new StringBuilder();
        if (personas[0] == null || totalActual == 0) {
            salida.append("Vacio"); // Si no hay personas, se muestra "Vacio".
        } else {
            salida = new StringBuilder(String.format("%-10s%-10s%-10s", "dni", "nombre", "edad"));
            for (int i = 0; i < personas.length; i++) {
                if (personas[i] != null) {
                    salida.append("\n");
                    salida.append(String.format("%-10s%-10s%-10s", personas[i].getDni(), personas[i].getNombre(), personas[i].getEdad()));
                }
            }
        }
        return salida.toString();
    }

    /**
     * Método para mostrar todos los alumnos del instituto.
     * @return Una cadena con la información de todos los alumnos.
     */
    public String mostrarAlumno() {
        return mostrarPersona(alumnos, totalAlumnos);
    }

    /**
     * Método para mostrar todos los profesores del instituto.
     * @return Una cadena con la información de todos los profesores.
     */
    public String mostrarProfesor() {
        return mostrarPersona(profesores, totalProfesores);
    }

    /**
     * Método para mostrar todos los conserjes del instituto.
     * @return Una cadena con la información de todos los conserjes.
     */
    public String mostrarConserje() {
        return mostrarPersona(conserjes, totalConserjes);
    }

    /**
     * Elimina una persona de un arreglo en la posición indicada.
     * @param personas El arreglo de personas (alumnos, profesores o conserjes).
     * @param posicion La posición de la persona a eliminar.
     * @param totalActual El número actual de personas en el arreglo.
     * @throws IllegalArgumentException si la posición es inválida.
     */
    private void borrarPersona(Persona[] personas, int posicion, int totalActual) {
        if (posicion < 0 || posicion >= totalActual) {
            throw new IllegalArgumentException("Posicion invalida para borrar");
        }
        for (int i = posicion; i < totalActual - 1; i++) {
            personas[i] = personas[i + 1]; // Mueve las personas hacia arriba en el arreglo.
        }
        personas[totalActual - 1] = null; // Elimina la última persona.
    }

    /**
     * Elimina a un profesor del instituto usando su DNI.
     * @param dni El DNI del profesor a eliminar.
     */
    public void borrarProfesor(String dni) {
        int posicion = buscarProfesor(dni);
        borrarPersona(profesores, posicion, totalProfesores);
        totalProfesores--;
    }

    /**
     * Elimina a un alumno del instituto usando su DNI.
     * @param dni El DNI del alumno a eliminar.
     */
    public void borrarAlumno(String dni) {
        int indice = buscarAlumno(dni);
        borrarPersona(alumnos, indice, totalAlumnos);
        totalAlumnos--;
    }

    /**
     * Elimina a un conserje del instituto usando su DNI.
     * @param dni El DNI del conserje a eliminar.
     */
    public void borrarConserje(String dni) {
        int indice = buscarConserje(dni);
        borrarPersona(conserjes, indice, totalConserjes);
        totalConserjes--;
    }

    /**
     * Modifica los datos de una persona en el arreglo correspondiente.
     * @param personas El arreglo de personas (alumnos, profesores o conserjes).
     * @param persona La persona con los nuevos datos.
     * @param totalActual El número actual de personas en el arreglo.
     * @throws IllegalArgumentException si la persona es nula.
     */
    private void modificarPersona(Persona[] personas, Persona persona, int totalActual) {
        if (persona == null) {
            throw new IllegalArgumentException("La persona no puede ser nula");
        }
        for (int i = 0; i < personas.length; i++) {
            if (persona.getDni().equals(personas[i].getDni())) {
                personas[i] = persona; // Reemplaza la persona en el arreglo.
            }
        }
    }

    /**
     * Modifica los datos de un alumno en el instituto.
     * @param alumno El alumno con los nuevos datos.
     * @throws IllegalArgumentException si el alumno es nulo.
     */
    public void modificarAlumno(Alumno alumno) {
        if (alumno == null) {
            throw new IllegalArgumentException("El alumno no puede ser nulo");
        }
        modificarPersona(alumnos, alumno, totalAlumnos);
    }

    /**
     * Modifica los datos de un profesor en el instituto.
     * @param profesor El profesor con los nuevos datos.
     * @throws IllegalArgumentException si el profesor es nulo.
     */
    public void modificarProfesor(Profesor profesor) {
        if (profesor == null) {
            throw new IllegalArgumentException("El profesor no puede ser nulo");
        }
        modificarPersona(profesores, profesor, totalProfesores);
    }

    /**
     * Modifica los datos de un conserje en el instituto.
     * @param conserje El conserje con los nuevos datos.
     * @throws IllegalArgumentException si el conserje es nulo.
     */
    public void modificarConserje(Conserje conserje) {
        if (conserje == null) {
            throw new IllegalArgumentException("El conserje no puede ser nulo");
        }
        modificarPersona(conserjes, conserje, totalConserjes);
    }
}
