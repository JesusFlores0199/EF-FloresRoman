package pe.edu.idat.EF_FloresRoman.Service;
import pe.edu.idat.EF_FloresRoman.Dto.InventarioRegistroDto;
import pe.edu.idat.EF_FloresRoman.Exception.InvalidInventarioException;
import pe.edu.idat.EF_FloresRoman.Exception.ServiceException;
import pe.edu.idat.EF_FloresRoman.Model.Inventario;
import pe.edu.idat.EF_FloresRoman.Model.Producto;
import pe.edu.idat.EF_FloresRoman.Repository.InventarioRepository;
import pe.edu.idat.EF_FloresRoman.Repository.ListaRepository;
import pe.edu.idat.EF_FloresRoman.Repository.ProductoRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
@Service
public class InventarioService {
    private final InventarioRepository inventarioRepository;
    private final ListaRepository listaRepository;
    private final ProductoRepository productoRepository;
    public InventarioService(InventarioRepository inventarioRepository,
                             ListaRepository listaRepository,
                             ProductoRepository productoRepository) {
        this.inventarioRepository = inventarioRepository;
        this.listaRepository = listaRepository;
        this.productoRepository = productoRepository;
    }
    // Registrar inventario
    public void registrarInventario(InventarioRegistroDto inventarioDto) {
        try {
            if (inventarioDto.getCantidadReal() == null || inventarioDto.getCantidadReal() < 0) {
                throw new InvalidInventarioException("Cantidad real inválida", "INVENTARIO_CANTIDAD_INVALIDA");
            }
            Long idProducto = inventarioDto.getIdProduct();
            Producto producto = productoRepository.findById(idProducto)
                    .orElseThrow(() -> new InvalidInventarioException("Producto no encontrado", "PRODUCTO_NO_EXISTE"));

            // Obtener cantidad reservada desde Lista
            Integer cantidadReservada = listaRepository.obtenerCantidadPorIdProducto(idProducto);
            if (cantidadReservada == null) cantidadReservada = 0;

            // Calcular cantidad real efectiva
            int cantidadRealEfectiva = inventarioDto.getCantidadReal() - cantidadReservada;

            Inventario inventario = new Inventario();
            inventario.setProducto(producto);
            inventario.setCantidadReservada(cantidadReservada);
            inventario.setCantidadReal(cantidadRealEfectiva);
            inventario.setFecha(LocalDate.now());
            inventarioRepository.save(inventario);
        } catch (Exception e) {
            throw new ServiceException("Error al registrar inventario: " + e.getMessage(), "INVENTARIO_REGISTRO_ERROR");
        }
    }
    // Actualizar inventario
    public Inventario actualizarInventario(Long id, InventarioRegistroDto inventarioRegistroDto) {
        try {
            Inventario inventario = inventarioRepository.findById(id)
                    .orElseThrow(() -> new InvalidInventarioException("Inventario no encontrado para actualizar.", "INVENTARIO_NOT_FOUND"));
            Producto producto = productoRepository.findById(inventarioRegistroDto.getIdProduct())
                    .orElseThrow(() -> new InvalidInventarioException("Producto no encontrado", "PRODUCTO_NO_EXISTE"));
            Integer cantidadReservada = listaRepository.obtenerCantidadPorIdProducto(inventarioRegistroDto.getIdProduct());
            if (cantidadReservada == null) cantidadReservada = 0;
            int cantidadRealEfectiva = inventarioRegistroDto.getCantidadReal() - cantidadReservada;
            inventario.setCantidadReservada(cantidadReservada);
            inventario.setCantidadReal(cantidadRealEfectiva);
            inventario.setProducto(producto);
            return inventarioRepository.save(inventario);
        } catch (Exception e) {
            throw new ServiceException("Error al actualizar el inventario: " + e.getMessage(), "INVENTARIO_UPDATE_ERROR");
        }
    }
    // Obtener todos los inventarios
    public List<Inventario> getAllInventarios() {
        return inventarioRepository.findAll();
    }
    // Obtener inventario por ID
    public Inventario getInventarioById(Long id) {
        return inventarioRepository.findById(id)
                .orElseThrow(() -> new InvalidInventarioException("Inventario no encontrado", "INVENTARIO_NOT_FOUND"));
    }
    // Eliminar inventario
    public void deleteInventario(Long id) {
        if (!inventarioRepository.existsById(id)) {
            throw new InvalidInventarioException("Inventario no encontrado para eliminar", "INVENTARIO_NOT_FOUND");
        }
        inventarioRepository.deleteById(id);
    }
}