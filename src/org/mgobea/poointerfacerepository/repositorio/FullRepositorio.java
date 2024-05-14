package org.mgobea.poointerfacerepository.repositorio;

import java.util.List;

public interface FullRepositorio<T> extends CrudRepositorio<T>, OrdenableRepositorio<T>, PaginableRepositorio<T>, ContableRepositorio {
    @Override
    List<T> listar();

    @Override
    T porId(Integer id);

    @Override
    void crear(T objeto);

    @Override
    void eliminar(Integer id);

    @Override
    void editar(T objeto);

    @Override
    List<T> listar(String campo, Direccion dir);

    @Override
    List<T> listar(int desde, int hasta);

    @Override
    int total();
}
