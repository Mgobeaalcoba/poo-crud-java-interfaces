package org.mgobea.poointerfacerepository.repositorio;

import java.util.ArrayList;
import java.util.List;

// Transformamos el FullRepositorio en una interface completamente genérica, para que pueda ser utilizada con cualquier tipo de objeto.
// En este caso, la implementamos con el tipo Cliente, pero podría ser cualquier otro tipo de objeto.
public abstract class AbstractaListRepositorio<T> implements FullRepositorio<T> {
    protected List<T> dataSource; // El contenedor de los datos donde vamos a operar

    public AbstractaListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<T> listar() {
        return this.dataSource;
    }

    @Override
    public void crear(T t) {
        this.dataSource.add(t);
    }

    @Override
    public List<T> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);
    }

    @Override
    public int total() {
        return this.dataSource.size(); // Devuelve el tamaño de mi dataSource. La cantidad de registros.
    }

    // Se llama List porque manejará datos desde una lista, pero podría hacerlo desde cualquier fuente de datos
}
