package main.proyecto_movipet.model.Entidades.Facade;

import main.proyecto_movipet.connection.UserSearch;

public class BuscarDatosId {
    public void buscarDatosId(String idBuscar) {
        UserSearch userSearch = new UserSearch();
        System.out.println(" --------------------------------- BUSCAR DATOS POR ID  --------------------------------- ");
        System.out.println();
        boolean bandera = userSearch.buscarUsuario(Integer.parseInt(idBuscar));
        System.out.println( );
        if (!bandera) {
            System.out.println("No se encontro el id " + idBuscar + " de la persona en la base de datos");
        }else{
            System.out.println("Se encontro el id " + idBuscar + " de la persona en la base de datos");
        }
    }
}
