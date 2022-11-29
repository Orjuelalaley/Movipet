package main.proyecto_movipet.model.Entidades.Facade;

import javafx.application.Application;
import javafx.stage.Stage;
import main.proyecto_movipet.view.Cargador;

public class MenuUsuario extends Application {
    Cargador cargador = new Cargador();
    private final static String MAIN_FXML_NAME = "SplashScreen.fxml";

    public void menuUsuario (){
    Stage stage = new Stage();
    start(stage);
    }

    @Override
    public void start(Stage stage){
        cargador.load(MAIN_FXML_NAME,"Pantalla De Inicio");
    }
}
