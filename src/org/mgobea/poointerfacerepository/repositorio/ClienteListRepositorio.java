package org.mgobea.poointerfacerepository.repositorio;

import org.mgobea.poointerfacerepository.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

// Transformamos el FullRepositorio en una interface completamente genérica, para que pueda ser utilizada con cualquier tipo de objeto.
// En este caso, la implementamos con el tipo Cliente, pero podría ser cualquier otro tipo de objeto.
public class ClienteListRepositorio extends AbstractaListRepositorio<Cliente> {
    protected List<Cliente> dataSource; // El contenedor de los datos donde vamos a operar

    public ClienteListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public void crear(Cliente cliente) {
        this.dataSource.add(cliente);
    }

    @Override
    public List<Cliente> listar() {
        return this.dataSource;
    }

    @Override
    public Cliente porId(Integer id) {
        Cliente resultado = null;
        for (Cliente cliente : this.dataSource) {
            if (cliente.getId().equals(id)) { // Es un Integer no primitivo por lo que comparo con equals. Es un wrapper.
                resultado = cliente;
                break;
            }
        }
        return resultado;
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
    public List<Cliente> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);
    }

    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        // No quiero que la lista original se ordene, por eso la copio y retorno la copia:
        List<Cliente> listOrdered = new ArrayList<>(this.dataSource);
        listOrdered.sort((a, b) -> {
            int resultado = 0;
            if (dir == Direccion.ASC) {
                resultado = ordenar(campo, a, b);
            } else if (dir == Direccion.DESC) {
                resultado = ordenar(campo, b, a);
            }
            return resultado; // Era una interface funcional, pero como tiene un solo método se puede reemplazar con una lambda function.
        });
        return listOrdered;
    }

    @Override
    public int total() {
        return this.dataSource.size(); // Devuelve el tamaño de mi dataSource. La cantidad de registros.
    }

    private int ordenar(String campo, Cliente a, Cliente b) {
        int resultado = 0;
        switch (campo) {
            case "id" -> resultado = a.getId().compareTo(b.getId());
            case "nombre" -> resultado = a.getNombre().compareTo(b.getNombre());
            case "apellido" -> resultado = a.getApellido().compareTo(b.getApellido());
        }
        return resultado;
    }
}
