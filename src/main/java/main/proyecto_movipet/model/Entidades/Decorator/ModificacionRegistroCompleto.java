package main.proyecto_movipet.model.Entidades.Decorator;



import main.proyecto_movipet.model.Entidades.ListaUsuarios;
import main.proyecto_movipet.model.Entidades.Usuario;

import java.util.Scanner;

public class ModificacionRegistroCompleto extends ModificacionDecoradora {

    Scanner scanner = new Scanner(System.in);

    public ModificacionRegistroCompleto (IMenuModificaciones menu ){
        super (menu);
    }

    // Ahora no solamente modifica los parametros del login del usuario, sino tambien su celular y correo
    @Override
    public void modificarLogin(ListaUsuarios listaUsuarios, String idBuscar, String nomUsuarioNuevo, String contraNueva) {

        getMenu( ).modificarLogin(listaUsuarios,idBuscar,nomUsuarioNuevo, contraNueva);
        boolean bandera = false;

        System.out.print("Por favor digite el nuevo correo para que sea modificado: ");
        String nuevoCorreo = scanner.next( );
        System.out.print("Por favor digite el nuevo telefono para que sea modificado: ");
        String nuevoTel = scanner.next( );
        System.out.println( );

        for (Usuario usuario : listaUsuarios.getListaUsuarios()) {
            if (idBuscar.equals(usuario.getId())) {
                bandera = true;
                usuario.setCelular(nuevoTel);
                usuario.setCorreo(nuevoCorreo);
            }
        }

        if (!bandera) {
            System.out.println("No se encontró el id " + idBuscar + " en la base de datos");
        }
    }
}

