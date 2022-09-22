package main.proyecto_movipet.connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ConexionSql {

    public ConexionSql() {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            String user = "movipetADMIN";
            String password = "123456";
            String url = "jdbc:mysql://localhost:3306/db_mascotas?serverTimezone=UTC";
            java.sql.Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparao = connection.prepareStatement("insert  into info_mascotas values (?,?,?,?,?,?,?)");

            /*preparao.setString(1,"1");
            preparao.setString(2,"Lucas");
            preparao.setString(3,"Lucky");
            preparao.setString(4,"1");
            preparao.setString(5,"French Puddle");
            preparao.setString(6,"9");
            preparao.setString(7,"es una ratica que se baña con amor");
            preparao.executeUpdate();*/

            if (connection != null){
                System.out.println("Conexion realizada correctamente !!");
            }

        }catch (Exception e) {
            System.err.println("ocurrio un error en la conexion \n " +
                    "Mensaje del error : "+ e.getMessage());
            System.err.println("Detalle del error: ");
            e.printStackTrace();
        }
    }
}
