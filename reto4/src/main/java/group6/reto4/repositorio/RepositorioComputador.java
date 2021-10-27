package group6.reto4.repositorio;


import group6.reto4.repositorio.crud.InterfaceComputador;
import group6.reto4.modelo.Computador;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * clase repositorio computador
 * @author grupo 6
 */
@Repository
public class RepositorioComputador {
    /**
    * atributo
    * @author grupo 6
    */
    @Autowired
    private InterfaceComputador crudComputador;
    /**
    * metodo para obtener lista computador
    * @author grupo 6
    */
    public List<Computador> getAll() {
        return (List<Computador>) crudComputador.findAll();
    }
    /**
    * metodo para obtener computador por id
    * @author grupo 6
    */
    public Optional<Computador> getComputer(int id) {
        return crudComputador.findById(id);
    }
    /**
    * metodo para guardar computador
    * @author grupo 6
    */
    public Computador save(Computador computer) {
        return crudComputador.save(computer);
    }
    /**
    * metodo para borrar computador
    * @author grupo 6
    */
    public void delete(Computador computer) {
        crudComputador.delete(computer);
    }
    
}
