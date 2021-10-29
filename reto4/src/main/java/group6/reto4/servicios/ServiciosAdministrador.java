package group6.reto4.servicios;

import group6.reto4.modelo.Administrador;
import group6.reto4.repositorio.RepositorioAdministrador;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * clase servicios administrador
 * @author grupo 6
 */
@Service
public class ServiciosAdministrador {
    /**
    * atributo
    * @author grupo 6
    */
    @Autowired
    private RepositorioAdministrador repoAdmin;
    /**
    * metodo obtener lista administrador
    * @author grupo 6
    */
    public List<Administrador> getAll() {
        return repoAdmin.getAll();
    }
    /**
    * metodo obtener opcional por id
    * @author grupo 6
    */
    public Optional<Administrador> getAdministrador(int adminId) {
        return repoAdmin.getAdministrador(adminId);
    }
    /**
    * metodo guardar administrador condicional
    * @author grupo 6
    */
    public Administrador save(Administrador administrador) {
        if (administrador.getIdAdmin() == null) {
            return repoAdmin.save(administrador);
        }
        else {
            Optional<Administrador> admin = repoAdmin.getAdministrador(administrador.getIdAdmin());
            if (admin.isEmpty()) {
                return repoAdmin.save(administrador);
            }
            else {
                return administrador;
            }
        }
    } 
    
     /**
    * metodo actualizar categoria condicional
    * @author grupo 6
    */
    public Administrador update(Administrador administrador) {
        if (administrador.getIdAdmin() != null) {
            Optional<Administrador> g = repoAdmin.getAdministrador(administrador.getIdAdmin());
            if (!g.isEmpty()) {
                if (administrador.getName() != null) {
                    g.get().setName(administrador.getName());
                }
                if (administrador.getEmail() != null) {
                    g.get().setEmail(administrador.getEmail());
                }
                if (administrador.getPassword() != null) {
                    g.get().setPassword(administrador.getPassword());
                }
                return repoAdmin.save(g.get());
            }
        }
        return administrador;
    }
    /**
    * metodo borrar categoria por id 
    * return boolean
    * @author grupo 6
    */
    public boolean deleteAdministrador(int idAdmin) {
        Boolean d = getAdministrador(idAdmin).map(administrador -> {
            repoAdmin.delete(administrador);
            return true;
        }).orElse(false);
        return d;
    }
}



