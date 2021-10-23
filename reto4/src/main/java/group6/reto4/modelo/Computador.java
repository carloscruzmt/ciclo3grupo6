package group6.reto4.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.aspectj.bridge.Message;

/**
 *
 * @author PosYo
 */
@Entity
@Table(name = "computer")
public class Computador implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String brand;
    private Integer year;
    private String description;
    
    @ManyToOne   // varios computadores se relacionan a una categoria
    @JoinColumn(name = "categoryId") // conecta la llave primaria del objeto que se crea
    @JsonIgnoreProperties("computers")    // ignora la lista donde se referencian los objetos de esta misma clase
    private Categoria category;      // objeto con el que se crea la relacion
    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "computer")  // un computador se relaciona a varios objetos (message)
    @JsonIgnoreProperties({"computer", "client"})  // ignora la lista de objetos de esta clase, donde no se desea que aparezcan en otra tabla
    private List<Mensaje> messages;
    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "computer")
    @JsonIgnoreProperties({"computer", "client"})
    private List<Reserva> reservations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categoria getCategory() {
        return category;
    }

    public void setCategory(Categoria category) {
        this.category = category;
    }

    public List<Mensaje> getMessages() {
        return messages;
    }

    public void setMessages(List<Mensaje> messages) {
        this.messages = messages;
    }

    public List<Reserva> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reserva> reservations) {
        this.reservations = reservations;
    }

    
}
