package pe.edu.idat.EF_FloresRoman.Dto;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
@Getter
@Setter
public class PickingRegistroDto {
    private Long id;
    private String estado;
    private LocalDateTime fecha;
    private String hora;
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getEstado() {return estado;}
    public void setEstado(String estado) {this.estado = estado;}
    public LocalDateTime getFecha() {return fecha;}
    public void setFecha(LocalDateTime fecha) {this.fecha = fecha;}
    public String getHora() {return hora;}
    public void setHora(String hora) {this.hora = hora;}
}