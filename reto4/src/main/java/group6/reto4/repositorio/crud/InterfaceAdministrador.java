package group6.reto4.repositorio.crud;

import group6.reto4.modelo.Administrador;
import org.springframework.data.repository.CrudRepository;

/**
 * interface crud administrador
 * @author grupo 6
 */
public interface InterfaceAdministrador extends CrudRepository<Administrador, Integer> {
    
}