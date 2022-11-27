package main.proyecto_movipet.interfaces;

import javafx.scene.control.Alert;
import main.proyecto_movipet.connection.Conexion;
import main.proyecto_movipet.connection.RegInBD;
import main.proyecto_movipet.connection.Validar;
import main.proyecto_movipet.model.Entidades.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DAOUsuarioImplementacion implements DAOUsuario {
    Conexion conexion = Conexion.getInstance();

    @Override
    public boolean iniciarSesion(String user, String password) {
        Validar validarConection = new Validar();
        Usuario usuario = validarConection.validarLogin(user, password);
        if (usuario != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void registrar(int cedula, String nombre, String correo,String genero,int edad,String celular,String usuario, String password) {
        RegInBD regInBD = new RegInBD();
        regInBD.registrarUsuario(cedula, nombre, correo, genero, edad, celular, usuario, password);
    }
}
