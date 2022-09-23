package main.proyecto_movipet.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnetionMascotasDB {
    public Connection mascotas_db;

    public Connection getConnection(){
        String driver = "com.mysql.cj.jdbc.Driver";
        String user = "root";
        String password = "123456";
        String url = "jdbc:mysql://localhost:3306/db_mascotas?serverTimezone=UTC";
        try {
            Class.forName(driver);
            mascotas_db = DriverManager.getConnection(url, user, password);
        }catch (Exception e){
            System.err.println("ocurrio un error \n " +
                    "Mensaje del error : "+ e.getMessage());
            System.err.println("Detalle del error: ");
            e.printStackTrace();
        }
        return mascotas_db;
    }
}
