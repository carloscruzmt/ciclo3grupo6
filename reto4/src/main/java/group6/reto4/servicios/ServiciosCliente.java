package group6.reto4.servicios;

import group6.reto4.modelo.Cliente;
import group6.reto4.repositorio.RepositorioCliente;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * clase servicios cliente
 * @author grupo 6
 */
@Service
public class ServiciosCliente {
    /**
    * atributo
    * @author grupo 6
    */
    @Autowired
    private RepositorioCliente repoCliente;
    /**
    * metodo obtener lista cliente
    * @author grupo 6
    */
    public List<Cliente> getAll() {
        return repoCliente.getAll();
    }
    /**
    * metodo obtener cliente por id
    * @author grupo 6
    */
    public Optional<Cliente> getClient(int clienteId) {
        return repoCliente.getCliente(clienteId);
    }
    /**
    * metodo guardar cliente condicional
    * @author grupo 6
    */
    public Cliente save(Cliente client) {
        if (client.getIdClient() == null) {
            return repoCliente.save(client);
        }
        else {
            Optional<Cliente> e = repoCliente.getCliente(client.getIdClient());
            if (e.isEmpty()) {
                return repoCliente.save(client);
            }
            else {
                return client;
            }
        }
    }
    /**
    * metodo actualizar cliente condicional
    * @author grupo 6
    */
    public Cliente update(Cliente client) {
        if (client.getIdClient() != null) {
            Optional<Cliente> e = repoCliente.getCliente(client.getIdClient());
            if (!e.isEmpty()) {
                if (client.getName() != null) {
                    e.get().setName(client.getName());
                }
                if (client.getAge() != null) {
                    e.get().setAge(client.getAge()); 
                }
                if (client.getPassword() != null) {
                    e.get().setPassword(client.getPassword());
                }
                repoCliente.save(e.get());
                return e.get();
            }
            else {
                return client;
            }
        }
        else {
            return client;
        }
    }
    /**
    * metodo borrar cliente 
    * return boolean
    * @author grupo 6
    */
    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            repoCliente.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
