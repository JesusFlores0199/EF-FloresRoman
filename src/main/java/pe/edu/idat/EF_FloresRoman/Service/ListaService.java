package pe.edu.idat.EF_FloresRoman.Service;
import pe.edu.idat.EF_FloresRoman.Dto.ListaRegistroDto;
import pe.edu.idat.EF_FloresRoman.Exception.InvalidListaException;
import pe.edu.idat.EF_FloresRoman.Exception.ServiceException;
import pe.edu.idat.EF_FloresRoman.Model.Lista;
import pe.edu.idat.EF_FloresRoman.Model.Producto;
import pe.edu.idat.EF_FloresRoman.Repository.ListaRepository;
import pe.edu.idat.EF_FloresRoman.Repository.ProductoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ListaService {
    private final ListaRepository listaRepository;
    private final ProductoRepository productoRepository;
    public ListaService(ListaRepository listaRepository, ProductoRepository productoRepository) {
        this.listaRepository = listaRepository;
        this.productoRepository = productoRepository;
    }
    // Método que obtiene la cantidad asociada a un producto
    public Integer obtenerCantidadPorProducto(Long idProduct) {
        return listaRepository.obtenerCantidadPorIdProducto(idProduct);
    }
    public List<Lista> obtenerListasPorProducto(Long idProduct) {
        return listaRepository.findByProductId(idProduct);
    }
    public List<Lista> getAllListas() {
        return listaRepository.findAll();
    }
    public Lista getListaById(Long id) {
        return listaRepository.findById(id)
                .orElseThrow(() -> new InvalidListaException("Lista no encontrada con ID: " + id, "LISTA_NOT_FOUND"));
    }
    public Lista createLista(ListaRegistroDto listaRegistroDto) {
        try {
            if (listaRegistroDto.getCantidad() <= 0) {
                throw new InvalidListaException("La cantidad debe ser mayor a cero.", "LISTA_REGISTER_ERROR");
            }
            Producto producto = productoRepository.findById(listaRegistroDto.getIdProduct())
                    .orElseThrow(() -> new InvalidListaException("Producto no encontrado.", "PRODUCT_NOT_FOUND"));
            Lista lista = new Lista();
            lista.setProducto(producto);
            lista.setCantidad(listaRegistroDto.getCantidad());
            return listaRepository.save(lista);
        } catch (Exception e) {
            throw new ServiceException("Error al registrar la lista: " + e.getMessage(), "LISTA_REGISTER_ERROR");
        }
    }
    public Lista updateLista(Long id, ListaRegistroDto listaRegistroDto) {
        try {
            Lista lista = listaRepository.findById(id)
                    .orElseThrow(() -> new InvalidListaException("Lista no encontrada para actualizar.", "LISTA_NOT_FOUND"));

            Producto producto = productoRepository.findById(listaRegistroDto.getIdProduct())
                    .orElseThrow(() -> new InvalidListaException("Producto no encontrado.", "PRODUCT_NOT_FOUND"));

            lista.setProducto(producto);
            lista.setCantidad(listaRegistroDto.getCantidad());

            return listaRepository.save(lista);
        } catch (Exception e) {
            throw new ServiceException("Error al actualizar la lista: " + e.getMessage(), "LISTA_UPDATE_ERROR");
        }
    }
    public void deleteLista(Long id) {
        Lista lista = listaRepository.findById(id)
                .orElseThrow(() -> new InvalidListaException("Lista no encontrada para eliminar.", "LISTA_NOT_FOUND"));
        listaRepository.delete(lista);
    }
}