package org.mgobea.poointerfacerepository.repositorio;

import org.mgobea.poointerfacerepository.modelo.Cliente;

import java.util.List;

public interface OrdenableRepositorio {
    List<Cliente> listar(String campo, Direccion dir);
}
