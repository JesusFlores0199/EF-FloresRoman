package pe.edu.idat.EF_FloresRoman.Repository;
import pe.edu.idat.EF_FloresRoman.Model.ListaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ListaDetalleRepository extends JpaRepository<ListaDetalle, Long> {
    // Aquí puedes agregar métodos adicionales si es necesario
}