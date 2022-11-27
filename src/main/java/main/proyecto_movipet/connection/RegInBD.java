package main.proyecto_movipet.connection;

import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegInBD {
    Conexion conexion = Conexion.getInstance();

        public void registrarUsuario(int cedula, String nombre, String correo,String genero,int edad,String celular,String usuario, String password) {
            try {
                Connection conectar = conexion.conectar();
                PreparedStatement insertar = conectar.prepareStatement("INSERT INTO movipet_db.clientes VALUES (?,?,?,?,?,?,?,?)");
                insertar.setInt(1, cedula);
                insertar.setString(2, nombre);
                insertar.setString(3, correo);
                insertar.setString(4, genero);
                insertar.setInt(5,edad);
                insertar.setString(6, celular);
                insertar.setString(7, usuario);
                insertar.setString(8, password);
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
                alert.setContentText("El ID o el nombre de usuario ya se encuentra en uso");
                alert.showAndWait();
            }
        }
}
