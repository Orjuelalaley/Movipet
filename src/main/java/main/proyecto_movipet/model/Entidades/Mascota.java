package main.proyecto_movipet.model.Entidades;

import lombok.Data;

@Data
public class Mascota {
    private int id;
    private String nombre;
    private String apodo;
    private String tipo;
    private String raza;
    private int edad;
    private String comentarios;
    private int idCliente;
}
