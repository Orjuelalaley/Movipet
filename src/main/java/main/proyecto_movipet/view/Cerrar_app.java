package main.proyecto_movipet.view;

import javafx.scene.control.Alert;

public class Cerrar_app {

    public static void close(){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText(null);
        alerta.setTitle("INFO");
        alerta.setContentText("USTED VA A SALIR DE ESTE PROGRAMA !!!");
        alerta.showAndWait();
        System.exit(1);
    }
}
