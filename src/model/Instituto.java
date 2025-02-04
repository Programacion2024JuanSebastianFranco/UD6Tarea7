package model;

public class Instituto {
    private final Alumno[] alumnos;
    private final Profesor[] profesores;
    private final Conserje[] conserjes;
    private int totalAlumnos = 0;
    private int totalProfesores = 0;
    private int totalConserjes = 0;

    public Instituto() {
        this.alumnos = new Alumno[3];
        this.profesores = new Profesor[3];
        this.conserjes = new Conserje[3];
    }

    public void nuevoAlumno(Alumno alumno) {
        if (totalAlumnos < alumnos.length) {
            alumnos[totalAlumnos++] = alumno;
        }
    }

    public void nuevoProfesor(Profesor profesor) {
        if (totalProfesores < profesores.length) {
            profesores[totalProfesores++] = profesor;
        }
    }

    public void nuevoConserje(Conserje conserje) {
        if (totalConserjes < conserjes.length) {
            conserjes[totalConserjes++] = conserje;
        }
    }
}
