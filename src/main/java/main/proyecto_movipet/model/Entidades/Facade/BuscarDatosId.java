package main.proyecto_movipet.model.Entidades.Facade;

import main.proyecto_movipet.connection.UserSearch;

public class BuscarDatosId {
    public void buscarDatosId(String idBuscar) {
        System.out.println(" --------------------------------- BUSCAR DATOS POR ID  --------------------------------- ");
        System.out.println();
        UserSearch userSearch = new UserSearch();
        userSearch.buscarUsuario(Integer.parseInt(idBuscar));

        boolean bandera = false;


        if (!bandera) {
            System.out.println( );
            System.out.println("No se encontro el id " + idBuscar + " de la persona en la base de datos");
        }
    }
}
