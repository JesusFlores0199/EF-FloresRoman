package pe.edu.idat.EF_FloresRoman.Dto;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ClienteRegistroDto {
    private Long idCliente;
    private String nombreEmpresa;
    public Long getIdCliente() {return idCliente;}
    public void setIdCliente(Long idCliente) {this.idCliente = idCliente;}
    public String getNombreEmpresa() {return nombreEmpresa;}
    public void setNombreEmpresa(String nombreEmpresa) {this.nombreEmpresa = nombreEmpresa;}
}