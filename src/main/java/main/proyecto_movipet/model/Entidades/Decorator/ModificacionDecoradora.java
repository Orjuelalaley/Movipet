package main.proyecto_movipet.model.Entidades.Decorator;

// Ya tiene implementado los metodos de la interfaz, solo se le agregan estos nuevos metodos
public abstract class ModificacionDecoradora implements IMenuModificaciones {

    private IMenuModificaciones menu;

    public ModificacionDecoradora (IMenuModificaciones menu ) {
        this.menu = menu;
    }

    // Este metodo solo lo pueden utilizar las clases que hereden de ModificacionDecoradora
    protected IMenuModificaciones getMenu ( ) {
        return  menu;
    }
}
