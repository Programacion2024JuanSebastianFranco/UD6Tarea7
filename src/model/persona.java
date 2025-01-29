package model;

public class persona {

    private String dni;
    private String nombre;
    private int edad;


    // Constructor
    public persona(String dni, String nombre, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
    }

    public persona() {
    }

    // Setters y Getters
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        if (validarNIF(dni)) {
            this.dni = dni;
        } else {
            this.dni = "SinDNI";
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }



    // Metodos

    public static boolean validarNIF(String nif) {
        boolean validacion = true;

        // Comprobar longitud
        if (nif.length() != 9) {
            validacion = false;
        }

        // Comprobar que los primeros 8 caracteres sean dígitos
        for (int i = 0; i < 8 && validacion; i++) {
            if (!Character.isDigit(nif.charAt(i))) {
                validacion = false;
            }
        }

        // Validar la letra del NIF
        if (validacion) {
            char caracter = nif.charAt(8);
            if (!Character.isLetter(caracter)) {
                validacion = false;
            }

            String letrasValidas = "TRWAGMYFPDXBNJZSQVHLCKE";
            String num = nif.substring(0, 8);
            int numero = Integer.parseInt(num);
            char letraValida = letrasValidas.charAt(numero % 23);

            if (Character.toUpperCase(caracter) != letraValida) {
                validacion = false;
            }
        }

        return validacion;
    }



    // Sobrescribir el método equals para comparar personas por su DNI
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || !(obj instanceof persona)) {
            return false;
        }

        persona otraPersona = (persona) obj;
        return this.dni.equals(otraPersona.dni);
    }



    @Override
    public String toString() {
        return "persona{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
