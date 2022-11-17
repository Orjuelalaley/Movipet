package main.proyecto_movipet;

import javafx.application.Application;
import javafx.stage.Stage;
import main.proyecto_movipet.view.Cargador;

import java.io.IOException;

public class App extends Application {
    private final static String MAIN_FXML_NAME = "StartUpScreen.fxml";
    Cargador cargador = new Cargador();
    @Override
    public void start(Stage stage){
        cargador.load(MAIN_FXML_NAME,"Pantalla De Inicio");
    }

    public static void main(String[] args) throws IOException {
        launch(args);
    }
}