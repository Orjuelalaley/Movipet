package main.proyecto_movipet.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import main.proyecto_movipet.interfaces.DAOUsuarioImplementacion;
import main.proyecto_movipet.model.Entidades.Usuario;
import main.proyecto_movipet.view.Cargador;
import main.proyecto_movipet.view.Cerrar_app;

public class Log_inController {

    @FXML
    public AnchorPane parent;
    @FXML
    private PasswordField Password;
    @FXML
    private TextField UserName;

    public void LoginButtonAction(ActionEvent event) {
        DAOUsuarioImplementacion usuario_dao = new DAOUsuarioImplementacion();
        if (UserName.getText().isBlank() && Password.getText().isBlank()){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Error");
            alerta.setHeaderText("Los campos de usuario y contraseña están vacíos");
            alerta.showAndWait();
        }else if (UserName.getText().isBlank()){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Error");
            alerta.setHeaderText("El campo de usuario está vacío");
            alerta.showAndWait();
        }else if (Password.getText().isBlank()){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Error");
            alerta.setHeaderText("El campo de contraseña está vacío");
            alerta.showAndWait();
        }else if(!UserName.getText().isBlank() && !Password.getText().isBlank()){
            if (usuario_dao.iniciarSesion(UserName.getText(),Password.getText())){
                Cargador cargador = new Cargador();
                cargador.load("/main/proyecto_movipet/view/Main_page.fxml","Menu");
                this.parent.getScene().getWindow().hide();
            }
        }
    }
    public void close_app(MouseEvent event) {
        Cerrar_app.close();
    }

    public void RegisterButtonAction( ActionEvent event) {
        Cargador cargador = new Cargador();
        cargador.load("/main/proyecto_movipet/view/Reg_user.fxml","Registro de usuario");
        this.parent.getScene().getWindow().hide();
    }
}
