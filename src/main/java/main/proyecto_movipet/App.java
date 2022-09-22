package main.proyecto_movipet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class App extends Application {
    private final static String ICON_NAME = "view/Images/JAJA.png";
    private final static String MAIN_FXML_NAME = "view/Main_Screen.fxml";
    private final static String WINDOW_NAME = "Pantalla De Inicio";

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(MAIN_FXML_NAME));
        Scene scene = new Scene(root);
        stage.getIcons().add(new Image(getClass().getResourceAsStream(ICON_NAME)));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle(WINDOW_NAME);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        launch(args);
    }
}