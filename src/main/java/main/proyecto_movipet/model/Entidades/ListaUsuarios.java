package main.proyecto_movipet.model.Entidades;

import lombok.Data;

import java.util.LinkedList;
@Data

public class ListaUsuarios extends Usuario {

    private  LinkedList<Usuario> listaUsuarios;

    public ListaUsuarios(LinkedList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    @Override
    public String toString() {
        return  "-------------------------------------- LISTA DE USUARIOS MOVIPET -------------------------------------- " + "\n" +
                listaUsuarios + "\n";
    }
}
