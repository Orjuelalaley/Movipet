package main.proyecto_movipet.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import main.proyecto_movipet.view.Cargador;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InicioController  {

    @FXML
    private JFXButton Ingresar;
    @FXML
    private JFXButton Registrar;
    @FXML
    private JFXButton Exit;
    private final static String ICON_NAME = "/main/proyecto_movipet/view/Images/JAJA.png";

    Cargador cargador = new Cargador();
    @FXML
    void Register(){
        String Register_Screen_FXML_NAME = "/main/proyecto_movipet/view/reg_personas.fxml";
        try {
            cargador.load(Register_Screen_FXML_NAME,"Pantalla De Registro");
            Stage myStage = (Stage) this.Registrar.getScene().getWindow();
            myStage.close();
        }catch (Exception ex){
            Logger.getLogger(InicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void Login(){
        String Log_IN_FXML_NAME = "/main/proyecto_movipet/view/Log_in.fxml";
        try {
            cargador.load(Log_IN_FXML_NAME,"Pantalla De Inicio De Sesión");
            Stage myStage = (Stage) this.Ingresar.getScene().getWindow();
            myStage.close();
        }catch (Exception ex){
            Logger.getLogger(InicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Exit_Code() {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setHeaderText(null);
        alerta.setTitle("INFO");
        alerta.setContentText("SE VA A CERRAR EL PROGRAMA");
        alerta.showAndWait();
        System.exit(0);
    }
}
