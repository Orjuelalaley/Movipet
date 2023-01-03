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

public class FactAtnController {
    @FXML
    public JFXButton Next22;
    private final static String ICON_NAME = "/main/proyecto_movipet/view/Images/JAJA.png";

    @FXML
    protected void onMenuButtonClick(ActionEvent event){
        if(event.getSource() == Next22){
            Next_Screen();
        }

    }

    public void Next_Screen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/proyecto_movipet/view/Fin.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("Gracias.");
            stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream(ICON_NAME))));
            stage.setScene(scene);
            stage.show();
            Stage myStage = (Stage) this.Next22.getScene().getWindow();
            myStage.close();
        } catch (Exception e) {
            System.err.println("ocurrio un error \n " + "Mensaje del error : " + e.getMessage());
            System.err.println("Detalle del error: ");
            e.printStackTrace();
        }
    }
}
