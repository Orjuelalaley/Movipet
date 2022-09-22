package main.proyecto_movipet.Controller;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reg_mascotasController implements Initializable {

    private Log_inController carga;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Connection conexion = conectar();
    }
    public Connection conectar(){
        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driver);
            String user = "movipetADMIN";
            String password = "123456";
            String dir = "jdbc:mysql://localhost:3306/db_mascotas?serverTimezone=UTC";
            Connection connection = DriverManager.getConnection(dir, user, password);
            if (connection != null){
                System.out.println("Conexion realizada correctamente !!");
            }
            return connection;
        } catch (Exception e) {
            System.err.println("ocurrio un error en la conexion \n " +
                    "Mensaje del error : "+ e.getMessage());
            System.err.println("Detalle del error: ");
            e.printStackTrace();
        }
        return null;
    }
    /*public void closeWindows() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/proyecto_movipet/view/Main_Screen.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
            Stage myStage = (Stage) this.GetBackButton.getScene().getWindow();
            myStage.close();
        } catch (IOException ex) {
            Logger.getLogger(InicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
}
