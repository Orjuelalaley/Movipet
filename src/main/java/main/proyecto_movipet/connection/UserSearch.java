package main.proyecto_movipet.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserSearch{
    public void buscarUsuario(int id) {
        Conexion conexion = Conexion.getInstance();
        try {
            Connection conectar = conexion.conectar();
            PreparedStatement buscar = conectar.prepareStatement("SELECT * FROM movipet_db.clientes WHERE Cedula = ?");
            buscar.setInt(1, id);
            buscar.executeQuery();
            ResultSet consulta = buscar.executeQuery();
            if (consulta.next()) {
                System.out.println("El usuario existe");
                System.out.println(consulta.getString("Nombre"));
                System.out.println(consulta.getString("Correo"));
                System.out.println(consulta.getString("Genero"));
                System.out.println(consulta.getString("Edad"));
                System.out.println(consulta.getString("Celular"));
                System.out.println(consulta.getString("Usuario"));
            } else {
                System.out.println("El usuario no existe");
            }
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al buscar empleado" + e.getMessage());
        }
    }
}
