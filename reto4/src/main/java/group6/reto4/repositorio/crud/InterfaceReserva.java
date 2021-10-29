package group6.reto4.repositorio.crud;

import group6.reto4.modelo.Reserva;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * interface crud reserva
 * @author grupo 6
 */
public interface InterfaceReserva extends CrudRepository<Reserva, Integer> {
    /**
    * objeto consulta reserva
    * @author grupo 6
    */
    public List<Reserva> findAllByStatus (String status);
    /**
    * objeto consulta reserva
    * @author grupo 6
    */
    public List<Reserva> findAllByStartDateAfterAndStartDateBefore(Date date1, Date date2);
     /**
    * objeto consulta reserva
    * @author grupo 6
    */
    @Query("SELECT c.client, COUNT(c.client) FROM Reserva AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]> countTotalReservationByClient();
}
