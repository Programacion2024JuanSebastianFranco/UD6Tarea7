package model;

/**
 * Clase Instituto que gestiona los alumnos, profesores y conserjes de una institución educativa.
 * Permite realizar operaciones como agregar, modificar, eliminar y consultar personas (alumnos, profesores, conserjes).
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
     */
    public void nuevoAlumno(Alumno alumno) {
        nuevaPersona(alumnos, alumno, totalAlumnos, max_alumnos);
        totalAlumnos++;
    }

    /**
     * Método para agregar un nuevo profesor al instituto.
     * @param profesor El objeto Profesor a agregar.
     */
    public void nuevoProfesor(Profesor profesor) {
        nuevaPersona(profesores, profesor, totalProfesores, max_profesores);
        totalProfesores++;
    }

    /**
     * Método para agregar un nuevo conserje al instituto.
     * @param conserje El objeto Conserje a agregar.
     */
    public void nuevoConserje1(Conserje conserje) {
        nuevaPersona(conserjes, conserje, totalConserjes, max_conserje);
        totalConserjes++;
    }

    /**
     * Método general para agregar una nueva persona al arreglo correspondiente.
     * @param personas El arreglo de personas (alumnos, profesores o conserjes).
     * @param persona La persona a agregar (Alumno, Profesor o Conserje).
     * @param totalActual El número actual de personas en el arreglo.
     * @param max El límite máximo de personas en el arreglo.
     */
    public void nuevaPersona(Persona[] personas, Persona persona, int totalActual, int max) {
        if (totalActual < max) {
            persona.leerDatos(); // Método para leer los datos de la persona.
            personas[totalActual] = persona; // Se agrega la persona al arreglo.
        } else {
            System.out.println("No queda espacio"); // Si ya se alcanzó el límite máximo, se muestra un mensaje de error.
        }
    }

    /**
     * Método para verificar si un alumno con el DNI proporcionado ya existe en el instituto.
     * @param dni El DNI del alumno.
     * @return true si el alumno con ese DNI ya existe, false en caso contrario.
     */
    public boolean existeDniAlumno(String dni) {
        return existeDni(dni, alumnos); // Llama al método privado que verifica la existencia de un DNI.
    }

    /**
     * Método para verificar si un profesor con el DNI proporcionado ya existe en el instituto.
     * @param dni El DNI del profesor.
     * @return true si el profesor con ese DNI ya existe, false en caso contrario.
     */
    public boolean existeDniProfesor(String dni) {
        return existeDni(dni, profesores); // Llama al método privado que verifica la existencia de un DNI.
    }

    /**
     * Método para verificar si un conserje con el DNI proporcionado ya existe en el instituto.
     * @param dni El DNI del conserje.
     * @return true si el conserje con ese DNI ya existe, false en caso contrario.
     */
    public boolean existeDniConserje(String dni) {
        return existeDni(dni, conserjes); // Llama al método privado que verifica la existencia de un DNI.
    }

    /**
     * Método privado que verifica si el DNI proporcionado ya existe en el arreglo de personas.
     * @param dni El DNI de la persona a verificar.
     * @param personas El arreglo de personas (alumnos, profesores o conserjes).
     * @return true si la persona con el DNI existe, false en caso contrario.
     */
    private boolean existeDni(String dni, Persona[] personas) {
        boolean existe = false;
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null && dni.equals(personas[i].getDni())) { // Verifica si el DNI coincide.
                System.out.println("Error, DNI existente"); // Si el DNI ya existe, se muestra un mensaje de error.
                existe = true;
            }
        }
        return existe; // Retorna el resultado de la verificación.
    }

    /**
     * Método para buscar a un alumno por su DNI.
     * @param dni El DNI del alumno a buscar.
     * @return El índice del alumno en el arreglo si se encuentra, -1 si no se encuentra.
     */
    public int buscarAlumno(String dni) {
        return buscarPersonas(dni, alumnos, totalAlumnos); // Llama al método privado para buscar a una persona por su DNI.
    }

    /**
     * Método para buscar a un conserje por su DNI.
     * @param dni El DNI del conserje a buscar.
     * @return El índice del conserje en el arreglo si se encuentra, -1 si no se encuentra.
     */
    public int buscarConserje(String dni) {
        return buscarPersonas(dni, conserjes, totalConserjes); // Llama al método privado para buscar a una persona por su DNI.
    }

    /**
     * Método para buscar a un profesor por su DNI.
     * @param dni El DNI del profesor a buscar.
     * @return El índice del profesor en el arreglo si se encuentra, -1 si no se encuentra.
     */
    public int buscarProfesor(String dni) {
        return buscarPersonas(dni, profesores, totalProfesores); // Llama al método privado para buscar a una persona por su DNI.
    }

    /**
     * Método privado que busca una persona por su DNI en un arreglo dado.
     * @param dni El DNI de la persona a buscar.
     * @param personas El arreglo de personas (alumnos, profesores o conserjes).
     * @param totalActual El número actual de personas en el arreglo.
     * @return El índice de la persona en el arreglo si se encuentra, -1 si no se encuentra.
     */
    public int buscarPersonas(String dni, Persona[] personas, int totalActual) {
        int posicion = -1;
        int i = 0;
        while (i != totalActual && posicion == -1) {
            if (personas[i] != null && personas[i].getDni().equals(dni)) {
                posicion = i; // Si se encuentra el DNI, se guarda la posición.
            } else {
                i++;
            }
        }
        return posicion; // Retorna la posición de la persona o -1 si no se encuentra.
    }

    /**
     * Método que muestra la información de todas las personas en un arreglo.
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
        return salida.toString(); // Retorna la información formateada de todas las personas.
    }

    /**
     * Método para mostrar la información de los alumnos.
     * @return Una cadena de texto con la información de los alumnos.
     */
    public String mostrarAlumno() {
        return mostrarPersona(alumnos, totalAlumnos); // Llama a mostrarPersona para los alumnos.
    }

    /**
     * Método para mostrar la información de los profesores.
     * @return Una cadena de texto con la información de los profesores.
     */
    public String mostrarProfesor() {
        return mostrarPersona(profesores, totalProfesores); // Llama a mostrarPersona para los profesores.
    }

    /**
     * Método para mostrar la información de los conserjes.
     * @return Una cadena de texto con la información de los conserjes.
     */
    public String mostrarConserje() {
        return mostrarPersona(conserjes, totalConserjes); // Llama a mostrarPersona para los conserjes.
    }

    /**
     * Método privado que elimina una persona de un arreglo dado.
     * @param personas El arreglo de personas (alumnos, profesores o conserjes).
     * @param posicion La posición de la persona a eliminar.
     * @param totalActual El número actual de personas en el arreglo.
     */
    private void borrarPersona(Persona[] personas, int posicion, int totalActual) {
        if (posicion >= 0 && posicion < totalActual) {
            for (int i = posicion; i < totalActual - 1; i++) {
                personas[i] = personas[i + 1]; // Desplaza las personas hacia la izquierda.
            }
            personas[totalActual - 1] = null; // Borra la última persona.
        }
    }

    /**
     * Método para borrar un profesor del instituto usando su DNI.
     * @param dni El DNI del profesor a eliminar.
     */
    public void borrarProfesor(String dni) {
        int posicion = buscarProfesor(dni); // Busca al profesor por su DNI.
        borrarPersona(profesores, posicion, totalProfesores); // Llama a borrarPersona para eliminarlo.
        totalProfesores--; // Decrementa el contador de profesores.
    }

    /**
     * Método para borrar un alumno del instituto usando su DNI.
     * @param dni El DNI del alumno a eliminar.
     */
    public void borrarAlumno(String dni) {
        int indice = buscarAlumno(dni); // Busca al alumno por su DNI.
        borrarPersona(alumnos, indice, totalAlumnos); // Llama a borrarPersona para eliminarlo.
        totalAlumnos--; // Decrementa el contador de alumnos.
    }

    /**
     * Método para borrar un conserje del instituto usando su DNI.
     * @param dni El DNI del conserje a eliminar.
     */
    public void borrarConserje(String dni) {
        int indice = buscarConserje(dni); // Busca al conserje por su DNI.
        borrarPersona(conserjes, indice, totalConserjes); // Llama a borrarPersona para eliminarlo.
        totalConserjes--; // Decrementa el contador de conserjes.
    }

    /**
     * Método privado que modifica los datos de una persona en el arreglo correspondiente.
     * @param personas El arreglo de personas (alumnos, profesores o conserjes).
     * @param persona La persona con los nuevos datos.
     * @param totalActual El número actual de personas en el arreglo.
     */
    private void modificarPersona(Persona[] personas, Persona persona, int totalActual) {
        for (int i = 0; i < personas.length; i++) {
            if (persona.getDni().equals(personas[i].getDni())) { // Si el DNI coincide, se modifica la persona.
                personas[i] = persona;
            }
        }
    }

    /**
     * Método para modificar los datos de un alumno.
     * @param alumno El objeto Alumno con los nuevos datos.
     */
    public void modificarAlumno(Alumno alumno) {
        modificarPersona(alumnos, alumno, totalAlumnos); // Llama a modificarPersona para los alumnos.
    }

    /**
     * Método para modificar los datos de un profesor.
     * @param profesor El objeto Profesor con los nuevos datos.
     */
    public void modificarProfesor(Profesor profesor) {
        modificarPersona(profesores, profesor, totalProfesores); // Llama a modificarPersona para los profesores.
    }

    /**
     * Método para modificar los datos de un conserje.
     * @param conserje El objeto Conserje con los nuevos datos.
     */
    public void modificarConserje(Conserje conserje) {
        modificarPersona(conserjes, conserje, totalConserjes); // Llama a modificarPersona para los conserjes.
    }
}
