package pe.edu.idat.EF_FloresRoman.Repository.Projection;
import java.time.LocalDateTime;
public interface PickingProjection {
    Long getId();
    String getEstado();
    LocalDateTime getFecha();
    String getHora();
}