package main.proyecto_movipet.interfaces;

import main.proyecto_movipet.connection.RegPetInBD;
import main.proyecto_movipet.model.Entidades.Mascota;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DAOMascotasImplementacion implements DAOMascotas {

    @Override
    public void registrarMascota(Mascota mascota) {
        RegPetInBD regPetInBD = new RegPetInBD();
        regPetInBD.registrarMascota(mascota);
    }
}
