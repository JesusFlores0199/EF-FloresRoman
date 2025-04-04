package pe.edu.idat.EF_FloresRoman.Dto;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
public class ObraRegistroDto {
    private Long id;
    @NotNull(message = "Nombre de la obra")
    private String nomObra;
    @NotNull(message = "El peso no puede ser nulo")
    @Min(value = 1, message = "El piso debe ser mayor o igual a 1")
    private String piso;
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getNomObra() {return nomObra;}
    public void setNomObra(String nomObra) {this.nomObra = nomObra;}
    public String getPiso() {return piso;}
    public void setPiso(String piso) {this.piso = piso;}
}