package pe.edu.idat.EF_FloresRoman.Repository.Projection;
import org.springframework.beans.factory.annotation.Value;
import java.time.LocalDateTime;
public interface PickingProjection {
    @Value("#{target.id}")
    Integer getId();
    @Value("#{target.estado}")
    String getEstado();
    @Value("#{target.fecha}")
    LocalDateTime getFecha();
    @Value("#{target.hora}")
    String getHora();
}