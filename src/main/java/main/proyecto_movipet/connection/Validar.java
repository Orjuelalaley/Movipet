package main.proyecto_movipet.connection;

import javafx.scene.control.Alert;
import main.proyecto_movipet.model.Entidades.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Validar {
    Conexion conexion = Conexion.getInstance();
    public Usuario validarLogin(String user, String pass) {
        try {
            Connection conectar = conexion.conectar();
            GetPets getPets = new GetPets();
            Usuario usuario = new Usuario();
            PreparedStatement logIn = conectar.prepareStatement("SELECT * FROM movipet_db.clientes WHERE NombreDeUsuario = ? AND Password = ?");
            logIn.setString(1, user);
            logIn.setString(2, pass);
            ResultSet consulta = logIn.executeQuery();
            if (consulta.next()) {
                usuario.setCedula(consulta.getInt("cedula"));
                usuario.setNombre(consulta.getString("Nombre"));
                usuario.setCorreo(consulta.getString("Email"));
                usuario.setGenero(consulta.getString("Genero"));
                usuario.setEdad(consulta.getInt("Edad"));
                usuario.setCelular(consulta.getString("Celular"));
                usuario.setUsuario(consulta.getString("NombreDeUsuario"));
                usuario.setPassword(consulta.getString("Password"));
                getPets.AsignarMascotas(usuario);
                System.out.println(usuario);
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Bienvenido");
                alerta.setHeaderText("Bienvenido " + usuario.getNombre());
                alerta.showAndWait();
                conexion.cerrarConexion();
                return usuario;
            } else {
                Alert alerta = new Alert(Alert.AlertType.WARNING);
                alerta.setTitle("Error");
                alerta.setHeaderText("El usuario o la contraseña son incorrectos");
                alerta.showAndWait();
                conexion.cerrarConexion();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
