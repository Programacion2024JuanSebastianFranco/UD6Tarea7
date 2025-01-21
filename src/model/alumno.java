package model;

public class alumno extends persona{

    private curso curso;

    public alumno(String dni, String nombre, int edad, model.curso curso) {
        super(dni, nombre, edad);
        this.curso = curso;
    }


    @Override
    public String toString() {
        return "alumno{" +
                "curso=" + curso +
                '}';
    }
}
