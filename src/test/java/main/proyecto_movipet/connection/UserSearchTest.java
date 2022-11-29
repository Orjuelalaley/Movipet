package main.proyecto_movipet.connection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserSearchTest {

    @Test
    void buscarUsuario() {
        UserSearch userSearch = new UserSearch();
        userSearch.buscarUsuario(123456789);
        //assertEquals(123456789, userSearch.buscarUsuario(123456789));
    }
}