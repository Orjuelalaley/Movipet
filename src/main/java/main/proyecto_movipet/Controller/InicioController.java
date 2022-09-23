package main.proyecto_movipet.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;


public class InicioController  {

    @FXML
    private JFXButton Ingresar;
    @FXML
    private JFXButton Registrar;
    @FXML
    private JFXButton Exit;

    private final static String ICON_NAME = "/main/proyecto_movipet/view/Images/JAJA.png";
    @FXML
    void Register(){
        try {

            // Cargo la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/proyecto_movipet/view/reg_personas.fxml"));
            // Cargo el padre
            Parent root = loader.load();
            // Creo la scene y el stage
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream(ICON_NAME))));
            stage.setTitle("Pantalla De Registro");
            stage.initStyle(StageStyle.DECORATED);
            // Asocio el stage con el scene
            stage.setScene(scene);
            stage.show();
            // Indico que debe hacer al cerrar
            Stage myStage = (Stage) this.Registrar.getScene().getWindow();
            myStage.close();

        }catch (Exception ex){
            Logger.getLogger(InicioController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void Login(ActionEvent event){

        try {

            // Cargo la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/proyecto_movipet/view/Log_in.fxml"));
            // Cargo el padre
            Parent root = loader.load();
            //Obtengo el controlador
            Log_inController controlador = loader.getController();
            // Creo la scene y el stage
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("Pantalla De Inicio De Sesión");
            stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream(ICON_NAME))));
            // Asocio el stage con el scene
            stage.setScene(scene);
            stage.show();
            // Indico que debe hacer al cerrar
            Stage myStage = (Stage) this.Ingresar.getScene().getWindow();
            myStage.close();

        }catch (Exception ex){
            Logger.getLogger(InicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Exit_Code() {
        Stage myStage = (Stage) this.Exit.getScene().getWindow();
        myStage.close();
    }

}
