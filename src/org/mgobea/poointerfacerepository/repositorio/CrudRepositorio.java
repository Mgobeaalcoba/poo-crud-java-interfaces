package org.mgobea.poointerfacerepository.repositorio;

import java.util.List;

public interface CrudRepositorio<T> {
    List<T> listar();

    T porId(Integer id);

    void crear(T objeto);

    void editar(T objeto);

    void eliminar(Integer id);
}
