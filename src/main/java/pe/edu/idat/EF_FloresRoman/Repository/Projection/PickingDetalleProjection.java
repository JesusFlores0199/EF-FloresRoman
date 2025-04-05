package pe.edu.idat.EF_FloresRoman.Repository.Projection;
import java.time.LocalDate;
import java.time.LocalTime;
public interface PickingDetalleProjection {
    Long getId();
    String getEstado();
    Long getIdLista();
    LocalDate getFecha();
    LocalTime getHora();
}