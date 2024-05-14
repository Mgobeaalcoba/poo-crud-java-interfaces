package org.mgobea.genericsclass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Convierto a Camión en un iterable genérico
public class Camion<T> implements Iterable<T> {
    private final List<T> objetos;
    private final int max;

    public Camion(int max) {
        this.max = max;
        this.objetos = new ArrayList<>();
    }

    public void add(T objeto) {
        if (this.objetos.size() < this.max) {
            this.objetos.add(objeto);
        } else {
            throw new RuntimeException("El camión está lleno");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return this.objetos.iterator();
    }
}
