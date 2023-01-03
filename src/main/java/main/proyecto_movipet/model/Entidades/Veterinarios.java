package main.proyecto_movipet.model.Entidades;

import lombok.Data;

@Data
public class Veterinarios {
    private String nombre;
    private String correo;
    private int cedula;
    private String celular;
    private float precioServicio;
}
