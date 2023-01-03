package main.proyecto_movipet.connection;
import main.proyecto_movipet.model.Entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//ESTO ES DAO :v
public class Validar {
    Conexion conexion = Conexion.getInstance();
    public Usuario validarLogin(String user, String pass) {
        try {
            Connection conectar = conexion.conectar();
            GetPets getPets = new GetPets();
            Usuario usuario = new Usuario();
            PreparedStatement logIn = conectar.prepareStatement("SELECT * FROM movipet_db.clientes WHERE NombreDeUsuario = ? AND Password = ?");
            logIn.setString(1, user);
            logIn.setString(2, pass);
            ResultSet consulta = logIn.executeQuery();
            if (consulta.next()) {
                usuario.setCedula(consulta.getInt("cedula"));
                usuario.setNombre(consulta.getString("Nombre"));
                usuario.setCorreo(consulta.getString("Email"));
                usuario.setGenero(consulta.getString("Genero"));
                usuario.setEdad(consulta.getInt("Edad"));
                usuario.setCelular(consulta.getString("Celular"));
                usuario.setUsuario(consulta.getString("NombreDeUsuario"));
                usuario.setPassword(consulta.getString("Password"));
                getPets.AsignarMascotas(usuario);
                System.out.println(usuario);
                conexion.cerrarConexion();
                return usuario;
            }
            else {
                conexion.cerrarConexion();
                throw new RuntimeException("Usuario y contraseña no encontrado");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("Error al conectarse a la base de datos");
        }
    }
}
