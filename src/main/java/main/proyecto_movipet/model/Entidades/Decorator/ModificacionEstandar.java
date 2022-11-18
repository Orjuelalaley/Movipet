package main.proyecto_movipet.model.Entidades.Decorator;



import main.proyecto_movipet.model.Entidades.ListaUsuarios;
import main.proyecto_movipet.model.Entidades.Usuario;

import java.util.Scanner;

public class ModificacionEstandar implements IMenuModificaciones {

    Scanner scanner = new Scanner(System.in);

    public ModificacionEstandar ( ){

    }

    @Override

    public void modificarLogin(ListaUsuarios listaUsuarios, String idBuscar, String nombreNuevo, String contraNueva) {
        boolean bandera = false;

        for (Usuario usuario : listaUsuarios.getListaUsuarios()) {
            if (idBuscar.equals(usuario.getId())) {
                bandera = true;
                usuario.setUsuario(nombreNuevo);
                usuario.setPassword(contraNueva);
            }
        }

        if (!bandera) {
            System.out.println("No se encontro el id " + idBuscar + " en la base de datos");
        }
    }

}
