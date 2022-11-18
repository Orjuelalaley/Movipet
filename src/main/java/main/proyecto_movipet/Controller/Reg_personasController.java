package main.proyecto_movipet.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.proyecto_movipet.connection.ConnetionDB;
import main.proyecto_movipet.view.Cargador;
import main.proyecto_movipet.view.Cerrar_app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reg_personasController {

    @FXML
    private AnchorPane parent;
    @FXML
    public JFXButton Next;
    @FXML
    private TextField Age;
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
    private TextField Phone;
    @FXML
    private TextField User;
    @FXML
    private Label Confirm;
    private final static String ICON_NAME = "/main/proyecto_movipet/view/Images/JAJA.png";
    private String Gender = null;

    public void Register_persona(){
        Alert alerta = new Alert(Alert.AlertType.WARNING);
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
            Reg_pets();
        } else if (!Name.getText().isBlank() && !User.getText().isBlank() && !Password.getText().isBlank()
                && !Email.getText().isBlank() && !ID.getText().isBlank() && !Age.getText().isBlank()
                && Phone.getText().isBlank() ) {
                alerta.setTitle("Error");
                alerta.setHeaderText("Error al registrar");
                alerta.setContentText("Por favor ingrese un numero de telefono");
                alerta.showAndWait();
        } else if (!Name.getText().isBlank() && !User.getText().isBlank() && !Password.getText().isBlank()
                && !Email.getText().isBlank() && !ID.getText().isBlank() && Age.getText().isBlank()
                && !Phone.getText().isBlank() ) {
            alerta.setTitle("Error");
            alerta.setHeaderText("Error al registrar");
            alerta.setContentText("Por favor ingrese una edad");
            alerta.showAndWait();
        } else if (!Name.getText().isBlank() && !User.getText().isBlank() && !Password.getText().isBlank()
                && !Email.getText().isBlank() && ID.getText().isBlank() && !Age.getText().isBlank()
                && !Phone.getText().isBlank() ) {
            alerta.setTitle("Error");
            alerta.setHeaderText("Error al registrar");
            alerta.setContentText("Por favor ingrese un numero de identificacion");
            alerta.showAndWait();
        } else if (!Name.getText().isBlank() && !User.getText().isBlank() && !Password.getText().isBlank()
                && !Email.getText().isBlank() && !ID.getText().isBlank() && !Male.isSelected()
                && !Female.isSelected() && !Other.isSelected() && !Age.getText().isBlank()
                && !Phone.getText().isBlank() ) {
            alerta.setTitle("Error");
            alerta.setHeaderText("Error al registrar");
            alerta.setContentText("Por favor seleccione un genero");
            alerta.showAndWait();
        } else if (!Name.getText().isBlank() && !User.getText().isBlank() && !Password.getText().isBlank()
                && !Email.getText().isBlank() && !ID.getText().isBlank() && Male.isSelected()
                && Female.isSelected() && !Other.isSelected() && !Age.getText().isBlank()
                && !Phone.getText().isBlank() ) {
            alerta.setTitle("Error");
            alerta.setHeaderText("Error al registrar");
            alerta.setContentText("Por favor seleccione un solo genero");
            alerta.showAndWait();
            Gender = null;
        } else if (!Name.getText().isBlank() && !User.getText().isBlank() && !Password.getText().isBlank()
                && !Email.getText().isBlank() && !ID.getText().isBlank() && !Male.isSelected()
                && Female.isSelected() && Other.isSelected() && !Age.getText().isBlank()
                && !Phone.getText().isBlank() ) {
            alerta.setTitle("Error");
            alerta.setHeaderText("Error al registrar");
            alerta.setContentText("Por favor seleccione un solo genero");
            alerta.showAndWait();
            Gender = null;
        } else if (!Name.getText().isBlank() && !User.getText().isBlank() && !Password.getText().isBlank()
                && !Email.getText().isBlank() && !ID.getText().isBlank() && Male.isSelected()
                && !Female.isSelected() && Other.isSelected() && !Age.getText().isBlank()
                && !Phone.getText().isBlank() ) {
            alerta.setTitle("Error");
            alerta.setHeaderText("Error al registrar");
            alerta.setContentText("Por favor seleccione un solo genero");
            alerta.showAndWait();
            Gender = null;
        } else if (!Name.getText().isBlank() && !User.getText().isBlank() && !Password.getText().isBlank()
                && !Email.getText().isBlank() && !ID.getText().isBlank() && Male.isSelected()
                && Female.isSelected() && Other.isSelected() && !Age.getText().isBlank()
                && !Phone.getText().isBlank() ) {
            alerta.setTitle("Error");
            alerta.setHeaderText("Error al registrar");
            alerta.setContentText("Por favor seleccione un solo genero");
            alerta.showAndWait();
            Gender = null;
        } else if (!Name.getText().isBlank() && !User.getText().isBlank() && !Password.getText().isBlank()
                && Email.getText().isBlank() && !ID.getText().isBlank() && !Age.getText().isBlank()
                && !Phone.getText().isBlank() ) {
            alerta.setTitle("Error");
            alerta.setHeaderText("Error al registrar");
            alerta.setContentText("Por favor ingrese un correo electronico");
            alerta.showAndWait();
        } else if (!Name.getText().isBlank() && !User.getText().isBlank() && Password.getText().isBlank()
                && !Email.getText().isBlank() && !ID.getText().isBlank() && !Age.getText().isBlank()
                && !Phone.getText().isBlank() ) {
            alerta.setTitle("Error");
            alerta.setHeaderText("Error al registrar");
            alerta.setContentText("Por favor ingrese una contraseña");
            alerta.showAndWait();
        } else if (!Name.getText().isBlank() && User.getText().isBlank() && !Password.getText().isBlank()
                && !Email.getText().isBlank() && !ID.getText().isBlank() && !Age.getText().isBlank()
                && !Phone.getText().isBlank() ) {
            alerta.setTitle("Error");
            alerta.setHeaderText("Error al registrar");
            alerta.setContentText("Por favor ingrese un nombre de usuario");
            alerta.showAndWait();
        } else if (Name.getText().isBlank() && !User.getText().isBlank() && !Password.getText().isBlank()
                && !Email.getText().isBlank() && !ID.getText().isBlank() && !Age.getText().isBlank()
                && !Phone.getText().isBlank() ) {
            alerta.setTitle("Error");
            alerta.setHeaderText("Error al registrar");
            alerta.setContentText("Por favor ingrese un nombre");
            alerta.showAndWait();
        } else {
            alerta.setTitle("Error");
            alerta.setHeaderText("Error al registrar");
            alerta.setContentText("Por favor llene todos los campos");
            alerta.showAndWait();
        }
        try {
            int numero = Integer.parseInt(Phone.getText());
            if (numero > 0) {
                if (numero > 999999999) {
                    alerta.setTitle("Error");
                    alerta.setHeaderText("El numero de telefono es muy largo");
                    alerta.setContentText("El numero de telefono no puede tener mas de 9 digitos");
                    alerta.showAndWait();
                } else {
                    alerta.setTitle("Error");
                    alerta.setHeaderText("El numero de telefono es muy corto");
                    alerta.setContentText("El numero de telefono no puede tener menos de 9 digitos");
                    alerta.showAndWait();
                }
            }

        }catch (Exception e){
            alerta.setTitle("Error");
            alerta.setHeaderText("Error al registrar");
            alerta.setContentText("Por favor ingrese un numero de telefono");
            alerta.showAndWait();
        }
    }


    public void Register_user() {
        ConnetionDB connect = new ConnetionDB();
        Connection connectionDB = connect.getConnection();
        try {
            PreparedStatement ready = connectionDB.prepareStatement("insert  into movipet_db.clientes values (?,?,?,?,?,?,?,?)");
            ready.setString(1, ID.getText().trim());
            ready.setString(2, Name.getText().trim());
            ready.setString(3, Email.getText().trim());
            ready.setString(4, Gender.trim());
            ready.setString(5, Age.getText().trim());
            ready.setString(6, Phone.getText().trim());
            ready.setString(7, User.getText().trim());
            ready.setString(8, Password.getText().trim());
            ready.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Registro exitoso");
            alert.setHeaderText(null);
            alert.setContentText("Usuario registrado exitosamente");
            alert.showAndWait();
            Reg_pets();
        } catch (Exception e) {
            System.err.println("ocurrio un error \n " + "Mensaje del error : " + e.getMessage());
            System.err.println("Detalle del error: ");
            e.printStackTrace();
        }
    }
    public void Reg_pets(){
        try {
            Cargador cargador = new Cargador();
            cargador.load("/main/proyecto_movipet/view/Reg_pets.fxml","Registro de mascotas");
            Stage myStage = (Stage) this.parent.getScene().getWindow();
            myStage.close();
        }catch (Exception e){
            System.err.println("ocurrio un error \n " + "Mensaje del error : " + e.getMessage());
            System.err.println("Detalle del error: ");
            e.printStackTrace();
        }
    }

    public void BackScreen() {
        try {
            Cargador cargador = new Cargador();
            cargador.load("/main/proyecto_movipet/view/StartUpScreen.fxml","Pantalla De Inicio");
            Stage myStage = (Stage) this.parent.getScene().getWindow();
            myStage.close();
        } catch (Exception ex) {
            Logger.getLogger(InicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void close_app(MouseEvent event) {
        Cerrar_app.close();
    }

}
