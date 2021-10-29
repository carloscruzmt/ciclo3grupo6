package group6.reto4.repositorio.crud;

import group6.reto4.modelo.Mensaje;
import org.springframework.data.repository.CrudRepository;


/**
 * interface crud mensaje
 * @author grupo 6
 */
public interface InterfaceMensaje extends CrudRepository<Mensaje, Integer> {
    
}