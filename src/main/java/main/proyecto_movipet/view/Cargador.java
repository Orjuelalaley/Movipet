package main.proyecto_movipet.view;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class Cargador {
    Parent root = null;

    public  void load(String file,String info)  {
        String ICON_NAME = "Images/JAJA.png";
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(file)));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream(ICON_NAME))));
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setTitle(info);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
