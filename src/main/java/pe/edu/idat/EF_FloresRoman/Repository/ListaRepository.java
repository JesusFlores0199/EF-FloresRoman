package pe.edu.idat.EF_FloresRoman.Repository;
import pe.edu.idat.EF_FloresRoman.Model.Lista;
import pe.edu.idat.EF_FloresRoman.Repository.Projection.ListaProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
public interface ListaRepository extends JpaRepository<Lista, Long> {
    List<ListaProjection> listarListasConDatosProducto();
    @Query("SELECT l.cantidad FROM Lista l WHERE l.producto.idProduct = :idProduct")
    Integer obtenerCantidadPorIdProducto(@Param("idProduct") Long idProduct);
    @Query("SELECT l FROM Lista l WHERE l.producto.idProduct = :idProduct")
    List<Lista> findByProductId(@Param("idProduct") Long idProduct);
}