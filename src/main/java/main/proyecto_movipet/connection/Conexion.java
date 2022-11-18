package main.proyecto_movipet.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection conexion;
    private static Conexion instancia;

    String driver = "com.mysql.cj.jdbc.Driver";
    String user = "root";
    String password = "123456";
    String url = "jdbc:mysql://localhost:3306/movipet_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    //creamos método para abrir la conexión
    public  Connection conectar(){
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, user, password);
            return conexion;
        }catch (Exception e){
            e.printStackTrace();
        }
        return conexion;
    }
    //creamos método para cerrar la conexión
    public void cerrarConexion() throws SQLException {
        try{
            conexion.close();
        }catch (Exception e ){
            System.err.println("Error al cerrar la conexion" + e.getMessage());
        }finally {
            conexion.close();
        }
    }
    //creamos método para obtener la conexión
    //Singleton
    public static Conexion getInstance(){
        if (instancia == null){
            instancia = new Conexion();
        }
        return instancia;
    }
}
