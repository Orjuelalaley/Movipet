package main.proyecto_movipet.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ConexionSql {
    private Connection Connection;
    private String user = "movipetADMIN";
    private String password = "123456";
    private String servidor = "localhost";
    private String puerto = "3306";
    private String NombreBD = "db_mascotas";

    private String url = "jdbc:mysql://"+servidor+":"+puerto+"/"+NombreBD+"?serverTimezone=UTC";

    private  String driver = "com.mysql.cj.jdbc.Driver";

    public ConexionSql() {
        try {
            Class.forName(driver);
            Connection = DriverManager.getConnection(url,user,password);
            PreparedStatement preparao = Connection.prepareStatement("insert  into info_mascotas values (?,?,?,?)");

            preparao.setString(1,"4");
            preparao.setString(2,"French Puddle");
            preparao.setString(3,"9");
            preparao.setString(4,"Lucas");
            preparao.executeUpdate();

            if (Connection!= null){
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
