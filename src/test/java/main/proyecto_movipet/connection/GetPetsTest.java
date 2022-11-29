package main.proyecto_movipet.connection;

import main.proyecto_movipet.model.Entidades.Mascota;
import main.proyecto_movipet.model.Entidades.Usuario;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GetPetsTest {

    @Test
    void asignarMascotas(Usuario usuario) {
        List<Mascota> listaMascotas = new ArrayList<>();
        Mascota mascota = new Mascota();
        mascota.setNombre("enzo");
        mascota.setTipo("gato");
        mascota.setRaza("N/R");
        mascota.setEdad(2);
        mascota.setComentarios("N/R");
        mascota.setIdCliente(1000183553);
        listaMascotas.add(mascota);
        usuario.setListaMascotas(listaMascotas);
    }
}