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
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query("SELECT c.idCliente AS idCliente, c.nombreEmpresa AS nombreEmpresa FROM Cliente c")
    List<ClienteProjection> obtenerTodosLosClientes();
    @Query("SELECT c.idCliente AS idCliente, c.nombreEmpresa AS nombreEmpresa FROM Cliente c WHERE c.idCliente = :id")
    Optional<ClienteProjection> obtenerClientePorId(@Param("id") Long id);
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cliente (nombre_empresa) VALUES (:nombreEmpresa)", nativeQuery = true)
    void registrarCliente(@Param("nombreEmpresa") String nombreEmpresa);
    @Modifying
    @Transactional
    @Query(value = "UPDATE cliente SET nombre_empresa = :nombreEmpresa WHERE id_cliente = :id", nativeQuery = true)
    void actualizarCliente(@Param("id") Long id, @Param("nombreEmpresa") String nombreEmpresa);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cliente WHERE id_cliente = :id", nativeQuery = true)
    void eliminarCliente(@Param("id") Long id);
}