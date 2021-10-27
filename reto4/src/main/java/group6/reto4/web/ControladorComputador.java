package group6.reto4.web;

import group6.reto4.servicios.ServiciosComputador;
import group6.reto4.modelo.Computador;
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
 * clase controlador computador
 * @author grupo 6
 */
@RestController
@RequestMapping("/api/Computer")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ControladorComputador {
    /**
    * atributo
    * @author grupo 6
    */
    @Autowired
    private ServiciosComputador servicioComputador;
    /**
    * metodo obtener endpoint lista computador
    * @author grupo 6
    */
    @GetMapping("/all")
    public List<Computador> getComputers() {
        return servicioComputador.getAll();
    }
    /**
    * metodo obtener endpoint computador por id
    * @author grupo 6
    */
    @GetMapping("/{id}")
    public Optional<Computador> getComputer(@PathVariable("id") int computerId) {
        return servicioComputador.getComputer(computerId);
    }
    /**
    * metodo guardar endpoint computador
    * @author grupo 6
    */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Computador save(@RequestBody Computador computador) {
        return servicioComputador.save(computador);
    }
    /**
    * metodo actualizar endpoint computador
    * @author grupo 6
    */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Computador update(@RequestBody Computador computador) {
        return servicioComputador.update(computador);
    }
    /**
    * metodo borrar endpoint computador
    * @author grupo 6
    */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean  delete(@PathVariable("id") int computadorId) {
        return servicioComputador.deleteComputer(computadorId);
    }    
}
