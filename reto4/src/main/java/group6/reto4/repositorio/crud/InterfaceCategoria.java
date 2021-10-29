package group6.reto4.repositorio.crud;

import group6.reto4.modelo.Categoria;
import org.springframework.data.repository.CrudRepository;

/**
 * interface crud categoria
 * @author grupo 6
 */
public interface InterfaceCategoria extends CrudRepository<Categoria, Integer> {
    
}
