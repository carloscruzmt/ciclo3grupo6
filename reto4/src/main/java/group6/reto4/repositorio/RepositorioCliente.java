package group6.reto4.repositorio;

import group6.reto4.modelo.Cliente;
import group6.reto4.repositorio.crud.InterfaceCliente;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * clase repositorio cliente
 * @author grupo 6
 */
@Repository
public class RepositorioCliente {
    /**
    * atributo
    * @author grupo 6
    */
    @Autowired
    private InterfaceCliente crudCliente;
    /**
    * metodo para obtener lista cliente
    * @author grupo 6
    */
    public List<Cliente> getAll() {
        return (List<Cliente>) crudCliente.findAll();
    }
    /**
    * metodo para obtener cliente por id
    * @author grupo 6
    */
    public Optional<Cliente> getCliente(int id) {
        return crudCliente.findById(id);
    }
    /**
    * metodo para guardar cliente
    * @author grupo 6
    */
    public Cliente save(Cliente cliente) {
        return crudCliente.save(cliente);
    }
    /**
    * metodo para borrar cliente
    * @author grupo 6
    */
    public void delete(Cliente cliente) {
        crudCliente.delete(cliente);
    }
}
