package main.proyecto_movipet.Controller;

import com.jfoenix.controls.JFXCheckBox;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.proyecto_movipet.connection.ConnectionPersonasDB;
import main.proyecto_movipet.connection.ConnetionMascotasDB;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reg_mascotasController {

    @FXML
    private JFXCheckBox Cat;

    @FXML
    private TextField Comments;

    @FXML
    private JFXCheckBox Dog;

    @FXML
    private TextField Pet_Age;

    @FXML
    private TextField Pet_Class;

    @FXML
    private TextField Pet_name;

    @FXML
    private TextField Short_name;

    @FXML
    private Label Warning_text;

    private String Type = null;

    @FXML
    void Register_mascota() {
        if (Cat.isSelected() && !Dog.isSelected()) {
            Type = "Gato";
        } else if (!Cat.isSelected() && Dog.isSelected()) {
            Type = "Perro";
        }
        if (!Pet_name.getText().isBlank() && !Short_name.getText().isBlank() && !Pet_Class.getText().isBlank()
                && !Pet_Age.getText().isBlank() && !Comments.getText().isBlank() && Type != null) {
            Register_pet();
        } else if (Pet_name.getText().isBlank() && !Short_name.getText().isBlank()
                && !Pet_Class.getText().isBlank() && !Pet_Age.getText().isBlank() && !Comments.getText().isBlank()) {
            Warning_text.setText("Falta ingresar el nombre de la mascota !!");
        } else if (!Pet_name.getText().isBlank() && Short_name.getText().isBlank()
                && !Pet_Class.getText().isBlank() && !Pet_Age.getText().isBlank() && !Comments.getText().isBlank()) {
            Warning_text.setText("Falta ingresar el apodo de la mascota");
        } else if (Cat.isSelected() && Dog.isSelected()) {
            Warning_text.setText("No se pueden selecicionar los dos tipos de mascotas !!");
        } else if (!Cat.isSelected() && !Dog.isSelected()) {
            Warning_text.setText("Falta seleccionar un unico tipo de mascota");

        } else if (!Pet_name.getText().isBlank() && !Short_name.getText().isBlank()
                && Pet_Class.getText().isBlank() && !Pet_Age.getText().isBlank() && !Comments.getText().isBlank()) {
            Warning_text.setText("Falta ingresar la raza de la mascota");
        } else if (!Pet_name.getText().isBlank() && !Short_name.getText().isBlank()
                && !Pet_Class.getText().isBlank() && Pet_Age.getText().isBlank() && !Comments.getText().isBlank()) {
            Warning_text.setText("Falta ingresar la edad de la mascota");
        } else if (!Pet_name.getText().isBlank() && !Short_name.getText().isBlank()
                && !Pet_Class.getText().isBlank() && !Pet_Age.getText().isBlank() && Comments.getText().isBlank()) {
            Warning_text.setText("Falta ingresar los comentarios de la mascota");
        }

    }

    private void Register_pet() {
        ConnetionMascotasDB connect = new ConnetionMascotasDB();
        Connection connectionDB = connect.getConnection();
        try {
            PreparedStatement ready = connectionDB.prepareStatement("insert  into info_mascotas values (?,?,?,?,?,?,?)");
            ready.setString(1, Pet_name.getText().trim());
            ready.setString(2, Short_name.getText().trim());
            ready.setString(3, Type.trim());
            ready.setString(4, Pet_Class.getText().trim());
            ready.setString(5, Pet_Age.getText().trim());
            ready.setString(6, Comments.getText().trim());
            ready.executeUpdate();
            Warning_text.setText("Registro Completado !!");

        }catch (Exception e){

        }





    }
}
