package main.proyecto_movipet.model.Entidades.Facade;

import main.proyecto_movipet.model.Entidades.Decorator.IMenuModificaciones;
import main.proyecto_movipet.model.Entidades.Decorator.ModificacionEstandar;
import main.proyecto_movipet.model.Entidades.Decorator.ModificacionRegistroCompleto;
import main.proyecto_movipet.model.Entidades.ListaUsuarios;
import main.proyecto_movipet.model.Entidades.Mascota;
import main.proyecto_movipet.model.Entidades.Singleton.Logger;
import main.proyecto_movipet.model.Entidades.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static javafx.scene.input.KeyCode.ALT;

public class MenuAdministrador {

    Scanner scanner = new Scanner(System.in);

    // Se crea una instancia del Logger, pero como ya se instancio en la clase MenuPrincipal, tiene ese mismo mensaje por default
    Logger logger2 = Logger.getInstance();

    List<Mascota> listaMascotas = new ArrayList<>();

    public void llenarUsuario() {

        System.out.println(" --------------------------------- LLENAR DATOS DEL USUARIO POR CONSOLA  --------------------------------- ");
        System.out.println();
        System.out.print("Por favor digite el nombre del usuario: ");
        String nombre = scanner.next();
        System.out.print("Por favor digite el correo del usuario: ");
        String correo = scanner.next();
        System.out.print("Por favor digite la cedula del usuario: ");
        int cedula = scanner.nextInt();
        System.out.print("Por favor digite el genero del usuario: ");
        String genero = scanner.next();
        System.out.print("Por favor digite la edad del usuario: ");
        int edad = scanner.nextInt();
        System.out.print("Por favor digite el celular del usuario: ");
        String celular = scanner.next();
        System.out.print("Por favor digite el nombre de usuario de la persona: ");
        String nomUsu = scanner.next();
        System.out.print("Por favor digite la contrase"+ALT+165+"a del usuario: ");
        String password = scanner.next();
        System.out.println();
        System.out.println("Por favor digite los datos de su mascota: ");
        System.out.print("Por favor digite el id de la mascota: ");
        int nomMascota = scanner.nextInt(); ;
        System.out.print("Por favor digite el apodo de la mascota: ");
        String apodo = scanner.next();
        System.out.print("Por favor digite el tipo de la mascota (perro/gato): ");
        String tipo = scanner.next();
        System.out.print("Por favor digite el tipo la raza de la mascota: ");
        String raza = scanner.next();
        System.out.println("Tiene observaciones especiales sobre su mascota " + tipo + " (Si / No)");
        String resultado = scanner.next();
        String comentarios;
        if (resultado.equalsIgnoreCase("Si")) {
            System.out.println("Por favor digite las observaciones especiales de su mascota " + tipo + ": ");
            comentarios = scanner.next();
        } else {
            comentarios = null;
        }
        Mascota mascota = new Mascota();
        mascota.setId(nomMascota);
        mascota.setNombre(nombre);
        mascota.setApodo(apodo);
        mascota.setTipo(tipo);
        mascota.setRaza(raza);
        mascota.setComentarios(comentarios);
        listaMascotas.add(mascota);

        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setCorreo(correo);
        usuario.setCedula(cedula);
        usuario.setGenero(genero);
        usuario.setEdad(edad);
        usuario.setCelular(celular);
        usuario.setUsuario(nomUsu);
        usuario.setPassword(password);

        System.out.println("Sus datos fueron ingresados correctamente!");
        System.out.println();
        System.out.println(usuario);
    }
    // Creación de clases de busqueda para utilizar el patron de diseño Facade
    public class BuscarDatosId {

        public BuscarDatosId() {
        }

        public void buscarDatosId(String idBuscar) {

            boolean bandera = false;

            if (!bandera) {
                System.out.println( );
                System.out.println("No se encontro el id " + idBuscar + " de la persona en la base de datos");
            }
        }
    }

    public class BuscarDatosCedula {

        public BuscarDatosCedula() {
        }

        public void buscarDatosCedula(String idCedula) {
            boolean bandera = false;

            if (!bandera) {
                System.out.println("No se encontro la cedula " + idCedula + " en la base de datos");
            }
        }
    }

    public class BuscarDatosMascota {

        public BuscarDatosMascota() {
        }

        public void buscarDatosMascota(String idMascota) {
            boolean bandera = false;



            if (!bandera) {
                System.out.println("No se encontro la mascota identificada con el id " + idMascota + " en la base de datos");
                System.out.println( );
            }
        }
    }

    public class BuscarUsuarioFacade {

