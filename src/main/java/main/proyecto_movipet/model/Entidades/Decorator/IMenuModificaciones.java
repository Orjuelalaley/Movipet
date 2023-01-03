package main.proyecto_movipet.model.Entidades.Decorator;


import main.proyecto_movipet.model.Entidades.ListaUsuarios;

public interface IMenuModificaciones {

    public void modificarLogin (ListaUsuarios listaUsuarios, String idBuscar, String nomUsuarioNuevo, String contraNueva);

}
