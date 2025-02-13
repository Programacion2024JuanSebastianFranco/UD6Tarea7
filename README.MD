# Juan Sebastian Franco 
## 1K DAM

---

## 1. 
Clase base para excepciones: Throwable (normalmente Exception o RuntimeException)
    
    

---

## 2. 
Excepción por null: NullPointerException

---

## 3. 
Codigo con error "NullPointerException"

```java
    try {
    System.out.println(arrayString[3].length());
    } catch (NullPointerException e) {
    System.out.println("Error: Objeto null.");
    }
    
```

---

## 4. 
Codigo con error "NumberFormatException"

```java
    try {
    int aux2 = Integer.parseInt(aux);
    } catch (NumberFormatException e) {
    System.out.println("Error: No es un numero.");
    }
```

---

    5. Errores en el codigo:

    a. NumberFormatException (Integer.parseInt("Test")).
    ArithmeticException (division entre 0)

    b. Son unchecked exceptions (RuntimeException).

---

## 6. 
```java
    public class Excepciones {
    public static void metodo1() {
        System.out.println(3 / 0);
    }

    public static void metodo2() {
        int numero = Integer.parseInt("Texto");
    }

    b. 
    public static void main(String[] args) {
        try {
            metodo1();
        } catch (ArithmeticException e) {
            System.out.println("Error: Division por cero.");
        }

        try {
            metodo2();
        } catch (NumberFormatException e) {
            System.out.println("Error: No es un numero.");
        }
    }
}
```
    
---

## 7. 
```java
    import java.util.Scanner;

    public class Ejercicio6 {
        static Scanner sc = new Scanner(System.in);

        public static void main(String[] args) {
            double[] valores = {9.83, 4.5, -3.06, 0.06, 2.52, -11.3, 7.60, 3.00, -30.4, 105.2};

            for (double valor : valores) {
                System.out.printf("%.2f ", valor);
            }

            try {
                System.out.println("Posicion a modificar: ");
                int posicion = Integer.parseInt(sc.nextLine());

                if (posicion < 0 || posicion >= valores.length) {
                    throw new IndexOutOfBoundsException();
                }

                System.out.println("Nuevo valor: ");
                valores[posicion] = sc.nextDouble();

                for (double valor : valores) {
                    System.out.printf("%.2f ", valor);
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Numero invalido");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Error: Posicion fuera de rango");
            } catch (InputMismatchException e) {
                System.out.println("Error: Entrada invalida");
            } 
        }
    }
   ```

