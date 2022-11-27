package main.proyecto_movipet.connection;

import javafx.scene.control.Alert;
import main.proyecto_movipet.Utility.TransportInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegPetInBD {
    Conexion conexion = Conexion.getInstance();
    public void registrarMascota(String nombre, String Apodo, String Tipo,String raza, int edad, String comentarios) {

        try {
            TransportInfo te = new TransportInfo();
            te.transportInfo(1);
            Connection conectar = conexion.conectar();
            PreparedStatement insertar = conectar.prepareStatement("INSERT INTO movipet_db.mascotas (FK_id,Nombre,Apodo,raza,Tipo,edad,Comentarios) VALUES (?,?,?,?,?,?,?)");
            PreparedStatement getUsuario = conectar.prepareStatement("SELECT * FROM movipet_db.clientes WHERE Cedula = ?");
            insertar.setString(1, getUsuario.toString());
            insertar.setString(1, nombre);
            insertar.setString(2, Apodo);
            insertar.setString(3, Tipo);
            insertar.setString(4, raza);
            insertar.setInt(5, edad);
            insertar.setString(6, comentarios);
            if (insertar.executeUpdate() > 0){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Registro");
                alert.setHeaderText("Registro exitoso");
                alert.setContentText("El registro de la mascota se ha realizado con éxito");
                alert.showAndWait();
                conexion.cerrarConexion();
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
