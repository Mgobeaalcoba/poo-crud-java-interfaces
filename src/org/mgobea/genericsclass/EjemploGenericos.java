package org.mgobea.genericsclass;

public class EjemploGenericos {
    public static void main(String[] args) {

        Camion<Animal> transporteCaballos = new Camion<>(5);
        transporteCaballos.add(new Animal("Potrillo", "Caballo"));
        transporteCaballos.add(new Animal("Grillo", "Caballo"));
        transporteCaballos.add(new Animal("Soplillo", "Caballo"));
        transporteCaballos.add(new Animal("Topillo", "Caballo"));
        transporteCaballos.add(new Animal("Pillo", "Caballo"));

        // Camión se comporta como un Iterable, por lo que se puede recorrer con un for-each. Sin necesidad de acceder a su atributo objetos.

        // Recorrer los objetos del camión será complejo dado que no se sabe el tipo de objeto que contiene
        for (Animal animal : transporteCaballos) {
            // Se debe hacer un casting a Animal para poder acceder a sus métodos. Caso contrario, solo se podrá acceder a los métodos de Object
            // Animal animal = objeto; // El casting se vuelve innecesario si se usa un camión genérico
            System.out.println(animal.getNombre() + " tipo: " + animal.getTipo());
        }
        System.out.println();

        imprimirCamion(transporteCaballos);

        System.out.println();

        Camion<Maquinaria> transporteMaquinaria = new Camion<>(3);
        transporteMaquinaria.add(new Maquinaria("Excavadora"));
        transporteMaquinaria.add(new Maquinaria("Grúa"));
        transporteMaquinaria.add(new Maquinaria("Bulldozer"));

        for (Maquinaria maquinaria : transporteMaquinaria) {
            // Maquinaria maquinaria = (Maquinaria) objeto;
            System.out.println(maquinaria.getTipo());
        }
        System.out.println();

        imprimirCamion(transporteMaquinaria);

        System.out.println();

        Camion<Automovil> transporteAutomoviles = new Camion<>(4);
        transporteAutomoviles.add(new Automovil("Toyota"));
        transporteAutomoviles.add(new Automovil("Nissan"));
        transporteAutomoviles.add(new Automovil("Chevrolet"));
        transporteAutomoviles.add(new Automovil("Ford"));

        for (Automovil automovil : transporteAutomoviles) {
            // Automovil automovil = (Automovil) objeto;
            System.out.println(automovil.getMarca());
        }
        System.out.println();

        imprimirCamion(transporteAutomoviles);

        System.out.println();

        // Queda poco flexible y se debe hacer casting en cada iteración. Lo que incrementa la posibilidad de errores
    }

    public static <T> void imprimirCamion(Camion<T> camion) {
        for (T objeto : camion) {
            switch (objeto) {
                case Animal animal -> System.out.println(animal.getNombre() + " tipo: " + animal.getTipo());
                case Maquinaria maquinaria -> System.out.println(maquinaria.getTipo());
                case Automovil automovil -> System.out.println(automovil.getMarca());
                case null, default -> System.out.println(objeto);
            }
        }
    }
}
