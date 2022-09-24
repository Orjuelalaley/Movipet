package main.proyecto_movipet.Controller;

import com.jfoenix.controls.JFXAlert;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDialog;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.proyecto_movipet.connection.ConnectionPersonasDB;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.Duration;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reg_personasController {

    @FXML
    public JFXButton Next;
    @FXML
    private TextField Age;

    @FXML
    private JFXButton CancelButton;

    @FXML
    private TextField Email;

    @FXML
    private JFXCheckBox Male;
    @FXML
    private JFXCheckBox Female;
    @FXML
    private JFXCheckBox Other;
    @FXML
    private TextField ID;

    @FXML
    private TextField Name;

    @FXML
    private PasswordField Password;
    @FXML
    private PasswordField ConfirmPassword;
    @FXML
    private TextField Phone;
    @FXML
    private Label Warning_text;
    @FXML
    private TextField User;
    @FXML
    private Label Confirm;
    private final static String ICON_NAME = "/main/proyecto_movipet/view/Images/JAJA.png";
    private String Gender = null;

    public void Register_persona(){
        if (Male.isSelected() && !Female.isSelected() && !Other.isSelected()){
         Gender = "Masculino";
        }else if (!Male.isSelected() && Female.isSelected() && !Other.isSelected()) {
            Gender = "Femenino";
        } else if (!Male.isSelected() && !Female.isSelected() && Other.isSelected()) {
            Gender = "Otro";
        }

        if (!Name.getText().isBlank() && !User.getText().isBlank() && !Password.getText().isBlank()
                && !Email.getText().isBlank() && !ID.getText().isBlank() && Gender != null && !Age.getText().isBlank()
                && !Phone.getText().isBlank()) {
            if (Password.getText().equals(ConfirmPassword.getText()) && !Password.getText().isBlank()) {
                Register_user();
            } else {
                Confirm.setTextFill(Color.color(1, 0, 0));
                Confirm.setText("Las contraseñas no coinciden, intentelo nuevamente !!");
            }
        } else if (!Name.getText().isBlank() && !User.getText().isBlank() && !Password.getText().isBlank()
                && !Email.getText().isBlank() && !ID.getText().isBlank() && !Age.getText().isBlank()
                && Phone.getText().isBlank() && !ConfirmPassword.getText().isBlank()) {
            Warning_text.setText("Falta ingresar el numero de telefono/celular !!");
        } else if (!Name.getText().isBlank() && !User.getText().isBlank() && !Password.getText().isBlank()
                && !Email.getText().isBlank() && !ID.getText().isBlank() && Age.getText().isBlank()
                && !Phone.getText().isBlank() && !ConfirmPassword.getText().isBlank()) {
            Warning_text.setText("Falta ingresar la edad !!");
        } else if (!Name.getText().isBlank() && !User.getText().isBlank() && !Password.getText().isBlank()
                && !Email.getText().isBlank() && ID.getText().isBlank() && !Age.getText().isBlank()
                && !Phone.getText().isBlank() && !ConfirmPassword.getText().isBlank()) {
            Warning_text.setText("Falta ingresar la cedula !!");
        } else if (!Name.getText().isBlank() && !User.getText().isBlank() && !Password.getText().isBlank()
                && !Email.getText().isBlank() && !ID.getText().isBlank() && !Male.isSelected()
                && !Female.isSelected() && !Other.isSelected() && !Age.getText().isBlank()
                && !Phone.getText().isBlank() && !ConfirmPassword.getText().isBlank()) {
            Warning_text.setText("Falta seleccionar el genero !!");
        } else if (!Name.getText().isBlank() && !User.getText().isBlank() && !Password.getText().isBlank()
                && !Email.getText().isBlank() && !ID.getText().isBlank() && Male.isSelected()
                && Female.isSelected() && !Other.isSelected() && !Age.getText().isBlank()
                && !Phone.getText().isBlank() && !ConfirmPassword.getText().isBlank()) {
            Warning_text.setText("No se pueden seleccionar dos Generos al mismo tiempo");
            Gender = null;
        } else if (!Name.getText().isBlank() && !User.getText().isBlank() && !Password.getText().isBlank()
                && !Email.getText().isBlank() && !ID.getText().isBlank() && !Male.isSelected()
                && Female.isSelected() && Other.isSelected() && !Age.getText().isBlank()
                && !Phone.getText().isBlank() && !ConfirmPassword.getText().isBlank()) {
            Warning_text.setText("No se pueden seleccionar dos Generos al mismo tiempo");
            Gender = null;
        } else if (!Name.getText().isBlank() && !User.getText().isBlank() && !Password.getText().isBlank()
                && !Email.getText().isBlank() && !ID.getText().isBlank() && Male.isSelected()
                && !Female.isSelected() && Other.isSelected() && !Age.getText().isBlank()
                && !Phone.getText().isBlank() && !ConfirmPassword.getText().isBlank()) {
            Warning_text.setText("No se pueden seleccionar dos Generos al mismo tiempo !!");
            Gender = null;
        } else if (!Name.getText().isBlank() && !User.getText().isBlank() && !Password.getText().isBlank()
                && !Email.getText().isBlank() && !ID.getText().isBlank() && Male.isSelected()
                && Female.isSelected() && Other.isSelected() && !Age.getText().isBlank()
                && !Phone.getText().isBlank() && !ConfirmPassword.getText().isBlank()) {
            Warning_text.setText("No se pueden seleccionar todos los generos al mismo tiempo !!");
            Gender = null;
        } else if (!Name.getText().isBlank() && !User.getText().isBlank() && !Password.getText().isBlank()
                && Email.getText().isBlank() && !ID.getText().isBlank() && !Age.getText().isBlank()
                && !Phone.getText().isBlank() && !ConfirmPassword.getText().isBlank()) {
            Warning_text.setText("Falta ingresar el email !!");
        } else if (!Name.getText().isBlank() && !User.getText().isBlank() && Password.getText().isBlank()
                && !Email.getText().isBlank() && !ID.getText().isBlank() && !Age.getText().isBlank()
                && !Phone.getText().isBlank() && !ConfirmPassword.getText().isBlank()) {
            Warning_text.setText("Falta ingresar la contraseña !!");
        } else if (!Name.getText().isBlank() && User.getText().isBlank() && !Password.getText().isBlank()
                && !Email.getText().isBlank() && !ID.getText().isBlank() && !Age.getText().isBlank()
                && !Phone.getText().isBlank() && !ConfirmPassword.getText().isBlank()) {
            Warning_text.setText("Falta ingresar el nombre de usuario !!");
        } else if (Name.getText().isBlank() && !User.getText().isBlank() && !Password.getText().isBlank()
                && !Email.getText().isBlank() && !ID.getText().isBlank() && !Age.getText().isBlank()
                && !Phone.getText().isBlank() && !ConfirmPassword.getText().isBlank()) {
            Warning_text.setText("Falta ingresar el nombre !!");
        } else {
            Warning_text.setText("Falta por ingresar multiples datos !!");
        }
    }


    public void Register_user() {
        ConnectionPersonasDB connect = new ConnectionPersonasDB();
        Connection connectionDB = connect.getConnection();
        try {
            PreparedStatement ready = connectionDB.prepareStatement("insert  into info_personas values (?,?,?,?,?,?,?,?)");
            ready.setString(1, Name.getText().trim());
            ready.setString(2, Email.getText().trim());
            ready.setString(3, ID.getText().trim());
            ready.setString(4, Gender.trim());
            ready.setString(5, Age.getText().trim());
            ready.setString(6, Phone.getText().trim());
            ready.setString(7, User.getText().trim());
            ready.setString(8, Password.getText().trim());
            ready.executeUpdate();
            Warning_text.setText("Registro Completado !!");
            Reg_pets();
        } catch (Exception e) {
            System.err.println("ocurrio un error \n " + "Mensaje del error : " + e.getMessage());
            System.err.println("Detalle del error: ");
            e.printStackTrace();
        }
    }
    public void Reg_pets(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/proyecto_movipet/view/reg_mascotas.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("Pantalla De Registro De Mascotas");
            stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream(ICON_NAME))));
            stage.setScene(scene);
            stage.show();
            Stage myStage = (Stage) this.Next.getScene().getWindow();
            myStage.close();
        }catch (Exception e){
            System.err.println("ocurrio un error \n " + "Mensaje del error : " + e.getMessage());
            System.err.println("Detalle del error: ");
            e.printStackTrace();
        }
    }

    public void BackScreen() {
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
            Stage myStage = (Stage) this.CancelButton.getScene().getWindow();
            myStage.close();
        } catch (IOException ex) {
            Logger.getLogger(InicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
