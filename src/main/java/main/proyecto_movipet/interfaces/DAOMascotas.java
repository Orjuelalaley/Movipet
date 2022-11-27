package main.proyecto_movipet.interfaces;

import main.proyecto_movipet.model.Entidades.Mascota;

public interface DAOMascotas {
    public void registrarMascota(String nombre,String apodo, String tipo, String raza, int edad, String comentarios);

}
