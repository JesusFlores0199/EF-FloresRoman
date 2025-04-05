package pe.edu.idat.EF_FloresRoman.Repository.Projection;
import org.springframework.beans.factory.annotation.Value;
public interface ClienteProjection {
    @Value("#{target.idCliente}")
    Integer getIdCliente();
    @Value("#{target.nombreEmpresa}")
    String getNombreEmpresa();
}