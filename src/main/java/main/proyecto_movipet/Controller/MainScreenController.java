package main.proyecto_movipet.Controller;

import com.gluonhq.charm.glisten.mvc.View;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MainScreenController implements Initializable {

    @FXML
    private JFXButton Ingresar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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
            stage.initStyle(StageStyle.UNDECORATED);
            // Asocio el stage con el scene
            stage.setScene(scene);
            stage.show();
            // Indico que debe hacer al cerrar
            Stage myStage = (Stage) this.Ingresar.getScene().getWindow();
            myStage.close();

        }catch (Exception ex){
            Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
