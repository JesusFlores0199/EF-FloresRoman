package pe.edu.idat.EF_FloresRoman.Repository.Projection;
import org.springframework.beans.factory.annotation.Value;
public interface ProductProjection {
    @Value("#{target.idProduct}") // Agrega este método para evitar el error
    Integer getIdProduct();
}