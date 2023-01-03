package main.proyecto_movipet.interfaces;

import main.proyecto_movipet.model.Entidades.Usuario;

public interface DAOUsuario {
    public boolean iniciarSesion(String usuario, String password);
    public boolean registrar(Usuario usuario);
    public boolean buscar(Usuario emp);
}
