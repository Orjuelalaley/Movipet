package main.proyecto_movipet.interfaces;

import main.proyecto_movipet.model.Entidades.Usuario;

public interface DAOUsuario {
    public boolean iniciarSesion(String usuario, String password);
    public void registrar(int cedula, String nombre, String correo,String genero,int edad,String celular,String usuario, String password);
}
