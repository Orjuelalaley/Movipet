package main.proyecto_movipet.model.Entidades.Facade;

import main.proyecto_movipet.model.Entidades.Singleton.Logger;


import java.util.Scanner;

public class MenuPrincipal {

    public MenuPrincipal() {
    }

    public void menuPrincipal ( ) {
        Scanner scanner = new Scanner(System.in);

        // Creación del patron de diseño Singleton
        Logger logger = Logger.getInstance();
        logger.setMensaje("Selecciono una opcion incorrecta. Por favor digite una opcion valida");

        MenuAdministrador menu = new MenuAdministrador( );
        MenuUsuario menu2 = new MenuUsuario( );

        int opcion = 0;
        do
        {
            System.out.println( " --------------------------------- MENU APLICACION MOVIPET  --------------------------------- " );
            System.out.println("1. Modo Usuario");
            System.out.println("2. Modo Administrador");
            System.out.println( "3. Salir de la Aplicacion");
            System.out.print("Por favor seleccione su opcion: ");
            opcion = scanner.nextInt();
            System.out.println();

            switch (opcion)
            {
                case 1:
                {
                    System.out.println("Modo Usuario");
                    try {
                        menu2.menuUsuario();
                    }catch (Exception e){
                        System.err.println("El error esta en " + e.getMessage());
                    }

                    System.out.println();
                    System.out.println();
                    break;
                }
                case 2:
                {
                    menu.menuAdministrador( );
                    System.out.println();
                    System.out.println();
                    break;
                }
                case 3:
                {
                    System.out.println("Muchas gracias por haber utilizado la aplicacion MOVIPET");
                    System.out.println("Esperamos vuelva pronto!");
                    break;
                }
                default:
                {
                    // Implementacion del patron de diseño Singleton
                    System.out.println(logger.getMensaje( ));
                }
            }
        }while (opcion != 3);
    }
}

