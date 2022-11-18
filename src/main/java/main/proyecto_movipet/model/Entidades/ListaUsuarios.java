package main.proyecto_movipet.model.Entidades;

import java.util.LinkedList;

public class ListaUsuarios extends Usuario {

    private  LinkedList<Usuario> listaUsuarios;

    public ListaUsuarios(LinkedList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public LinkedList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(LinkedList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    @Override
    public String toString() {
        return  "-------------------------------------- LISTA DE USUARIOS MOVIPET -------------------------------------- " + "\n" +
                listaUsuarios + "\n";
    }
}
