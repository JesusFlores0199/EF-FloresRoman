package pe.edu.idat.EF_FloresRoman.Repository;
import pe.edu.idat.EF_FloresRoman.Model.Cliente;
import pe.edu.idat.EF_FloresRoman.Repository.Projection.ClienteProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Query("SELECT c FROM Cliente c")
    List<ClienteProjection> obtenerTodosLosClientes();
    @Query("SELECT c FROM Cliente c WHERE c.id = :id")
    Optional<ClienteProjection> obtenerClientePorId(@Param("id") Integer id);
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cliente (nombre_empresa) VALUES (:nombreEmpresa)", nativeQuery = true)
    void registrarCliente(@Param("nombreEmpresa") String nombreEmpresa);
    @Modifying
    @Transactional
    @Query(value = "UPDATE cliente SET nombre_empresa = :nombreEmpresa WHERE id = :id", nativeQuery = true)
    void actualizarCliente(@Param("id") Integer id, @Param("nombreEmpresa") String nombreEmpresa);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cliente WHERE id = :id", nativeQuery = true)
    void eliminarCliente(@Param("id") Integer id);
}