        private BuscarDatosId buscarId;
        private BuscarDatosCedula buscarCedula;
        private BuscarDatosMascota buscarMascota;

        public BuscarUsuarioFacade() {
            this.buscarId = new BuscarDatosId();
            this.buscarCedula = new BuscarDatosCedula();
            this.buscarMascota = new BuscarDatosMascota();
        }

        public void buscar(String idPersona, String cedula, String idMascota) {
            buscarId.buscarDatosId(idPersona);
            buscarCedula.buscarDatosCedula(cedula);
            buscarMascota.buscarDatosMascota(idMascota);
        }
    }

    public void modificarUsuario() {

        IMenuModificaciones menuModificaciones = new ModificacionEstandar( );

        int opcion = 0;

        do {
            System.out.println(" --------------------------------- MODIFICAR USUARIO CON DECORATOR  --------------------------------- ");
            System.out.println("1. Modificar Login");
            System.out.println("2. Modificar Login + Correo y Celular");
            System.out.println("3. Volver al menu anterior");
            System.out.print("Por favor seleccione su opcion: ");
            opcion = scanner.nextInt();
            System.out.println();

            switch (opcion) {

                case 1: {
                    System.out.print("Por favor digite el id del usuario que quiere modificar: ");
                    String idBuscar2 = scanner.next();
                    System.out.print("Por favor digite el nuevo nombre de usuario: ");
                    String nombreNuevo = scanner.next();
                    System.out.print("Por favor digite la nueva contrasena del usuario: ");
                    String contraNueva = scanner.next();
                    System.out.println( );
                    //menuModificaciones.modificarLogin(listaUsuarios, idBuscar2, nombreNuevo, contraNueva);
                    System.out.println( );
                    System.out.println("La modificacion se realizo satisfactoriamente!");
                    System.out.println( );

                    break;
                }

                case 2: {
                    System.out.print("Por favor digite el id del usuario que quiere modificar: ");
                    String idBuscar2 = scanner.next();
                    System.out.print("Por favor digite el nuevo nombre de usuario: ");
                    String nombreNuevo = scanner.next();
                    System.out.print("Por favor digite la nueva contrasena del usuario: ");
                    String contraNueva = scanner.next();
                    menuModificaciones = new ModificacionRegistroCompleto(menuModificaciones);
                    //menuModificaciones.modificarLogin(listaUsuarios, idBuscar2, nombreNuevo, contraNueva);
                    System.out.println( );
                    System.out.println("La modificacion se realizo satisfactoriamente!");
                    System.out.println( );

                }

                case 3: {

                    break;
                }

                default: {
                    System.out.println(logger2.getMensaje( ));
                    System.out.println();
                    System.out.println();
                    break;
                }
            }
        }while (opcion != 3);
    }


    public void menuAdministrador( ) {

        int opcion = 0;

        do {
            System.out.println(" --------------------------------- MENU ADMINISTRADOR  --------------------------------- ");
            System.out.println("1. Llenar Usuario");
            System.out.println("2. Buscar Usuario");
            System.out.println("3. Modificar Usuario");
            System.out.println("4. Imprimir Usuarios");
            System.out.println("5. Volver al menu anterior");
            System.out.print("Por favor seleccione su opcion: ");
            opcion = scanner.nextInt();
            System.out.println();

            switch (opcion) {

                case 1: {
                    llenarUsuario();
                    System.out.println();
                    System.out.println();
                    break;
                }

                case 2: {
                    System.out.print("Por favor digite el id de la persona que quiere buscar: ");
                    String idBuscar = scanner.next();
                    BuscarDatosId aux = new BuscarDatosId ();
                    aux.buscarDatosId(idBuscar);
                    System.out.print("Por favor digite la cedula de la persona que quiere buscar: ");
                    String cedula = scanner.next();
                    System.out.print("Por favor digite el id de la mascota que quiere buscar: ");
                    String idMascota = scanner.next();

                    // Se crea la clase BuscarUsuarioFacade que fue donde se implemento el patron
                    BuscarUsuarioFacade cliente = new BuscarUsuarioFacade();
                    // Se hace el llamado a la funcion de la clase
                    cliente.buscar(idBuscar, cedula, idMascota);

                    System.out.println();
                    System.out.println();
                    break;
                }

                case 3: {
                    modificarUsuario();
                    System.out.println();
                    System.out.println();
                    break;
                }

                case 4: {
                    break;
                }

                case 5: {
                    break;
                }

                default: {
                    System.out.println(logger2.getMensaje( ));
                    System.out.println();
                    System.out.println();
                    break;
                }
            }
        } while (opcion != 5);
    }
}

