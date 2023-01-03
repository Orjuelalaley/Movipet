package main.proyecto_movipet.connection;

import javafx.scene.control.Alert;
import main.proyecto_movipet.model.Entidades.Mascota;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class RegPetInBD {
    Conexion conexion = Conexion.getInstance();
    public boolean registrarMascota(Mascota mascota){
        try {
            File myObj = new File("src\\main\\java\\main\\proyecto_movipet\\sesion\\user_sesion.txt");
            Scanner myReader = new Scanner(myObj);
            String data = myReader.nextLine();
            int id = Integer.parseInt(data);
            myReader.close();
            Connection conectar = conexion.conectar();
            PreparedStatement insertar = conectar.prepareStatement("INSERT INTO movipet_db.mascotas (nombre, apodo, tipo, raza, edad, comentarios,id_duenio) VALUES (?,?,?,?,?,?,?)");
            insertar.setString(1, mascota.getNombre());
            insertar.setString(2, mascota.getApodo());
            insertar.setString(3, mascota.getTipo());
            insertar.setString(4, mascota.getRaza());
            insertar.setInt(5, mascota.getEdad());
            insertar.setString(6, mascota.getComentarios());
            insertar.setInt(7, id);
            if (insertar.executeUpdate() > 0){
                conexion.cerrarConexion();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;
    }
}
