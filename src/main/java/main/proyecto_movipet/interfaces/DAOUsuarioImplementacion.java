package main.proyecto_movipet.interfaces;

import main.proyecto_movipet.connection.RegInBD;
import main.proyecto_movipet.connection.UserSearch;
import main.proyecto_movipet.connection.Validar;
import main.proyecto_movipet.model.Entidades.Usuario;


public class DAOUsuarioImplementacion implements DAOUsuario {
    @Override
    public boolean iniciarSesion(String user, String password) {
        Validar validarConection = new Validar();
        Usuario usuario = validarConection.validarLogin(user, password);
        return usuario != null;
    }

    @Override
    public boolean registrar(Usuario usuario) {
        RegInBD regInBD = new RegInBD();
        return regInBD.registrarUsuario(usuario);
    }

    @Override
    public boolean buscar(Usuario usuario) {
        UserSearch userSearch = new UserSearch();
         return  userSearch.buscarUsuario(usuario.getCedula());
    }
}
