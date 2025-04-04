package pe.edu.idat.EF_FloresRoman.Model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;
@Entity
@Table(name = "tabla_lista")
public class Lista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_product", nullable = false)
    private Producto producto; // Relación con la entidad Producto
    private Integer cantidad;
    private BigDecimal pesoNeto;
    @OneToMany(mappedBy = "lista")
    private List<ListaDetalle> listaDetalles;
    // Getters y setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {this.id = id;}
    public Producto getProducto() {return producto;}
    public void setProducto(Producto producto) {this.producto = producto;}
    public Integer getCantidad() {return cantidad;}
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
        // Aquí calculamos el peso neto cada vez que se setea la cantidad
        if (this.producto != null) {
            this.pesoNeto = this.producto.getPeso().multiply(BigDecimal.valueOf(cantidad));
        } else {
            this.pesoNeto = BigDecimal.ZERO;
        }}
    public BigDecimal getPesoNeto() {return pesoNeto;}
    public void setPesoNeto(BigDecimal pesoNeto) {this.pesoNeto = pesoNeto;}
}