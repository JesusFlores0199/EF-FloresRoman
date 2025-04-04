package pe.edu.idat.EF_FloresRoman.Model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
@Entity
@Setter
@Getter
@Table(name = "inventario")
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id_product")
    private Producto producto;
    private Integer cantidadReal;
    private Integer cantidadReservada;
    private LocalDate fecha;
    // Constructor vacío
    public Inventario() {}
    // Constructor con parámetros
    public Inventario(Producto producto, Integer cantidadReal, Integer cantidadReservada, LocalDate fecha) {
        this.producto = producto;
        this.cantidadReal = cantidadReal;
        this.cantidadReservada = cantidadReservada;
        this.fecha = fecha;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public Integer getCantidadReal() {
        return cantidadReal;
    }
    public void setCantidadReal(Integer cantidadReal) {
        this.cantidadReal = cantidadReal;
    }
    public Integer getCantidadReservada() {
        return cantidadReservada;
    }
    public void setCantidadReservada(Integer cantidadReservada) {
        this.cantidadReservada = cantidadReservada;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}