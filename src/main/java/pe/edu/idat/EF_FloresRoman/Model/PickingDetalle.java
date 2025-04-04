package pe.edu.idat.EF_FloresRoman.Model;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Table(name = "picking_detalle")
public class PickingDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_tabla_list", nullable = false)
    private Lista lista;
    @ManyToOne
    @JoinColumn(name = "estado", referencedColumnName = "estado", nullable = false)
    private Picking picking;
    private LocalDate fecha;
    private LocalTime hora;
    @PrePersist
    public void prePersist() {
        fecha = LocalDate.now();
        hora = LocalTime.now();
    }
    // Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Lista getLista() {
        return lista;
    }
    public void setLista(Lista lista) {
        this.lista = lista;
    }
    public Picking getPicking() {
        return picking;
    }
    public void setPicking(Picking picking) {
        this.picking = picking;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public LocalTime getHora() {
        return hora;
    }
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
}