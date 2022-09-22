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

public class Reg_personasController {

    @FXML
    private TextField Age;

    @FXML
    private JFXButton CancelButton;

    @FXML
    private TextField Email;

    @FXML
    private TextField Gender;

    @FXML
    private TextField ID;

    @FXML
    private TextField Name;

    @FXML
    private JFXButton Next;

    @FXML
    private PasswordField Password;

    @FXML
    private TextField Phone;
    @FXML
    private Label Warning_text;
    @FXML
    private TextField User;

    public void BackScreen(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/proyecto_movipet/view/Main_Screen.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
            Stage myStage = (Stage) this.CancelButton.getScene().getWindow();
            myStage.close();
        } catch (IOException ex) {
            Logger.getLogger(InicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Register_persona(ActionEvent event) {
        if (!Name.getText().isBlank() && !User.getText().isBlank() && !Password.getText().isBlank()
        && Email.getText().isBlank() && ID.getText().isBlank() && Gender.getText().isBlank() && Age.getText().isBlank()
         && Phone.getText().isBlank()){
            Warning_text.setText("Intentaste Registrarte sesión !!");
            Register_user();
        }

    }
    public void Register_user(){

    }
}
