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
import main.proyecto_movipet.view.Cargador;
import main.proyecto_movipet.view.Cerrar_app;

import java.util.Objects;

public class ServiciosController {
    @FXML
    Parent parent;


    @FXML
    public void DomiService() {
        try {
            Cargador cargador = new Cargador();
            cargador.load("/main/proyecto_movipet/view/vets.fxml", "Escoger Veterinario");
            this.parent.getScene().getWindow().hide();
        } catch (Exception e) {
            System.err.println("ocurrio un error \n " + "Mensaje del error : " + e.getMessage());
            System.err.println("Detalle del error: ");
            e.printStackTrace();                    
        }
    }
    public void TransportDomi(){
        try {
            Cargador cargador = new Cargador();
            cargador.load("/main/proyecto_movipet/view/vets.fxml", "Escoger Veterinario");
            this.parent.getScene().getWindow().hide();
        }catch (Exception e){
            System.err.println("ocurrio un error \n " + "Mensaje del error : " + e.getMessage());
            System.err.println("Detalle del error: ");
            e.printStackTrace();
        }
    }
    public void close_app() {
            Cerrar_app.close();
}       }
