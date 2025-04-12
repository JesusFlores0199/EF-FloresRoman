package pe.edu.idat.EF_FloresRoman.Dto;
import java.math.BigDecimal;
public class ProductoRegistroDto {
    private Long id_product;
    private String codigo;
    private String descripcion;
    private BigDecimal peso;
    public Long getId_product() {
        return id_product;
    }
    public void setId_product(Long id_product) {
        this.id_product = id_product;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public BigDecimal getPeso() {
        return peso;
    }
    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }
}