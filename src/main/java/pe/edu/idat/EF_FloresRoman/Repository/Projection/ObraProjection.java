package pe.edu.idat.EF_FloresRoman.Repository.Projection;
import org.springframework.beans.factory.annotation.Value;
public interface ObraProjection {
    @Value("#{target.idObra}")
    Integer getIdObra();
    @Value("#{target.nomObra}")
    String getNomObra();
    @Value("#{target.piso}")
    Integer getPiso();
}