package main.proyecto_movipet.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.proyecto_movipet.connection.ConnetionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Objects;

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
    @FXML
    private JFXButton Reg_pets;

    private String Type = null;
    private int pet_id;

    private final static String ICON_NAME = "/main/proyecto_movipet/view/Images/JAJA.png";

    @FXML
    void Register_mascota() {
        if (Cat.isSelected() && !Dog.isSelected()) {
            Type = "Gato";
        } else if (!Cat.isSelected() && Dog.isSelected()) {
            Type = "Perro";
        }
        if (!Pet_name.getText().isBlank() && !Short_name.getText().isBlank() && !Pet_Class.getText().isBlank()
                && !Pet_Age.getText().isBlank() && !Comments.getText().isBlank() && Type != null) {
            //Register_pet();
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

    /*private void Register_pet() {
        ConnetionDB connect = new ConnetionDB();
        Connection connectionDB = connect.getConnection();

        try {

            PreparedStatement ready = connectionDB.prepareStatement("insert  into info_mascotas values (?,?,?,?,?,?,?)");

            ready.setString(1, String.valueOf(pet_id));
            ready.setString(2, Pet_name.getText().trim());
            ready.setString(3, Short_name.getText().trim());
            ready.setString(4, Type.trim());
            ready.setString(5, Pet_Class.getText().trim());
            ready.setString(6, Pet_Age.getText().trim());
            ready.setString(7, Comments.getText().trim());
            ready.executeUpdate();
            Warning_text.setText("Registro De la mascota Completado !!");
            Next_Screen();
        }catch (Exception e){
            System.err.println("ocurrio un error \n " + "Mensaje del error : " + e.getMessage());
            System.err.println("Detalle del error: ");
            e.printStackTrace();
        }
    }*/
    public void Next_Screen(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/proyecto_movipet/view/Main_page.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("Pantalla Principal de la aplicación");
            stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream(ICON_NAME))));
            stage.setScene(scene);
            stage.show();
            Stage myStage = (Stage) this.Reg_pets.getScene().getWindow();
            myStage.close();
        }catch (Exception e)
            {
                System.err.println("ocurrio un error \n " + "Mensaje del error : " + e.getMessage());
                System.err.println("Detalle del error: ");
                e.printStackTrace();
            }
    }
}
