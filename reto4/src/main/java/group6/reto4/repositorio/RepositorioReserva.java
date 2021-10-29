package group6.reto4.repositorio;

import group6.reto4.modelo.Cliente;
import group6.reto4.modelo.Reserva;
import group6.reto4.report.ContadorDeClientes;
import group6.reto4.repositorio.crud.InterfaceReserva;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * clase repositorio reservaciones
 * @author grupo 6
 */
@Repository
public class RepositorioReserva {
    /**
    * atributo
    * @author grupo 6
    */
    @Autowired
    private InterfaceReserva crudReservaciones;
    /**
    * metodo para obtener lista reservaciones
    * @author grupo 6
    */
    public List<Reserva> getAll() {
        return (List<Reserva>) crudReservaciones.findAll();
    }
    /**
    * metodo para obtener reservacion por id
    * @author grupo 6
    */
    public Optional<Reserva> getReservation(int id) {
        return crudReservaciones.findById(id);
    }
    /**
    * metodo para guardar reserva
    * @author grupo 6
    */
    public Reserva save(Reserva reservation) {
        return crudReservaciones.save(reservation);
    }
    /**
    * metodo para borrar reserva
    * @author grupo 6
    */
    public void delete(Reserva reservation) {
        crudReservaciones.delete(reservation);
    }    
    /**
    * metodo obtener reserva por estado
    * return reservas por estado
    * @author grupo 6
    */
    public List<Reserva> getReservationByStatus(String status) {
        return  crudReservaciones.findAllByStatus(status);
    }
    /**
    * metodo obtener reserva por fecha
    * return reservas por fecha
    * @author grupo 6
    */
    public List<Reserva> getReservationPeriod(Date a, Date b) {
        return crudReservaciones.findAllByStartDateAfterAndStartDateBefore(a, b);
    }
    /**
    * metodo obtener clientes por calificacion
    * return clientes por calificacion
    * @author grupo 6
    */
    public List<ContadorDeClientes> getTopClients() {
        List<ContadorDeClientes> resultado = new ArrayList<>();
        List<Object[]> report = crudReservaciones.countTotalReservationByClient();
        for (int i = 0; i < report.size(); i ++) {
            resultado.add(new ContadorDeClientes((Long)report.get(i)[1], (Cliente)report.get(i)[0]));
        }
        return resultado;
    }
}
