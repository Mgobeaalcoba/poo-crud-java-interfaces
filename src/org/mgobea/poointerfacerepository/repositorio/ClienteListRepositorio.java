package org.mgobea.poointerfacerepository.repositorio;

import org.mgobea.poointerfacerepository.modelo.Cliente;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClienteListRepositorio implements CrudRepositorio, OrdenableRepositorio, PaginableRepositorio{
    private List<Cliente> dataSource; // El contenedor de los datos donde vamos a operar

    public ClienteListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<Cliente> listar() {
        return this.dataSource;
    }

    @Override
    public Cliente porId(Integer id) {
        Cliente resultado = null;
        for(Cliente cliente: this.dataSource) {
            if(cliente.getId().equals(id)) { // Es un Integer no primitivo por lo que comparo con equals. Es un wrapper.
                resultado = cliente;
                break;
            }
        }
        return resultado;
    }

    @Override
    public void crear(Cliente cliente) {
        this.dataSource.add(cliente);
    }

    @Override
    public void editar(Cliente cliente) {
        Cliente cli = this.porId(cliente.getId());
        cli.setId(cliente.getId());
        cli.setApellido(cliente.getApellido());
        cli.setNombre(cliente.getNombre());
    }

    @Override
    public void eliminar(Integer id) {
        Cliente cli = this.porId(id);
        this.dataSource.remove(cli);
    }

    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        dataSource.sort((a, b) -> {
            int resultado = 0;
            if(dir == Direccion.ASC) {
                switch (campo) {
                    case "id" -> resultado = a.getId().compareTo(b.getId());
                    case "nombre" -> resultado = a.getNombre().compareTo(b.getNombre());
                    case "apellido" -> resultado = a.getApellido().compareTo(b.getApellido());
                }
            } else if (dir == Direccion.DESC) {
                switch (campo) {
                    case "id" -> resultado = b.getId().compareTo(a.getId());
                    case "nombre" -> resultado = b.getNombre().compareTo(a.getNombre());
                    case "apellido" -> resultado = b.getApellido().compareTo(a.getApellido());
                }
            }
            return resultado; // Era una interface funcional, pero como tiene un solo método se puede reemplazar con una lambda function.
        });
        return this.dataSource;
    }

    @Override
    public List<Cliente> listar(int desde, int hasta) {
        return List.of();
    }
    // Se llama List porque manejará datos desde una lista, pero podría hacerlo desde cualquier fuente de datos
}
