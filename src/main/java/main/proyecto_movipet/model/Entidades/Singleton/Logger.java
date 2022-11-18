package main.proyecto_movipet.model.Entidades.Singleton;

// Esta clase se utiliza para mandar logs a la consola utilizando el patron de diseño Singletón
// Solo se puede crear una instancia de esta clase

public class Logger {

    // El constructor debe ser privado para que sea inaccesible la creación de instancias de esta clase
    private Logger( ) {   }

    private static Logger log;
    private String mensaje;

    public static Logger getInstance( ){
        if (log == null){
            log = new Logger ( );
        }
        return log;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
