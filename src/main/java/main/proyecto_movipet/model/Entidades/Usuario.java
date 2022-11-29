package main.proyecto_movipet.model.Entidades;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Usuario {

    private String nombre;
    private String correo;
    private int cedula;
    private String genero;
    private int edad;
    private String celular;
    private String usuario;

    private String Password;
    private List<Mascota> listaMascotas;

}
