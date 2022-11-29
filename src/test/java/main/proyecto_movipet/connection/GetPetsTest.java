package main.proyecto_movipet.connection;

import main.proyecto_movipet.model.Entidades.Mascota;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetPetsTest {

    @Test
    void asignarMascotas() {
        GetPets getPets = new GetPets();
        Mascota mascota = new Mascota();
        mascota.setNombre("enzo");
        mascota.setTipo("gato");
        mascota.setRaza("N/R");
        mascota.setEdad(2);
        mascota.setComentarios("N/R");
        mascota.setIdCliente(1000183553);
    }
}