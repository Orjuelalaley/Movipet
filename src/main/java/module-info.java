module main.proyecto_movipet {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.graphics;

    requires java.sql;
    requires com.gluonhq.charm.glisten;
    requires com.jfoenix;

    opens main.proyecto_movipet to javafx.fxml;
    opens main.proyecto_movipet.Controller to javafx.fxml;
    exports main.proyecto_movipet.Controller;
    exports main.proyecto_movipet;
    exports main.proyecto_movipet.view;
    opens main.proyecto_movipet.view to javafx.fxml;
}