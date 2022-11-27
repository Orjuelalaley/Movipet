package main.proyecto_movipet.model.Entidades;

import java.util.LinkedList;
import java.util.List;

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

    public Usuario() {
    }

    public Usuario(String nombre, String correo, int cedula, String genero, int edad, String celular, String usuario,String Password ){
        this.nombre = nombre;
        this.correo = correo;
        this.cedula = cedula;
        this.genero = genero;
        this.edad = edad;
        this.celular = celular;
        this.usuario = usuario;
        this.Password = Password;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public List<Mascota> getListaMascotas() {
        return listaMascotas;
    }

    public void setListaMascotas(List<Mascota> listaMascotas) {
        this.listaMascotas = listaMascotas;
    }

    @Override
    public String toString() {
        return
            "Nombre: " + nombre + "\n" +
            "Correo: " + correo +"\n" +
            "Cedula: " + cedula + "\n" +
            "Genero: " + genero +"\n" +
            "Edad: " + edad + "\n" +
            "Celular: " + celular + "\n" +
            "Usuario: " + usuario +"\n" +
            "Contrasena: " + Password +"\n" +
            "Lista de Mascotas: " + "\n" +  listaMascotas + "\n";
    }
}
