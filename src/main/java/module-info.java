module main.proyecto_movipet {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires java.sql;

    opens main.proyecto_movipet to javafx.fxml;
    exports main.proyecto_movipet;
}