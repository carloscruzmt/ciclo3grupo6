package group6.reto4.web;

import group6.reto4.modelo.Cliente;
import group6.reto4.servicios.ServiciosCliente;
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
 * clase controlador cliente
 * @author grupo 6
 */
@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ControladorCliente {
    /**
    * atributo
    * @author grupo 6
    */
    @Autowired
    private ServiciosCliente servicioCliente;
    /**
    * metodo obtener endpoint lista cliente
    * @author grupo 6
    */
    @GetMapping("/all")
    public List<Cliente> getClients() {
        return servicioCliente.getAll();
    }
    /**
    * metodo obtener endpoint cliente por id
    * @author grupo 6
    */
    @GetMapping("/{id}")
    public Optional<Cliente> getClient(@PathVariable("id") int clientId) {
        return servicioCliente.getClient(clientId);
    }
    /**
    * metodo guardar endpoint cliente
    * @author grupo 6
    */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@RequestBody Cliente client) {
        return servicioCliente.save(client);
    }
    /**
    * metodo actualizar endpoint cliente
    * @author grupo 6
    */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente update(@RequestBody Cliente client) {
        return servicioCliente.update(client);
    }
    /**
    * metodo borrar endpoint cliente
    * @author grupo 6
    */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int clientId) {
        return servicioCliente.deleteClient(clientId);
    }    
}
