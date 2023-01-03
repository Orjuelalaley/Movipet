package main.proyecto_movipet.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserSearch{
    public boolean buscarUsuario(int id) {
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
                System.out.println(consulta.getString("Email"));
                System.out.println(consulta.getString("Genero"));
                System.out.println(consulta.getString("Edad"));
                System.out.println(consulta.getString("Celular"));
                System.out.println(consulta.getString("NombreDeUsuario"));
                conexion.cerrarConexion();
                return true;
            } else {
                System.out.println("El usuario no existe");
                conexion.cerrarConexion();
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error al buscar empleado" + e.getMessage());
        }
        return false;
    }
}
