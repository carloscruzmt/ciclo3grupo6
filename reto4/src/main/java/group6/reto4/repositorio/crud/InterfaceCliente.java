package group6.reto4.repositorio.crud;


import group6.reto4.modelo.Cliente;
import org.springframework.data.repository.CrudRepository;

/**
 * interface crud cliente
 * @author grupo 6
 */
public interface InterfaceCliente extends CrudRepository<Cliente, Integer> {
    
}