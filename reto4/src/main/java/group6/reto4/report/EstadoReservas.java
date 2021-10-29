package group6.reto4.report;

/**
 *
 * @author Grupo 6
 */
public class EstadoReservas {
    /**
    * Atributo tipo entero 
    * @author Grupo 6
    */
    private int completed;
    /**
    * Atributo tipo entero 
    * @author Grupo 6
    */
    private int cancelled;
    /**
    * constructor de la clase
    * @author Grupo 6
    */
    public EstadoReservas(int completed, int cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }
    /**
    * metodo obtener reserva completada
    * return cantidad reservas completadas
    * @author Grupo 6
    */
    public int getCompleted() {
        return completed;
    }
    /**
    * metodo editar reserva completada
    * return cantidad reservas completadas
    * @author Grupo 6
    */
    public void setCompleted(int completed) {
        this.completed = completed;
    }
    /**
    * metodo obtener reserva cancelada
    * return cantidad reservas canceladas
    * @author Grupo 6
    */
    public int getCancelled() {
        return cancelled;
    }
    /**
    * metodo editar reserva cancelada
    * return cantidad reservas canceladas
    * @author Grupo 6
    */
    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }
       
}
