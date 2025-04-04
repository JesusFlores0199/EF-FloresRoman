package pe.edu.idat.EF_FloresRoman.Dto;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
public class PickingRegistroDto {
    private Integer id;
    @NotNull(message = "El estado no puede ser nulo")
    private String estado;
    private LocalDateTime fecha;
    private String hora;
    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public String getEstado() {return estado;}
    public void setEstado(String estado) {this.estado = estado;}
    public LocalDateTime getFecha() {return fecha;}
    public void setFecha(LocalDateTime fecha) {this.fecha = fecha;}
    public String getHora() {return hora;}
    public void setHora(String hora) {this.hora = hora;}
}