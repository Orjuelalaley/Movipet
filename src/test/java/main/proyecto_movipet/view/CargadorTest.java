package main.proyecto_movipet.view;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CargadorTest {

    @Test
    public void ProbarCargadorPantalla(){
        Cargador cargador = new Cargador();
        cargador.load("Login");
    }
}