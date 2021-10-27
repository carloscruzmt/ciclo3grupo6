package group6.reto4.servicios;

import group6.reto4.repositorio.RepositorioComputador;
import group6.reto4.modelo.Computador;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * clase servicios computador
 * @author grupo 6
 */
@Service
public class ServiciosComputador {
    /**
    * atributo
    * @author grupo 6
    */
    @Autowired
    private RepositorioComputador repoComputador;
    /**
    * metodo obtener lista computador
    * @author grupo 6
    */
    public List<Computador> getAll() {
        return repoComputador.getAll();
    }
    /**
    * metodo obtener opcional computador por id
    * @author grupo 6
    */
    public Optional<Computador> getComputer(int computerId) {
        return repoComputador.getComputer(computerId);
    }
    /**
    * metodo guardar computador condicional
    * @author grupo 6
    */
    public Computador save(Computador computer) {
        if (computer.getId() == null) {
            return repoComputador.save(computer);
        }
        else {
            Optional<Computador> e = repoComputador.getComputer(computer.getId());
            if(e.isEmpty()) {
                return repoComputador.save(computer);
            }
            else {
                return computer;
            }
        }
    }
    /**
    * metodo actualizar computador condicional
    * @author grupo 6
    */
    public Computador update(Computador computer) {
        if (computer.getId() != null) {
            Optional<Computador> e = repoComputador.getComputer(computer.getId());
            if (!e.isEmpty()) {
                if (computer.getName() != null) {
                    e.get().setName(computer.getName());
                }
                if (computer.getBrand() != null) {
                    e.get().setBrand(computer.getBrand());
                }
                if (computer.getYear() != null) {
                    e.get().setYear(computer.getYear());
                }
                if (computer.getDescription() != null) {
                    e.get().setDescription(computer.getDescription());
                }
                if (computer.getCategory() != null) {
                    e.get().setCategory(computer.getCategory());
                }
                repoComputador.save(e.get());
                return e.get();
            }
            else {
                return computer;
            }
        }
        else {
            return computer;
        }            
    }    
    /**
    * metodo borrar computador condicional 
    * return boolean
    * @author grupo 6
    */
    public boolean deleteComputer(int computerId) {
        Boolean aBoolean = getComputer(computerId).map(computer -> {
            repoComputador.delete(computer);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
