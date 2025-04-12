package pe.edu.idat.EF_FloresRoman.Repository.Projection;
import java.math.BigDecimal;
public interface ListaProjection {
    Long getId();
    String getNombreProducto();  // Obtener el código del producto
    String getDescripcionProducto(); // Obtener la descripción del producto
    Integer getCantidad();
    BigDecimal getPesoNeto();
}