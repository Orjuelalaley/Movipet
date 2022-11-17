package main.proyecto_movipet.connection;

import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ValidarConection {
    public static boolean validarLogin(String user, String pass) {
        ConnetionDB conectar = new ConnetionDB();
        Connection connectionDB = conectar.getConnection();

        String verifyLogin = "SELECT count(1) FROM  `movipet_db`.`clientes` WHERE NombreDeUsuario = '"+ user +"'AND Password ='" + pass + "'";
        try {
            Statement statement = connectionDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            if (queryResult.next()){
                if (queryResult.getInt(1)==1){
                    Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                    alerta.setHeaderText(null);
                    alerta.setTitle("INFO");
                    alerta.setContentText("BIENVENIDO A MOVIPET");
                    alerta.showAndWait();
                    return  true;
                }else{
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setHeaderText(null);
                    alerta.setTitle("ERROR");
                    alerta.setContentText("Usuario o contraseña incorrectos");
                    alerta.showAndWait();
                }
            }
        }catch (Exception e){
            System.err.println("ocurrio un error \n " +
                    "Mensaje del error : "+ e.getMessage());
            System.err.println("Detalle del error: ");
            e.printStackTrace();
        }
        return false;
    }
}
