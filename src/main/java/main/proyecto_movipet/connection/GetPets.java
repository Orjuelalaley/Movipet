package main.proyecto_movipet.connection;

import main.proyecto_movipet.model.Entidades.Mascota;
import main.proyecto_movipet.model.Entidades.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GetPets {
    Conexion conexion = Conexion.getInstance();

    public void AsignarMascotas(Usuario usuario) {

        try {
            Mascota mascota = new Mascota();
            Connection conectar = conexion.conectar();
            List<Mascota> listaMascotas = new ArrayList<>();
            PreparedStatement pets = conectar.prepareStatement("SELECT * FROM movipet_db.mascotas WHERE FK_id = ?");
            pets.setInt(1, usuario.getCedula());
            ResultSet consulta = pets.executeQuery();
            while (consulta.next()) {
                mascota.setId(consulta.getInt("FK_id"));
                mascota.setNombre(consulta.getString("Nombre"));
                mascota.setApodo(consulta.getString("Apodo"));
                mascota.setTipo(consulta.getString("Tipo"));
                mascota.setRaza(consulta.getString("Raza"));
                mascota.setEdad(consulta.getInt("Edad"));
                mascota.setComentarios(consulta.getString("Comentarios"));
                if (mascota != null) {
                    listaMascotas.add(mascota);
                    usuario.setListaMascotas(listaMascotas);
                }
            }
        } catch (Exception e) {

            System.out.println("Error al obtener mascotas "+e.getMessage());

        }
    }
}
