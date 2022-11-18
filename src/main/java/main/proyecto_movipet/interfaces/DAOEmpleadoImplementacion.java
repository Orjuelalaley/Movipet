/*package main.proyecto_movipet.interfaces;

import com.example.dao.DAO.Conexion;
import com.example.dao.business.empleado;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAOEmpleadoImplementacion implements DAOUsuario {
    Conexion conexion = Conexion.getInstance();
    @Override
    public boolean iniciarSesion(empleado emp) {

        try {
            Connection conectar = conexion.conectar();
            PreparedStatement logIn = conectar.prepareStatement("SELECT * FROM bd_empleados.empleados WHERE id = ? AND username = ?");
            logIn.setInt(1,emp.getId());
            logIn.setString(2, emp.getUsername());
            ResultSet consulta = logIn.executeQuery();
            if (consulta.next()) {
                emp.setId(consulta.getInt("id"));
                emp.setNombre(consulta.getString("nombre"));
                System.out.println(emp);
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Bienvenido");
                alerta.setHeaderText("Bienvenido " + emp.getNombre());
                alerta.showAndWait();
                conexion.cerrarConexion();
                return true;
            }else {
                Alert alerta = new Alert(Alert.AlertType.WARNING);
                alerta.setTitle("Error");
                alerta.setHeaderText("El usuario o la contraseña son incorrectos");
                alerta.showAndWait();
                conexion.cerrarConexion();
                return false;
            }
        } catch (Exception e ) {
            System.err.println(e.getMessage());
        }
        return false;
    }
    @Override
    public void registrar(empleado emp) {
        try {
            Connection conectar = conexion.conectar();
            PreparedStatement insertar = conectar.prepareStatement("INSERT INTO bd_empleados.empleados  VALUES (?,?)");
            insertar.setInt(1, emp.getId());
            insertar.setString(2, emp.getNombre());
            if (insertar.executeUpdate() > 0){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Registro");
                alert.setHeaderText("Registro exitoso");
                alert.setContentText("El registro se ha realizado con éxito");
                alert.showAndWait();
                conexion.cerrarConexion();
            }
        } catch (Exception e ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Registro");
            alert.setHeaderText("Registro fallido");
            alert.setContentText("El ID ya se encuentra en uso");
            alert.showAndWait();
        }
    }

    @Override
    public void modificar(empleado empleado) {
        try {
            Connection conectar = conexion.conectar();
            PreparedStatement modificar = conectar.prepareStatement("UPDATE test_dao.test_empleado SET nombre = ? WHERE idtest_empleados = ?");
            modificar.setString(1, empleado.getNombre());
            modificar.setInt(2, empleado.getId());
            modificar.executeUpdate();
            conexion.cerrarConexion();
        } catch (Exception e ) {
            System.err.println("Error al modificar empleado" + e.getMessage());
        }
    }

    @Override
    public void eliminar(empleado empleado) {
        try {
            Connection conectar = conexion.conectar();
            PreparedStatement eliminar = conectar.prepareStatement("DELETE FROM test_dao.test_empleado WHERE idtest_empleados = ?");
            eliminar.setInt(1, empleado.getId());
            eliminar.executeUpdate();
            conexion.cerrarConexion();
        } catch (Exception e ) {
            System.err.println("Error al eliminar empleado" + e.getMessage());
        }
    }

    @Override
    public void buscar(empleado emp) {
        try {
            Connection conectar = conexion.conectar();
            PreparedStatement buscar = conectar.prepareStatement("SELECT * FROM test_dao.test_empleado WHERE idtest_empleados = ?");
            buscar.setInt(1, emp.getId());
            buscar.executeQuery();
            ResultSet consulta = buscar.executeQuery();
            if (consulta.next()) {
                emp.setId(consulta.getInt("idtest_empleados"));
                emp.setNombre(consulta.getString("nombre"));
            }
            conexion.cerrarConexion();
        } catch (Exception e ) {
            System.err.println("Error al buscar empleado" + e.getMessage());
        }
    }
}*/
