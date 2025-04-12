package pe.edu.idat.EF_FloresRoman.Service;
import pe.edu.idat.EF_FloresRoman.Dto.ListaDetalleDto;
import pe.edu.idat.EF_FloresRoman.Dto.ListaDetalleRegistroDto;
import pe.edu.idat.EF_FloresRoman.Exception.ResourceNotFoundException;
import pe.edu.idat.EF_FloresRoman.Model.*;
import pe.edu.idat.EF_FloresRoman.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ListaDetalleService {
    private final ListaDetalleRepository listaDetalleRepository;
    private final ClienteRepository clienteRepository;
    private final ObrasRepository obrasRepository;
    private final ListaRepository listaRepository;
    public ListaDetalle registrarListaDetalle(ListaDetalleRegistroDto dto) {
        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente con ID " + dto + " no encontrada", "LISTA_NOT_FOUND"));
        Obra obra = obrasRepository.findById(dto.getObraId())
                .orElseThrow(() -> new ResourceNotFoundException("Obra con ID " + dto + " no encontrada", "LISTA_NOT_FOUND"));
        Lista lista = listaRepository.findById(dto.getListaId())
                .orElseThrow(() -> new ResourceNotFoundException("Lista con ID " + dto + " no encontrada", "LISTA_NOT_FOUND"));

        ListaDetalle detalle = ListaDetalle.builder()
                .cliente(cliente)
                .obra(obra)
                .lista(lista)
                .fecha(dto.getFecha())
                .costoUnitario(dto.getCostoUnitario())
                .costoTotal(dto.getCostoTotal())
                .build();
        return listaDetalleRepository.save(detalle);
    }
    public ListaDetalle actualizarListaDetalle(Long id, ListaDetalleRegistroDto dto) {
        ListaDetalle detalle = listaDetalleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ListaDetalle con ID " + id + " no encontrada", "LISTA_NOT_FOUND"));
        detalle.setCliente(clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente con ID " + id + " no encontrada", "LISTA_NOT_FOUND")));
        detalle.setObra(obrasRepository.findById(dto.getObraId())
                .orElseThrow(() -> new ResourceNotFoundException("Obra con ID " + id + " no encontrada", "LISTA_NOT_FOUND")));
        detalle.setLista(listaRepository.findById(dto.getListaId())
                .orElseThrow(() -> new ResourceNotFoundException("Lista con ID " + id + " no encontrada", "LISTA_NOT_FOUND")));
        detalle.setFecha(dto.getFecha());
        detalle.setCostoUnitario(dto.getCostoUnitario());
        detalle.setCostoTotal(dto.getCostoTotal());
        return listaDetalleRepository.save(detalle);
    }
    public void eliminarListaDetalle(Long id) {
        if (!listaDetalleRepository.existsById(id)) {
            throw new ResourceNotFoundException("ListaDetalle con ID " + id + " no encontrada", "LISTA_NOT_FOUND");
        }
        listaDetalleRepository.deleteById(id);
    }
    public ListaDetalle obtenerPorId(Long id) {
        return listaDetalleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ListaDetalle con ID " + id + " no encontrada", "LISTA_NOT_FOUND"));
    }
    public List<ListaDetalleDto> obtenerTodos() {
        return listaDetalleRepository.findAllProjected();
    }
}