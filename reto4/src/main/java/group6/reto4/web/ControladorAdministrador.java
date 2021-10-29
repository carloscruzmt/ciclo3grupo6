package group6.reto4.web;

import group6.reto4.modelo.Administrador;
import group6.reto4.servicios.ServiciosAdministrador;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/**
 * clase controlador administrador
 * @author grupo 6
 */
@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ControladorAdministrador {
    /**
    * atributo
    * @author grupo 6
    */
    @Autowired
    private ServiciosAdministrador servicioAdmin;
    /**
    * metodo obtener endpoint lista administradores
    * @author grupo 6
    */
    @GetMapping("/all")
    public List<Administrador> getAdministradores() {
        return servicioAdmin.getAll();
    }
    /**
    * metodo obtener endpoint opcional administrador por id 
    * @author grupo 6
    */
    @GetMapping("/{id}")
    public Optional<Administrador> getAdministrador(@PathVariable("id") int adminId) {
        return servicioAdmin.getAdministrador(adminId);
    }
    /**
    * metodo guardar endpoint administrador
    * @author grupo 6
    */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Administrador save(@RequestBody Administrador administrador) {
        return servicioAdmin.save(administrador);
    } 
    /**
    * metodo actualizar endpoint categoria
    * @author grupo 6
    */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Administrador update(@RequestBody Administrador administrador) {
        return servicioAdmin.update(administrador);
    }
    /**
    * metodo borrar endpoint categoria
    * @author grupo 6
    */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int administradorId) {
        return servicioAdmin.deleteAdministrador(administradorId);
    }    
}
