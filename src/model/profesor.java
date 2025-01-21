package model;

public class profesor extends persona{

    private int sueldo;

    public profesor(String dni, String nombre, int edad, int sueldo) {
        super(dni, nombre, edad);
        this.sueldo = sueldo;
    }


    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        if (sueldo >= 0){
            this.sueldo = sueldo;
        } else {
            this.sueldo = 0;
        }
    }

    @Override
    public String toString() {
        return "profesor{" +
                "sueldo=" + sueldo +
                '}';
    }
}
