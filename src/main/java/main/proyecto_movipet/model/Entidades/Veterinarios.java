package main.proyecto_movipet.model.Entidades;

public class Veterinarios {
    private String nombre;
    private String correo;
    private int cedula;
    private String celular;
    private float precioServicio;

    public Veterinarios(String nombre, String correo, int cedula, String celular, float precioServicio) {
        this.nombre = nombre;
        this.correo = correo;
        this.cedula = cedula;
        this.celular = celular;
        this.precioServicio = precioServicio;
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public float getPrecioServicio() {
        return precioServicio;
    }

    public void setPrecioServicio(float precioServicio) {
        this.precioServicio = precioServicio;
    }

    @Override
    public String toString() {
        return "Veterinarios{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", cedula=" + cedula +
                ", celular='" + celular + '\'' +
                ", precioServicio=" + precioServicio +
                '}';
    }
}
