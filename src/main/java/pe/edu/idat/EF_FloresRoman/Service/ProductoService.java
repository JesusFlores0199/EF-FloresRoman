package pe.edu.idat.EF_FloresRoman.Service;
import pe.edu.idat.EF_FloresRoman.Dto.ProductoRegistroDto;
import pe.edu.idat.EF_FloresRoman.Exception.InvalidProductException;
import pe.edu.idat.EF_FloresRoman.Exception.ServiceException;
import pe.edu.idat.EF_FloresRoman.Repository.ProductoRepository;
import pe.edu.idat.EF_FloresRoman.Repository.Projection.ProductProjection;
import pe.edu.idat.EF_FloresRoman.Util.ConvertDto;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProductoService {
    private final ProductoRepository productoRepository;
    private final ConvertDto convertDto;
    public ProductoService(ProductoRepository productoRepository, ConvertDto convertDto) {
        this.productoRepository = productoRepository;
        this.convertDto = convertDto;
    }
    //Listar todos los productos
    public List<ProductProjection> obtenerTodosLosProductos(Long unitsInStock) {
        return productoRepository.obtenerTodosLosProductos(unitsInStock);
    }
    //Registrar producto
    public void registrarProducto(ProductoRegistroDto productoRegistroDto) {
        try {
            // Validación adicional de datos antes de persistir
            if (productoRegistroDto.getCodigo().length() < 3) {
                throw new InvalidProductException("Error al registrar el producto: ", "PRODUCT_REGISTER_ERROR");
            }
            productoRepository.registrarProducto(
                    productoRegistroDto.getCodigo(),
                    productoRegistroDto.getDescripcion(),
                    productoRegistroDto.getPeso()
            );
        } catch (Exception e) {
            throw new ServiceException("Error al actualizar el producto: " + e.getMessage(), "PRODUCT_UPDATE_ERROR");
        }
    }
    //Actualizar producto
    public void actualizarProducto(ProductoRegistroDto productoRegistroDto) {
        try {
            productoRepository.actualizarProducto(
                    productoRegistroDto.getId_product(),
                    productoRegistroDto.getCodigo(),
                    productoRegistroDto.getDescripcion(),
                    productoRegistroDto.getPeso()
            );
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar el producto: " + e.getMessage());
        }
    }
    //Eliminar un producto por su ID
    public void eliminarProducto(Long id) {
        try {
            productoRepository.eliminarProducto(id)
            ;
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el producto: " + e.getMessage());
        }
    }
}