package org.mgobea.poointerfacerepository.repositorio;

import org.mgobea.poointerfacerepository.modelo.Cliente;

import java.util.List;

public interface FullRepositorio extends CrudRepositorio, OrdenableRepositorio, PaginableRepositorio{
    @Override
    List<Cliente> listar();

    @Override
    Cliente porId(Integer id);

    @Override
    void crear(Cliente cliente);

    @Override
    void eliminar(Integer id);

    @Override
    void editar(Cliente cliente);

    @Override
    List<Cliente> listar(String campo, Direccion dir);

    @Override
    List<Cliente> listar(int desde, int hasta);
}
