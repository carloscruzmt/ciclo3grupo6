package group6.reto4.web;

import group6.reto4.modelo.Reserva;
import group6.reto4.report.ContadorDeClientes;
import group6.reto4.report.EstadoReservas;
import group6.reto4.servicios.ReservationService;
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
 * clase controlador reservaciones
 * @author grupo 6
 */
@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ControladorReserva {
    /**
    * atributo
    * @author grupo 6
    */
    @Autowired
    private ReservationService servicio;
    /**
    * metodo obtener endpoint lista reservaciones
    * @author grupo 6
    */
    @GetMapping("/all")
    public List<Reserva> getReservations() {
        return servicio.getAll();
    }
    /**
    * metodo obtener endpoint reserva por id
    * @author grupo 6
    */
    @GetMapping("/{id}")
    public Optional<Reserva> getReservation(@PathVariable("id") int reservationId) {
        return servicio.getReservation(reservationId);
    }
    /**
    * metodo guardar endpoint reservaciones
    * @author grupo 6
    */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reserva save(@RequestBody Reserva reservation) {
        return servicio.save(reservation);
    }
    /**
    * metodo actualizar endpoint reservacion
    * @author grupo 6
    */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reserva update(@RequestBody Reserva reservation) {
        return servicio.update(reservation);
    }
    /**
    * metodo borrar endpoint reservacion
    * @author grupo 6
    */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId) {
        return servicio.deleteReservation(reservationId);
    }    
    /**
    * metodo obtener reporte reservas
    * return reporte reservas
    * @author grupo 6
    */
    @GetMapping("/report-status")
    public EstadoReservas getReservationStatusReport() {
        return servicio.getReservationsStatusReport();
    }
    /**
    * metodo obtener reporte reservas por fecha
    * return reporte reservas por fecha
    * @author grupo 6
    */
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reserva> getReservationsReportDates(@PathVariable("dateOne") String dateOne, @PathVariable("dateTwo") String dateTwo) {
        return servicio.getReservationPeriod(dateOne, dateTwo);
    }
    /**
    * metodo obtener reporte reserva con cliente
    * return reporte reservas con clientes
    * @author grupo 6
    */
    @GetMapping("/report-clients")
    public List<ContadorDeClientes> getReservationsReportClient() {
        return servicio.getTopClients();
    }
}
