package group6.reto4.repositorio;

import group6.reto4.modelo.Administrador;
import group6.reto4.repositorio.crud.InterfaceAdministrador;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * clase repositorio administrador
 * @author grupo 6
 */
@Repository
public class RepositorioAdministrador {
    /**
    * atributo
    * @author grupo 6
    */
    @Autowired
    private InterfaceAdministrador crudAdmin;
    /**
    * metodo para obtener lista administrador
    * @author grupo 6
    */
    public List<Administrador> getAll() {
        return (List<Administrador>) crudAdmin.findAll();
    }
    /**
    * metodo para obtener administrador por id
    * @author grupo 6
    */
    public Optional<Administrador> getAdministrador(int id) {
        return crudAdmin.findById(id);
    }
    /**
    * metodo para guardar administrador
    * @author grupo 6
    */
    public Administrador save(Administrador administrador) {
        return crudAdmin.save(administrador);
    }
    /**
    * metodo para borrar administrador
    * @author grupo 6
    */
    public void delete(Administrador administrador) {
        crudAdmin.delete(administrador);
    }    
}
