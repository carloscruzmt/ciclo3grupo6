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


/**
 * clase para la creación de los computadores
 * @author grupo 6
 */
@Entity
@Table(name = "computer")
public class Computador implements Serializable {
    /**
    * atributo id
    * @author grupo 6
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
    * atributo nombre
    * @author grupo 6
    */
    private String name;
    /**
    * atributo marca
    * @author grupo 6
    */
    private String brand;
    /**
    * atributo año
    * @author grupo 6
    */
    private Integer year;
    /**
    * atributo descripcion
    * @author grupo 6
    */
    private String description;
    /**
    * atributo categoria
    * @author grupo 6
    */
    @ManyToOne   // varios computadores se relacionan a una categoria
    @JoinColumn(name = "categoryId") // conecta la llave primaria del objeto que se crea
    @JsonIgnoreProperties("computers")    // ignora la lista donde se referencian los objetos de esta misma clase
    private Categoria category;      // objeto con el que se crea la relacion
    /**
    * atributo mensajes
    * @author grupo 6
    */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "computer")  // un computador se relaciona a varios objetos (message)
    @JsonIgnoreProperties({"computer", "client"})  // ignora la lista de objetos de esta clase, donde no se desea que aparezcan en otra tabla
    private List<Mensaje> messages;
    /**
    * atributo lista reservaciones
    * @author grupo 6
    */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "computer")
    @JsonIgnoreProperties({"computer", "client"})
    private List<Reserva> reservations;
    /**
    * metodo para obtener id computador
    * @author grupo 6
    */
    public Integer getId() {
        return id;
    }
    /**
    * metodo para editar id computador
    * @author grupo 6
    */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
    * metodo para obtener nombre computador
    * @author grupo 6
    */
    public String getName() {
        return name;
    }
    /**
    * metodo para editar nombre computador
    * @author grupo 6
    */
    public void setName(String name) {
        this.name = name;
    }
    /**
    * metodo para obtener marca computador
    * @author grupo 6
    */
    public String getBrand() {
        return brand;
    }
    /**
    * metodo para editar marca computador
    * @author grupo 6
    */
    public void setBrand(String brand) {
        this.brand = brand;
    }
    /**
    * metodo para obtener año computador
    * @author grupo 6
    */
    public Integer getYear() {
        return year;
    }
    /**
    * metodo para editar año computador
    * @author grupo 6
    */
    public void setYear(Integer year) {
        this.year = year;
    }
    /**
    * metodo para obtener descripcion computador
    * @author grupo 6
    */
    public String getDescription() {
        return description;
    }
    /**
    * metodo para editar descripcion computador
    * @author grupo 6
    */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
    * metodo para obtener categoria computador
    * @author grupo 6
    */
    public Categoria getCategory() {
        return category;
    }
    /**
    * metodo para editar categoria computador
    * @author grupo 6
    */
    public void setCategory(Categoria category) {
        this.category = category;
    }
    /**
    * metodo para obtener lista mensajes
    * @author grupo 6
    */
    public List<Mensaje> getMessages() {
        return messages;
    }
    /**
    * metodo para editar lista mensajes
    * @author grupo 6
    */
    public void setMessages(List<Mensaje> messages) {
        this.messages = messages;
    }
    /**
    * metodo para obtener lista reservas
    * @author grupo 6
    */
    public List<Reserva> getReservations() {
        return reservations;
    }
    /**
    * metodo para editar lista reservas
    * @author grupo 6
    */
    public void setReservations(List<Reserva> reservations) {
        this.reservations = reservations;
    }    
}
