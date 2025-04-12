package pe.edu.idat.EF_FloresRoman.Repository;
import pe.edu.idat.EF_FloresRoman.Model.Picking;
import pe.edu.idat.EF_FloresRoman.Repository.Projection.PickingProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
public interface PickingRepository extends JpaRepository<Picking, Long> {
    Optional<Picking> findByEstado(String estado);
    // Listar todos los pickings
    @Query("SELECT p FROM Picking p")
    List<PickingProjection> obtenerTodosLosPickings();
    // Obtener un picking por su ID
    @Query("SELECT p FROM Picking p WHERE p.id = :id")
    Optional<PickingProjection> obtenerPickingPorId(@Param("id") Long id);
    // Registrar un nuevo picking
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO picking (estado, fecha, hora) VALUES (:estado, :fecha, :hora)", nativeQuery = true)
    void registrarPicking(@Param("estado") String estado,
                          @Param("fecha") String fecha,
                          @Param("hora") String hora);
    // Actualizar un picking existente
    @Modifying
    @Transactional
    @Query(value = "UPDATE picking SET estado = :estado, fecha = :fecha, hora = :hora WHERE id = :id", nativeQuery = true)
    void actualizarPicking(@Param("id") Long id,
                           @Param("estado") String estado,
                           @Param("fecha") String fecha,
                           @Param("hora") String hora);
    // Eliminar un picking por su ID
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM picking WHERE id = :id", nativeQuery = true)
    void eliminarPicking(@Param("id") Long id);
}