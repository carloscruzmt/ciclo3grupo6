package group6.reto4.servicios;

import group6.reto4.modelo.Reserva;
import group6.reto4.report.ContadorDeClientes;
import group6.reto4.report.EstadoReservas;
import group6.reto4.repositorio.RepositorioReserva;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * clase servicios reserva
 * @author grupo 6
 */
@Service
public class ReservationService {
    /**
    * atributo
    * @author grupo 6
    */
    @Autowired
    private RepositorioReserva repoReservas;
    /**
    * metodo obtener lista reservas
    * @author grupo 6
    */
    public List<Reserva> getAll() {
        return repoReservas.getAll();
    }
    /**
    * metodo obtener reserva por id condicional
    * @author grupo 6
    */
    public Optional<Reserva> getReservation(int reservationId) {
        return repoReservas.getReservation(reservationId);
    }
    /**
    * metodo guardar reserva condicional
    * @author grupo 6
    */
    public Reserva save(Reserva reservation) {
        if (reservation.getIdReservation() == null) {
            return repoReservas.save(reservation);
        }
        else {
            Optional<Reserva> reser = repoReservas.getReservation(reservation.getIdReservation());
            if (reser.isEmpty()) {
                return repoReservas.save(reservation);
            }
            else {
                return reservation;
            }
        }
    }
    /**
    * metodo actualizar reserva condicional
    * @author grupo 6
    */
    public Reserva update(Reserva reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reserva> rese = repoReservas.getReservation(reservation.getIdReservation());
            if (!rese.isEmpty()) {
                if (reservation.getStartDate() != null) {
                    rese.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    rese.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    rese.get().setStatus(reservation.getStatus());
                }
                repoReservas.save(rese.get());
                return rese.get();
            }
            else {
                return reservation;
            }
        }
        else {
            return reservation;
        }
    }
    /**
    * metodo borrar reserva
    * return boolean
    * @author grupo 6
    */
    public boolean deleteReservation(int reservationId) {
        return getReservation(reservationId).map(reservation -> {
            repoReservas.delete(reservation);
            return true;
        }).orElse(false);         
    }
    /**
    * metodo obtener reporte reserva
    * return cantidades de cada tipo de reserva
    * @author grupo 6
    */
    public EstadoReservas getReservationsStatusReport() {
        List<Reserva> completed = repoReservas.getReservationByStatus("completed");
        List<Reserva> cancelled = repoReservas.getReservationByStatus("cancelled");
        return new EstadoReservas(completed.size(), cancelled.size());
    }
    /**
    * metodo obtener reservas por fecha
    * return reservas por fecha solicitada
    * @author grupo 6
    */
    public List<Reserva> getReservationPeriod(String fechaA, String fechaB) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaUno = new Date();
        Date fechaDos = new Date();
        
        try {
            fechaUno = parser.parse(fechaA);
            fechaDos = parser.parse(fechaB);
        } catch(java.text.ParseException event) {
            event.printStackTrace();
        }
        if (fechaUno.before(fechaDos)) {
            return repoReservas.getReservationPeriod(fechaUno, fechaDos);
        } else {
            return new ArrayList<>();
        }
    }
    /**
    * metodo obtener clientes vip
    * return clientes vip
    * @author grupo 6
    */
    public List<ContadorDeClientes> getTopClients() {
        return repoReservas.getTopClients();
    }
}
