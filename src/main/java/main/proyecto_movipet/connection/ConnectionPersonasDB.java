package main.proyecto_movipet.connection;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionPersonasDB {
    public Connection personas_db;

    public Connection getConnection(){
        String driver = "com.mysql.cj.jdbc.Driver";
        String user = "movipetADMIN";
        String password = "123456";
        String url = "jdbc:mysql://localhost:3306/db_personas?serverTimezone=UTC";
        try {
            Class.forName(driver);
            personas_db = DriverManager.getConnection(url, user, password);
        }catch (Exception e){
            System.err.println("ocurrio un error \n " +
                    "Mensaje del error : "+ e.getMessage());
            System.err.println("Detalle del error: ");
            e.printStackTrace();
        }
        return personas_db;
    }
}
