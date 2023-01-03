package main.proyecto_movipet.Controller;
import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.proyecto_movipet.view.Cerrar_app;

import java.util.Objects;

public class VetController {
    @FXML
    public JFXButton Next1, Next11, Next111;

    @FXML
    protected void onMenuButtonClick(ActionEvent event){
        if(event.getSource() == Next1){
            Next_Screen();
        }
        if(event.getSource() == Next11){
            Next_Screen();
        }
        if(event.getSource() == Next111){
            Next_Screen();
        }

    }

    public void Next_Screen() {
        try {

        } catch (Exception e) {
            System.err.println("ocurrio un error \n " + "Mensaje del error : " + e.getMessage());
            System.err.println("Detalle del error: ");
            e.printStackTrace();
        }
    }

    public void close_app() {
        Cerrar_app.close();
    }
}
