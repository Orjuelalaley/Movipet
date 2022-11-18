package main.proyecto_movipet.model.Entidades;

public class Mascota {
    private String id;
    private String apodo;
    private String tipo;
    private String raza;
    private int edad;
    private String comentarios;

    public Mascota() {
    }

    public Mascota(String id, String apodo, String tipo, String raza, int edad, String comentarios) {
        this.id = id;
        this.apodo = apodo;
        this.tipo = tipo;
        this.raza = raza;
        this.edad = edad;
        this.comentarios = comentarios;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        return
        "Id: " + id +"\n"  +
        "Apodo: " + apodo +"\n"  +
        "Tipo: " + tipo + "\n"  +
        "Raza: " + raza + "\n"  +
        "Edad: " + edad + "\n" +
        "Comentarios Generales: " + comentarios + "\n" ;
    }
}
