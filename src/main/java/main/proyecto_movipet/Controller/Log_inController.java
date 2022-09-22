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
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
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

    public void LoginButtonAction(ActionEvent e){
        if (!UserName.getText().isBlank() && !Password.getText().isBlank()){
            Warning_text.setText("Intentaste iniciar sesión !!");
        }else if(UserName.getText().isBlank()){
            Warning_text.setText("Ingresa el nombre de usuario !!");
        }else if(Password.getText().isBlank()){
            Warning_text.setText("Ingresa la contraseña !!");
        }

    }

    public void BackScreen(ActionEvent e){
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
            Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
