package org.mgobea.poointerfacerepository.modelo;

public class ClientePremium extends Cliente implements Comparable<ClientePremium> {

    public ClientePremium(String nombre, String apellido) {
        super(nombre, apellido);
    }

    @Override
    public int compareTo(ClientePremium o) {
        return this.getId().compareTo(o.getId());
    }
}
