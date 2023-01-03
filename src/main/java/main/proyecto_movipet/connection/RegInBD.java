package main.proyecto_movipet.connection;

import javafx.scene.control.Alert;
import main.proyecto_movipet.model.Entidades.Usuario;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegInBD {
    Conexion conexion = Conexion.getInstance();

        public boolean registrarUsuario(Usuario usuario){
            try {
                FileWriter myWriter = new FileWriter("src\\main\\java\\main\\proyecto_movipet\\sesion\\user_sesion.txt");
                String cedula = String.valueOf(usuario.getCedula());
                myWriter.write(cedula);
                myWriter.close();
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
                    return true;
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            return false;
        }
}
