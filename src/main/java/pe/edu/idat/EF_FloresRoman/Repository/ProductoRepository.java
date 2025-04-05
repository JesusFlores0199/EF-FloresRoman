package pe.edu.idat.EF_FloresRoman.Repository;
import pe.edu.idat.EF_FloresRoman.Model.Producto;
import pe.edu.idat.EF_FloresRoman.Repository.Projection.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    //Listar todos los productos con un filtro opcional por stock
    @Query("SELECT p FROM Producto p WHERE (:unitsInStock IS NULL OR p.stock >= :unitsInStock)")
    List<ProductProjection> obtenerTodosLosProductos(@Param("unitsInStock") Long unitsInStock);
    //Obtener un producto por su ID
    @Query("SELECT p FROM Producto p WHERE p.idProduct = :id")
    Optional<ProductProjection> obtenerProductoPorId(@Param("id") Long id);
    //Registrar un nuevo producto
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO producto (codigo, descripcion, peso) VALUES (:codigo, :descripcion, :peso)", nativeQuery = true)
    void registrarProducto(@Param("codigo") String codigo,
                           @Param("descripcion") String descripcion,
                           @Param("peso") BigDecimal peso);
    //Actualizar un producto existente
    @Modifying
    @Transactional
    @Query(value = "UPDATE producto SET codigo = :codigo, descripcion = :descripcion, peso = :peso WHERE id_product = :id", nativeQuery = true)
    void actualizarProducto(@Param("id") Long id,
                            @Param("codigo") String codigo,
                            @Param("descripcion") String descripcion,
                            @Param("peso") BigDecimal peso);
    //Eliminar un producto por ID
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM producto WHERE id_product = :id", nativeQuery = true)
    void eliminarProducto(@Param("id") Long id);
}
//obtenerProductoPorId() → Permite buscar un producto por su id_product.
//@Transactional y @Modifying → Se usan en registrarProducto(), actualizarProducto(), y eliminarProducto() porque estos métodos modifican la base de datos.