package pe.edu.idat.EF_FloresRoman.Dto;
import javax.validation.constraints.NotNull;
public class ClienteRegistroDto {
    private Integer id;
    @NotNull(message = "Nombre de la empresa")
    private String nombreEmpresa;
    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public String getNombreEmpresa() {return nombreEmpresa;}
    public void setNombreEmpresa(String nombreEmpresa) {this.nombreEmpresa = nombreEmpresa;}
}