package main.proyecto_movipet.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.proyecto_movipet.connection.ConnectionPersonasDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Log_inController {
    public JFXButton LoginButton;
    public JFXButton GetBackButton;
    @FXML
    private PasswordField Password;
    @FXML
    private TextField UserName;
    @FXML
    private Label Warning_text;
    private final static String ICON_NAME = "/main/proyecto_movipet/view/Images/JAJA.png";

    public void LoginButtonAction(){
        if (!UserName.getText().isBlank() && !Password.getText().isBlank()){
            Warning_text.setText("Intentaste iniciar sesión !!");
            validarLogin();
        }else if(UserName.getText().isBlank()){
            Warning_text.setText("Ingresa el nombre de usuario !!");
        }else if(Password.getText().isBlank()){
            Warning_text.setText("Ingresa la contraseña !!");
        }
    }
    public void validarLogin(){
        ConnectionPersonasDB conectar = new ConnectionPersonasDB();
        Connection connectionDB = conectar.getConnection();

        String verifyLogin = "SELECT count(1) FROM  `db_personas`.`info_personas` WHERE UserName = '"+ UserName.getText() +"'AND Password ='" + Password.getText()+ "'";
        try {
            Statement statement = connectionDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()){
                if (queryResult.getInt(1)==1){
                    Warning_text.setText("Inicio de sesión exitoso !!");
                }else{
                    Warning_text.setText("Inicio de sesión Invalido. Intentelo Nuevamente !!");
                }
            }
        }catch (Exception e){
            System.err.println("ocurrio un error \n " +
                    "Mensaje del error : "+ e.getMessage());
            System.err.println("Detalle del error: ");
            e.printStackTrace();
        }
    }

    public void BackScreen(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/proyecto_movipet/view/Main_Screen.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("Pantalla De Inicio");
            stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream(ICON_NAME))));
            stage.setScene(scene);
            stage.show();
            Stage myStage = (Stage) this.GetBackButton.getScene().getWindow();
            myStage.close();
        } catch (IOException ex) {
            Logger.getLogger(InicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
