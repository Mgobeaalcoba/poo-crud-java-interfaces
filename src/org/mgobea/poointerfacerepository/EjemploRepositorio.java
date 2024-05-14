package org.mgobea.poointerfacerepository;

import org.mgobea.poointerfacerepository.modelo.Cliente;
import org.mgobea.poointerfacerepository.repositorio.*;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {

        ClienteListRepositorio repo = new ClienteListRepositorio(); // Le doy la mayor abstracción posible a mi repositorio para ganar escalabilidad en el CRUD.
        repo.crear(new Cliente("Nicole", "Fernandez"));
        repo.crear(new Cliente("Mariano", "Gobea Alcoba"));
        repo.crear(new Cliente("Lisandro", "Raccio Fernandez"));
        repo.crear(new Cliente("Lautaro", "Gobea Fernandez"));

        // ¿Por qué no funciona el método crear?
        // Porque el método crear no está implementado en la clase ClienteListRepositorio.

        List<Cliente> listRepo = repo.listar();
        for (Cliente cliente : listRepo) {
            System.out.println(cliente);
        }

        System.out.println();
        Cliente cli = new Cliente("Mariano", "Gobea");
        cli.setId(1);
        System.out.println(cli);

        System.out.println();
        repo.editar(cli);
        repo.crear(new Cliente("Jacinto", "Pichimahuida"));

        listRepo.forEach(System.out::println);

        System.out.println();
        repo.eliminar(6);

        listRepo.forEach(System.out::println);

        repo.crear(new Cliente("Jacinto", "Pichimahuida"));
        List<Cliente> listRepo2 = ((OrdenableRepositorio) repo).listar("id", Direccion.DESC); // Tengo que castear porque lo instancie como Crud Repositorio. Dsp de heredar las interfaces no necesito más castear

        System.out.println();
        listRepo2.forEach(System.out::println);

        List<Cliente> listRepo3 = ((PaginableRepositorio) repo).listar(1, 3); // El hasta no se incluye

        System.out.println();
        listRepo3.forEach(System.out::println);

        // Edito trayendo el Cliente por id
        System.out.println();
        Cliente jacinto = repo.porId(7);
        jacinto.setNombre("Manuel");
        jacinto.setApellido("Pichimahuida");
        repo.editar(jacinto);

        listRepo.forEach(System.out::println);
        System.out.println();
        listRepo2.forEach(System.out::println);
    }
}
