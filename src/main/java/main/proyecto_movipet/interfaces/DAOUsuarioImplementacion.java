package main.proyecto_movipet.interfaces;

import javafx.scene.control.Alert;
import main.proyecto_movipet.connection.Conexion;
import main.proyecto_movipet.model.Entidades.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DAOUsuarioImplementacion implements DAOUsuario {
    Conexion conexion = Conexion.getInstance();

    @Override
    public boolean iniciarSesion(String user, String password) {
        try {
            Connection conectar = conexion.conectar();
            Usuario usuario = new Usuario();
            PreparedStatement logIn = conectar.prepareStatement("SELECT * FROM movipet_db.clientes WHERE NombreDeUsuario = ? AND Password = ?");
            logIn.setString(1,user);
            logIn.setString(2, password);
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
                System.out.println(usuario);
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Bienvenido");
                alerta.setHeaderText("Bienvenido " + usuario.getNombre());
                alerta.showAndWait();
                conexion.cerrarConexion();
                return true;
            }else {
                Alert alerta = new Alert(Alert.AlertType.WARNING);
                alerta.setTitle("Error");
                alerta.setHeaderText("El usuario o la contraseña son incorrectos");
                alerta.showAndWait();
                conexion.cerrarConexion();
                return false;
            }
        } catch (Exception e ) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public void registrar(Usuario usuario) {
        try {
            Connection conectar = conexion.conectar();
            PreparedStatement insertar = conectar.prepareStatement("INSERT INTO movipet_db.clientes VALUES (?,?,?,?,?,?,?,?)");
            insertar.setInt(1, usuario.getCedula());
            insertar.setString(2, usuario.getNombre());
            insertar.setString(3, usuario.getCorreo());
            insertar.setString(4, usuario.getGenero());
            insertar.setInt(5, usuario.getEdad());
            insertar.setString(6, usuario.getCelular());
            insertar.setString(7, usuario.getUsuario());
            insertar.setString(8, usuario.getPassword());
            if (insertar.executeUpdate() > 0){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Registro");
                alert.setHeaderText("Registro exitoso");
                alert.setContentText("El registro se ha realizado con éxito");
                alert.showAndWait();
                conexion.cerrarConexion();
            }
        } catch (Exception e ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Registro");
            alert.setHeaderText("Registro fallido");
            alert.setContentText("El ID ya se encuentra en uso");
            alert.showAndWait();
        }
    }
}
