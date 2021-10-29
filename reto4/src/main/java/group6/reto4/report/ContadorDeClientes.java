package group6.reto4.report;

import group6.reto4.modelo.Cliente;

/**
 * Clase para contabilizar a los clientes.
 * @author Grupo 6
 */
public class ContadorDeClientes {
    /**
    * atributo numero tipo long
    * @author Grupo 6
    */
    private Long total;
    /**
    * atributo objeto tipo Cliente
    * @author Grupo 6
    */
    private Cliente client;
    /**
    * constructor de la clase
    * @author Grupo 6
    */
    public ContadorDeClientes(Long total, Cliente client) {
        this.total = total;
        this.client = client;
    }
    /**
    * metodo obtener cantidad clientes
    * return cantidad de clientes
    * @author Grupo 6
    */
    public Long getTotal() {
        return total;
    }
    /**
    * metodo editar cantidad clientes
    * return cantidad de clientes
    * @author Grupo 6
    */
    public void setTotal(Long total) {
        this.total = total;
    }
    /**
    * metodo obtener cliente
    * return cliente
    * @author Grupo 6
    */
    public Cliente getClient() {
        return client;
    }
    /**
    * metodo editar cliente
    * return cliente
    * @author Grupo 6
    */
    public void setClient(Cliente client) {
        this.client = client;
    }
      
}
