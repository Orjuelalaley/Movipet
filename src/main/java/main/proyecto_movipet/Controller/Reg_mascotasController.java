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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.proyecto_movipet.connection.RegPetInBD;
import main.proyecto_movipet.model.Entidades.Mascota;
import main.proyecto_movipet.view.Cargador;
import main.proyecto_movipet.view.Cerrar_app;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reg_mascotasController {


    public AnchorPane parent;
    public JFXButton GetBack;
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
    private JFXButton Reg_pets;

    private String Type = null;
    private int pet_id;

    private final static String ICON_NAME = "/main/proyecto_movipet/view/Images/JAJA.png";

    @FXML
    void Register_mascota() {

        RegPetInBD regPetInBD = new RegPetInBD();
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        if (Cat.isSelected() && !Dog.isSelected()) {
            Type = "Gato";
        } else if (!Cat.isSelected() && Dog.isSelected()) {
            Type = "Perro";
        }
        if (!Pet_name.getText().isBlank() && !Short_name.getText().isBlank() && !Pet_Class.getText().isBlank()
                && !Pet_Age.getText().isBlank() && !Comments.getText().isBlank() && Type != null) {
            Pattern p = Pattern.compile("^\\d{1,2}$");
            Matcher m = p.matcher(Pet_Age.getText());
            if (m.matches()){
                Mascota mascota = new Mascota();
                mascota.setNombre(Pet_name.getText());
                mascota.setApodo(Short_name.getText());
                mascota.setTipo(Type);
                mascota.setRaza(Pet_Class.getText());
                mascota.setEdad(Integer.parseInt(Pet_Age.getText()));
                mascota.setComentarios(Comments.getText());
                regPetInBD.registrarMascota(mascota);
            }else {
                alerta.setTitle("Error");
                alerta.setHeaderText("Error en el campo Edad");
                alerta.setContentText("La edad debe ser un numero entero");
                alerta.showAndWait();
            }
            //Register_pet();
        } else if (Pet_name.getText().isBlank() && !Short_name.getText().isBlank()
                && !Pet_Class.getText().isBlank() && !Pet_Age.getText().isBlank() && !Comments.getText().isBlank()) {
            alerta.setTitle("Error");
            alerta.setHeaderText("El campo de nombre de la mascota está vacío");
            alerta.showAndWait();
        } else if (!Pet_name.getText().isBlank() && Short_name.getText().isBlank()
                && !Pet_Class.getText().isBlank() && !Pet_Age.getText().isBlank() && !Comments.getText().isBlank()) {
            alerta.setTitle("Error");
            alerta.setHeaderText("El campo de nombre corto de la mascota está vacío");
            alerta.showAndWait();
        } else if (!Pet_name.getText().isBlank() && !Short_name.getText().isBlank()
                && Pet_Class.getText().isBlank() && !Pet_Age.getText().isBlank() && !Comments.getText().isBlank()) {
            alerta.setTitle("Error");
            alerta.setHeaderText("El campo de raza de la mascota está vacío");
            alerta.showAndWait();
        } else if (Cat.isSelected() && Dog.isSelected()) {
            alerta.setTitle("Error");
            alerta.setHeaderText("Solo puede seleccionar un tipo de mascota");
            alerta.showAndWait();
        } else if (!Cat.isSelected() && !Dog.isSelected()) {
            alerta.setTitle("Error");
            alerta.setHeaderText("Debe seleccionar un tipo de mascota");
            alerta.showAndWait();
        } else if (!Pet_name.getText().isBlank() && !Short_name.getText().isBlank()
                && !Pet_Class.getText().isBlank() && Pet_Age.getText().isBlank() && !Comments.getText().isBlank()) {
            alerta.setTitle("Error");
            alerta.setHeaderText("El campo de edad de la mascota está vacío");
            alerta.showAndWait();
        }
        else if (!Pet_name.getText().isBlank() && !Short_name.getText().isBlank()
                && !Pet_Class.getText().isBlank() && !Pet_Age.getText().isBlank() && Comments.getText().isBlank()) {
            alerta.setTitle("Error");
            alerta.setHeaderText("El campo de comentarios de la mascota está vacío");
            alerta.showAndWait();
        } else {
            alerta.setTitle("Error");
            alerta.setHeaderText("Debe llenar todos los campos");
            alerta.showAndWait();
        }
        try {
            int edad = Integer.parseInt(Pet_Age.getText());
            if (edad < 0) {
                alerta.setTitle("Error");
                alerta.setHeaderText("La edad de la mascota no puede ser negativa");
                alerta.showAndWait();
            } else if (edad > 100) {
                alerta.setTitle("Error");
                alerta.setHeaderText("La edad de la mascota no puede ser mayor a 100 años");
                alerta.showAndWait();
            }
        }catch (Exception e){
            alerta.setTitle("Error");
            alerta.setHeaderText("La edad de la mascota debe ser un número");
            alerta.showAndWait();
        }
    }

    @FXML
    public void Next_Screen(){
        try {
            Cargador cargador = new Cargador();
            cargador.load("/main/proyecto_movipet/view/Main_page.fxml", "Movipet");
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


    public void close_app(MouseEvent event) {
        Cerrar_app.close();
    }

    public void Start_Again(ActionEvent event) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Confirmación");
        alerta.setHeaderText("Al regresar a la pantalla principal se perderán los datos ingresados");
        alerta.setContentText("¿Desea continuar?");
        alerta.showAndWait();
        if (alerta.getAlertType() == Alert.AlertType.CONFIRMATION) {
            Cargador cargador = new Cargador();
            cargador.load("/main/proyecto_movipet/view/Reg_user.fxml","Registro de usuarios");
        }

    }
}
