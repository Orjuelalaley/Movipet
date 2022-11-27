package main.proyecto_movipet.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.proyecto_movipet.connection.ConnetionDB;
import main.proyecto_movipet.interfaces.DAOUsuarioImplementacion;
import main.proyecto_movipet.view.Cargador;
import main.proyecto_movipet.view.Cerrar_app;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reg_personasController {

    @FXML
    private AnchorPane parent;
    @FXML
    public JFXButton Next;
    @FXML
    private TextField Age;
    @FXML
    private TextField Email;

    @FXML
    private JFXCheckBox Male;
    @FXML
    private JFXCheckBox Female;
    @FXML
    private JFXCheckBox Other;
    @FXML
    private TextField ID;
    @FXML
    private TextField Name;

    @FXML
    private PasswordField Password;

    @FXML
    private TextField Phone;
    @FXML
    private TextField User;
    @FXML
    private Label Confirm;

    private final static String ICON_NAME = "/main/proyecto_movipet/view/Images/JAJA.png";
    private String Gender = null;


    public void Register_persona(){
        Cargador cargador = new Cargador();
        DAOUsuarioImplementacion usuario_dao = new DAOUsuarioImplementacion();
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        if (Male.isSelected() && !Female.isSelected() && !Other.isSelected()){
         Gender = "Masculino";
        }else if (!Male.isSelected() && Female.isSelected() && !Other.isSelected()) {
            Gender = "Femenino";
        } else if (!Male.isSelected() && !Female.isSelected() && Other.isSelected()) {
            Gender = "Otro";
        }

        if (!Name.getText().isBlank() && !User.getText().isBlank() && !Password.getText().isBlank()
                && !Email.getText().isBlank() && !ID.getText().isBlank() && Gender != null && !Age.getText().isBlank()
                && !Phone.getText().isBlank()) {
            Pattern p = Pattern.compile("^\\d{10}$");
            Pattern ptwo = Pattern.compile("^\\d{9}$");
            Pattern pthree = Pattern.compile("^\\d{8}$");
            Matcher m = p.matcher(ID.getText());
            Matcher mtwo = ptwo.matcher(ID.getText());
            Matcher mthree = pthree.matcher(ID.getText());
            if (m.matches() || mtwo.matches() || mthree.matches()) {
                Pattern p2 = Pattern.compile("^\\d{10}$");
                Matcher m2 = p2.matcher(Phone.getText());
                if (m2.matches()) {
                    Pattern p3 = Pattern.compile("^\\d{1,2}$");
                    Matcher m3 = p3.matcher(Age.getText());
                    if (m3.matches()) {
                        Pattern p4 = Pattern.compile("^(.+)@(.+)$");
                        Matcher m4 = p4.matcher(Email.getText());
                        if (m4.matches()) {
                            //usuario_dao.registrar(Integer.parseInt(ID.getText()),Name.getText(),Email.getText(),Gender,Integer.parseInt(Age.getText()),Phone.getText(),User.getText(),Password.getText());
                            Reg_pets();
                        }else {
                            alerta.setTitle("Correo invalido");
                            alerta.setHeaderText("Error");
                            alerta.setContentText("Correo invalido");
                            alerta.showAndWait();
                        }
                    }else{
                        alerta.setTitle("Error");
                        alerta.setHeaderText("Error");
                        alerta.setContentText("La edad debe ser un numero");
                        alerta.showAndWait();
                    }
                }else{
                    alerta.setTitle("Error");
                    alerta.setHeaderText("Error");
                    alerta.setContentText("El numero de telefono debe tener 10 digitos");
                    alerta.showAndWait();
                }
            }else{
                alerta.setTitle("Registro");
                alerta.setHeaderText("Registro fallido");
                alerta.setContentText("El numero de identificación debe tener 8, 9 o 10 digitos");
                alerta.showAndWait();
            }

        } else if (!Name.getText().isBlank() && !User.getText().isBlank() && !Password.getText().isBlank()
                && !Email.getText().isBlank() && !ID.getText().isBlank() && !Age.getText().isBlank()
                && Phone.getText().isBlank()) {
                alerta.setTitle("Error");
                alerta.setHeaderText("Error al registrar");
                alerta.setContentText("Por favor ingrese un numero de telefono");
                alerta.showAndWait();
        } else if (!Name.getText().isBlank() && !User.getText().isBlank() && !Password.getText().isBlank()
                && !Email.getText().isBlank() && !ID.getText().isBlank() && Age.getText().isBlank()
                && !Phone.getText().isBlank() ) {
            alerta.setTitle("Error");
            alerta.setHeaderText("Error al registrar");
            alerta.setContentText("Por favor ingrese una edad");
            alerta.showAndWait();
        } else if (!Name.getText().isBlank() && !User.getText().isBlank() && !Password.getText().isBlank()
                && !Email.getText().isBlank() && ID.getText().isBlank() && !Age.getText().isBlank()
                && !Phone.getText().isBlank() ) {
            alerta.setTitle("Error");
            alerta.setHeaderText("Error al registrar");
            alerta.setContentText("Por favor ingrese un numero de identificación");
            alerta.showAndWait();
        } else if (!Name.getText().isBlank() && !User.getText().isBlank() && !Password.getText().isBlank()
                && !Email.getText().isBlank() && !ID.getText().isBlank() && !Male.isSelected()
                && !Female.isSelected() && !Other.isSelected() && !Age.getText().isBlank()
                && !Phone.getText().isBlank() ) {
            alerta.setTitle("Error");
            alerta.setHeaderText("Error al registrar");
            alerta.setContentText("Por favor seleccione un genero");
            alerta.showAndWait();
        } else if (!Name.getText().isBlank() && !User.getText().isBlank() && !Password.getText().isBlank()
                && !Email.getText().isBlank() && !ID.getText().isBlank() && Male.isSelected()
                && Female.isSelected() && !Other.isSelected() && !Age.getText().isBlank()
                && !Phone.getText().isBlank() ) {
            alerta.setTitle("Error");
            alerta.setHeaderText("Error al registrar");
            alerta.setContentText("Por favor seleccione un solo genero");
            alerta.showAndWait();
            Gender = null;
        } else if (!Name.getText().isBlank() && !User.getText().isBlank() && !Password.getText().isBlank()
                && !Email.getText().isBlank() && !ID.getText().isBlank() && !Male.isSelected()
                && Female.isSelected() && Other.isSelected() && !Age.getText().isBlank()
                && !Phone.getText().isBlank() ) {
            alerta.setTitle("Error");
            alerta.setHeaderText("Error al registrar");
            alerta.setContentText("Por favor seleccione un solo genero");
            alerta.showAndWait();
            Gender = null;
        } else if (!Name.getText().isBlank() && !User.getText().isBlank() && !Password.getText().isBlank()
                && !Email.getText().isBlank() && !ID.getText().isBlank() && Male.isSelected()
                && !Female.isSelected() && Other.isSelected() && !Age.getText().isBlank()
                && !Phone.getText().isBlank() ) {
            alerta.setTitle("Error");
            alerta.setHeaderText("Error al registrar");
            alerta.setContentText("Por favor seleccione un solo genero");
            alerta.showAndWait();
            Gender = null;
        } else if (!Name.getText().isBlank() && !User.getText().isBlank() && !Password.getText().isBlank()
                && !Email.getText().isBlank() && !ID.getText().isBlank() && Male.isSelected()
                && Female.isSelected() && Other.isSelected() && !Age.getText().isBlank()
                && !Phone.getText().isBlank() ) {
            alerta.setTitle("Error");
            alerta.setHeaderText("Error al registrar");
            alerta.setContentText("Por favor seleccione un solo genero");
            alerta.showAndWait();
            Gender = null;
        } else if (!Name.getText().isBlank() && !User.getText().isBlank() && !Password.getText().isBlank()
                && Email.getText().isBlank() && !ID.getText().isBlank() && !Age.getText().isBlank()
                && !Phone.getText().isBlank() ) {
            alerta.setTitle("Error");
            alerta.setHeaderText("Error al registrar");
            alerta.setContentText("Por favor ingrese un correo electonico");
            alerta.showAndWait();
        } else if (!Name.getText().isBlank() && !User.getText().isBlank() && Password.getText().isBlank()
                && !Email.getText().isBlank() && !ID.getText().isBlank() && !Age.getText().isBlank()
                && !Phone.getText().isBlank() ) {
            alerta.setTitle("Error");
            alerta.setHeaderText("Error al registrar");
            alerta.setContentText("Por favor ingrese una contraseña");
            alerta.showAndWait();
        } else if (!Name.getText().isBlank() && User.getText().isBlank() && !Password.getText().isBlank()
                && !Email.getText().isBlank() && !ID.getText().isBlank() && !Age.getText().isBlank()
                && !Phone.getText().isBlank() ) {
            alerta.setTitle("Error");
            alerta.setHeaderText("Error al registrar");
            alerta.setContentText("Por favor ingrese un nombre de usuario");
            alerta.showAndWait();
        } else if (Name.getText().isBlank() && !User.getText().isBlank() && !Password.getText().isBlank()
                && !Email.getText().isBlank() && !ID.getText().isBlank() && !Age.getText().isBlank()
                && !Phone.getText().isBlank() ) {
            alerta.setTitle("Error");
            alerta.setHeaderText("Error al registrar");
            alerta.setContentText("Por favor ingrese un nombre");
            alerta.showAndWait();
        } else {
            alerta.setTitle("Error");
            alerta.setHeaderText("Error al registrar");
            alerta.setContentText("Por favor llene todos los campos");
            alerta.showAndWait();
        }
    }

    public void Reg_pets(){
        try {
            Cargador cargador = new Cargador();
            cargador.load("/main/proyecto_movipet/view/Reg_pets.fxml","Registro de mascotas");
            Stage myStage = (Stage) this.parent.getScene().getWindow();
            myStage.close();
        }catch (Exception e){
            System.err.println("ocurrio un error \n " + "Mensaje del error : " + e.getMessage());
            System.err.println("Detalle del error: ");
            e.printStackTrace();
        }
    }

    public void BackScreen() {
        try {
            Cargador cargador = new Cargador();
            cargador.load("/main/proyecto_movipet/view/StartUpScreen.fxml","Pantalla De Inicio");
            Stage myStage = (Stage) this.parent.getScene().getWindow();
            myStage.close();
        } catch (Exception ex) {
            Logger.getLogger(InicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void close_app(MouseEvent event) {
        Cerrar_app.close();
    }

}
