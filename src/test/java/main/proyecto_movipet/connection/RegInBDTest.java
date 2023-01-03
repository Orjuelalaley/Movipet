package main.proyecto_movipet.connection;

import main.proyecto_movipet.model.Entidades.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegInBDTest {

    @Test
    void regUser() {
        RegInBD regInBD = new RegInBD();
        Usuario usuario = new Usuario();
        usuario.setCedula(100015248);
        usuario.setNombre("Samir");
        usuario.setCorreo("edyuy@gmail.com");
        usuario.setGenero("Masculino");
        usuario.setEdad(25);
        usuario.setCelular("123456789");
        usuario.setUsuario("ElSuperior");
        usuario.setPassword("1234");
        regInBD.registrarUsuario(usuario);
        assertTrue(regInBD.registrarUsuario(usuario));
    }
}