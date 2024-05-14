package org.mgobea.poointerfacerepository.repositorio;

import org.mgobea.poointerfacerepository.modelo.Cliente;

import java.util.List;

public interface OrdenableRepositorio<T> {
    List<T> listar(String campo, Direccion dir);

    // Podría ser un método default y permitir que cada implementación lo sobrescriba si es necesario.
    static <T> int ordenar(String campo, T a, T b) {
        int resultado = 0;
        switch (campo) {
            case "id" -> resultado = ((Cliente)a).getId().compareTo(((Cliente)b).getId());
            case "nombre" -> resultado = ((Cliente)a).getNombre().compareTo(((Cliente)b).getNombre());
            case "apellido" -> resultado = ((Cliente)a).getApellido().compareTo(((Cliente)b).getApellido());
        }
        return resultado;
    }
}
