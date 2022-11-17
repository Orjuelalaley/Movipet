package main.proyecto_movipet.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import main.proyecto_movipet.view.Cerrar_app;
import main.proyecto_movipet.view.FadeTransitions;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class SplashScreenController implements Initializable {

    @FXML
    private AnchorPane parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FadeTransitions.applyFadeTransition(parent, Duration.seconds(1),(e) -> {
            try{
                Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/main/proyecto_movipet/view/StartUpScreen.fxml")));
                parent.getChildren().removeAll();
                parent.getChildren().setAll(fxml);
            }catch (Exception exception){
                exception.printStackTrace();
            }
        });
    }
    public void close_app(MouseEvent event) {
        Cerrar_app.close();
    }
}
