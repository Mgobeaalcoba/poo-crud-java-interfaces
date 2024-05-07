package org.mgobea.poointerfacerepository.repositorio;

import org.mgobea.poointerfacerepository.modelo.Cliente;

import java.util.List;

public interface PaginableRepositorio {
    List<Cliente> listar(int desde, int hasta);
} // ¿Qué significa paginar? Paginar es dividir una lista en partes más pequeñas, para que sea más fácil de manejar y mostrar en una interfaz de usuario. En este caso, el método listar(int desde, int hasta) devuelve una lista de clientes que va desde el índice "desde" hasta el índice "hasta". Esto permite mostrar solo una parte de la lista completa en la interfaz de usuario, lo que facilita la navegación y la visualización de los datos.
