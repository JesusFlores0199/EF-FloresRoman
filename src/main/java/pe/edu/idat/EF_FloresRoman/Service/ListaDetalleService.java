package pe.edu.idat.EF_FloresRoman.Service;
import pe.edu.idat.EF_FloresRoman.Dto.ListaDetalleDto;
import pe.edu.idat.EF_FloresRoman.Exception.InvalidListaDetalleException;
import pe.edu.idat.EF_FloresRoman.Model.Lista;
import pe.edu.idat.EF_FloresRoman.Model.ListaDetalle;
import pe.edu.idat.EF_FloresRoman.Repository.ListaDetalleRepository;
import pe.edu.idat.EF_FloresRoman.Repository.ListaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
public class ListaDetalleService {
    private final ListaDetalleRepository listaDetalleRepository;
    private final ListaRepository listaRepository;
    @Autowired
    public ListaDetalleService(ListaDetalleRepository listaDetalleRepository, ListaRepository listaRepository) {
        this.listaDetalleRepository = listaDetalleRepository;
        this.listaRepository = listaRepository;
    }
    // Crear un nuevo ListaDetalle
    public ListaDetalle createListaDetalle(ListaDetalleDto listaDetalleDto) {
        try {
            ListaDetalle listaDetalle = new ListaDetalle();
            listaDetalle.setNombreEmpresa(listaDetalleDto.getNombreEmpresa());
            listaDetalle.setNomObra(listaDetalleDto.getNomObra());
            listaDetalle.setPiso(listaDetalleDto.getPiso());
            // Buscar la entidad Lista usando el idLista desde el DTO
            Optional<Lista> listaOpt = listaRepository.findById(listaDetalleDto.getIdLista());
            if (listaOpt.isPresent()) {
                listaDetalle.setLista(listaOpt.get());
            } else {
                throw new InvalidListaDetalleException("Lista no encontrada con id: " + listaDetalleDto.getIdLista());
            }
            // Establecer la fecha actual de creación
            listaDetalle.setFecha(LocalDate.now());
            // Calcular el costo total
            BigDecimal costoUnitario = listaDetalleDto.getCostoUnitario();
            Integer cantidad = listaDetalleDto.getCantidad();
            if (costoUnitario == null || cantidad == null) {
                throw new InvalidListaDetalleException("Costo unitario o cantidad no pueden ser nulos.");
            }
            BigDecimal costoTotal = costoUnitario.multiply(BigDecimal.valueOf(cantidad));
            listaDetalle.setCostoTotal(costoTotal);
            // Guardar el objeto ListaDetalle en la base de datos
            return listaDetalleRepository.save(listaDetalle);
        } catch (Exception e) {
            // Manejar la excepción de manera adecuada
            throw new InvalidListaDetalleException("Error al crear ListaDetalle: " + e.getMessage(), e);
        }
    }
    // Actualizar un ListaDetalle existente
    public ListaDetalle updateListaDetalle(Long id, ListaDetalleDto listaDetalleDto) {
        Optional<ListaDetalle> existingListaDetalle = listaDetalleRepository.findById(id);
        if (existingListaDetalle.isPresent()) {
            ListaDetalle listaDetalle = existingListaDetalle.get();
            listaDetalle.setNombreEmpresa(listaDetalleDto.getNombreEmpresa());
            listaDetalle.setNomObra(listaDetalleDto.getNomObra());
            listaDetalle.setPiso(listaDetalleDto.getPiso());
            listaDetalle.setCostoUnitario(listaDetalleDto.getCostoUnitario());
            // Calcular el costo total
            BigDecimal costoTotal = listaDetalleDto.getCostoUnitario().multiply(new BigDecimal(listaDetalleDto.getCantidad()));
            listaDetalle.setCostoTotal(costoTotal);
            return listaDetalleRepository.save(listaDetalle);
        } else {
            throw new InvalidListaDetalleException("ListaDetalle no encontrado con id: " + id);
        }
    }
    // Eliminar un ListaDetalle
    public void deleteListaDetalle(Long id) {
        Optional<ListaDetalle> listaDetalle = listaDetalleRepository.findById(id);
        if (listaDetalle.isPresent()) {
            listaDetalleRepository.delete(listaDetalle.get());
        } else {
            throw new InvalidListaDetalleException("ListaDetalle no encontrado con id: " + id);
        }
    }
    // Obtener un ListaDetalle por id
    public ListaDetalle getListaDetalleById(Long id) {
        return listaDetalleRepository.findById(id)
                .orElseThrow(() -> new InvalidListaDetalleException("ListaDetalle no encontrado con id: " + id));
    }
    // Obtener todos los ListaDetalles
    public List<ListaDetalle> getAllListaDetalles() {
        return listaDetalleRepository.findAll();
    }
}