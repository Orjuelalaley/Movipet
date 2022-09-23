package main.proyecto_movipet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class App extends Application {
    private final static String ICON_NAME = "view/Images/JAJA.png";
    private final static String MAIN_FXML_NAME = "view/Main_Screen.fxml";

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(MAIN_FXML_NAME)));
        Scene scene = new Scene(root);
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream(ICON_NAME))));
        stage.initStyle(StageStyle.UNIFIED);
        stage.setTitle("Pantalla De Inicio");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        launch(args);
    }
}