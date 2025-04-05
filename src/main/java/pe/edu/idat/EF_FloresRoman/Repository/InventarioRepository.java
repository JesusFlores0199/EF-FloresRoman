package pe.edu.idat.EF_FloresRoman.Repository;
import pe.edu.idat.EF_FloresRoman.Model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
public interface InventarioRepository extends JpaRepository<Inventario, Long> {
}