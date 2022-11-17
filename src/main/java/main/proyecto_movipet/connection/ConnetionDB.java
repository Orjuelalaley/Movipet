package main.proyecto_movipet.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnetionDB {
    public Connection getConnection(){
        Connection connection = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String user = "root";
        String password = "123456";
        String url = "jdbc:mysql://localhost:3306/movipet_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        }catch (Exception e){
            System.err.println("ocurrio un error \n " +
                    "Mensaje del error : "+ e.getMessage());
            System.err.println("Detalle del error: ");
            e.printStackTrace();
        }
        return connection;
    }
}
