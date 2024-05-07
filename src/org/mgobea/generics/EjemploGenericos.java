package org.mgobea.generics;

import org.mgobea.poointerfacerepository.modelo.Cliente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploGenericos {
    public static void main(String[] args) {

        // Java me permite crear objetos genericos, es decir, objetos que pueden contener cualquier tipo de dato
        // List clientes = new ArrayList(); // No se recomienda hacer esto, ya que se pierde el tipado seguro
        Cliente mariano = new Cliente("Mariano", "Gobea"); // Se puede agregar cualquier tipo de objeto
        Cliente Nicole = new Cliente("Nicole", "Fernandez");
        Cliente Lautaro = new Cliente("Lautaro", "Gobea");
        Cliente Lisandro = new Cliente("Lisandro", "Raccio");

        /*
        Cliente mariano = (Cliente) clientes.get(0); // Se debe hacer un cast para recuperar el objeto
        Cliente mariano2 = (Cliente) clientes.iterator().next(); // Se debe hacer un cast para recuperar el objeto
        */

        Cliente[] clientesArray = {mariano, Nicole, Lautaro, Lisandro};

        String saludo1 = "Hola Mundo";
        String saludo2 = "Hola Gente";
        String saludo3 = "Hola Amigos";
        String saludo4 = "Hola a Todos";

        String[] saludosArray = {saludo1, saludo2, saludo3, saludo4};

        List<Cliente> clientes = fromArrayToList(clientesArray); // El método fromArrayToList es un método genérico, por lo que puedo pasarle cualquier tipo de objeto
        clientes.forEach(System.out::println);

        List<String> saludos = fromArrayToList(saludosArray); // En este caso le paso un array de Strings y antes le pasé un array de Clientes
        saludos.forEach(System.out::println);

        // Uso el método sobrecargado que recibe dos arrays de distinto tipo en un sentido:
        List<Cliente> clientes2 = fromArrayToList(clientesArray, saludosArray);

        // Uso el método sobrecargado que recibe dos arrays de distinto tipo en otro sentido:
        List<String> saludos2 = fromArrayToList(saludosArray, clientesArray);
    }

    public static <T> List<T> fromArrayToList(T[] array) {
        return Arrays.asList(array); // El problema de este metodo es que el tipo de lista que devuelve es inmutable. Solo será una Lista de Clientes. Si necesitamos una lista de cualquier otro tipo de objeto, no podremos usar este método. De allí la necesidad de usar Genéricos
        // Reemplazando Cliente por T, el método se vuelve genérico. Debo sumar <T> al principio del método.
    }

    // Método genérico que recibe dos arrays de distinto tipo. Sobrecarga de métodos.
    public static <T, G> List<T> fromArrayToList(T[] array, G[] array2) {
        for (G elemento : array2) {
            System.out.println(elemento);
        }
        return Arrays.asList(array);
        // Explicación detallada de este método estática abajo:
        /*
        El método recibe dos arrays de distinto tipo. El primer array es de tipo T y el segundo array es de tipo G.
        El método recorre el segundo array y muestra por consola cada uno de los elementos.
        El método devuelve una lista de tipo T, que es el primer array.
         */
    }
}
