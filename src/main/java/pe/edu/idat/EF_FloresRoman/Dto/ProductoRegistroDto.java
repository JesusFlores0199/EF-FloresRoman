package pe.edu.idat.EF_FloresRoman.Dto;
import java.math.BigDecimal;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
public class ProductoRegistroDto {
    private Long id_product;
    @NotNull(message = "El código no puede ser nulo")
    @Size(min = 1, max = 20, message = "El código debe tener entre 3 y 20 caracteres")
    private String codigo;
    @NotNull(message = "La descripción no puede ser nula")
    private String descripcion;
    @NotNull(message = "El peso no puede ser nulo")
    @Min(value = 0, message = "El peso debe ser mayor o igual a 0")
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