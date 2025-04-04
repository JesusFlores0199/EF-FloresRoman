package pe.edu.idat.EF_FloresRoman.Model;
import jakarta.persistence.*;
import java.math.BigDecimal;
@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct; // Cambio de id_product a idProduct para mantener consistencia con DTO
    @Column(nullable = false, unique = true)
    private String codigo;
    @Column(nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private BigDecimal peso;
    // Getters y Setters
    public Long getIdProduct() {return idProduct;}
    public void setIdProduct(Long idProduct) {this.idProduct = idProduct;}
    public String getCodigo() {return codigo;}
    public void setCodigo(String codigo) {this.codigo = codigo;}
    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
    public BigDecimal getPeso() {return peso;}
    public void setPeso(BigDecimal peso) {this.peso = peso;}
}