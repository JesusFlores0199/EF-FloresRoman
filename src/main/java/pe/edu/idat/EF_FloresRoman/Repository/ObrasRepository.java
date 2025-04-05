package pe.edu.idat.EF_FloresRoman.Repository;
import pe.edu.idat.EF_FloresRoman.Model.Obra;
import pe.edu.idat.EF_FloresRoman.Repository.Projection.ObraProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
public interface ObrasRepository extends JpaRepository<Obra, Long> {
    // Listar todas las obras
    @Query("SELECT o FROM Obra o")
    List<ObraProjection> obtenerTodasLasObras();
    // Obtener una obra por su ID
    @Query("SELECT o FROM Obra o WHERE o.id = :id")
    Optional<ObraProjection> obtenerObraPorId(@Param("id") Long Long);
    // Registrar una nueva obra
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO obra (nom_obra, piso) VALUES (:nomObra, :piso)", nativeQuery = true)
    void registrarObra(@Param("nomObra") String nomObra, @Param("piso") String piso);
    // Actualizar una obra existente
    @Modifying
    @Transactional
    @Query(value = "UPDATE obra SET nom_obra = :nomObra, piso = :piso WHERE id = :id", nativeQuery = true)
    void actualizarObra(@Param("id") Long id, @Param("nomObra") String nomObra, @Param("piso") String piso);
    // Eliminar una obra por su ID
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM obra WHERE id = :id", nativeQuery = true)
    void eliminarObra(@Param("id") Long id);
}