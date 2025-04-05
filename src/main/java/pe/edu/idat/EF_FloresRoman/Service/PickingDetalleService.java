package pe.edu.idat.EF_FloresRoman.Service;
import pe.edu.idat.EF_FloresRoman.Dto.PickingDetalleRegistroDto;
import pe.edu.idat.EF_FloresRoman.Exception.InvalidPickingDetalleException;
import pe.edu.idat.EF_FloresRoman.Model.Lista;
import pe.edu.idat.EF_FloresRoman.Model.Picking;
import pe.edu.idat.EF_FloresRoman.Model.PickingDetalle;
import pe.edu.idat.EF_FloresRoman.Repository.ListaRepository;
import pe.edu.idat.EF_FloresRoman.Repository.PickingDetalleRepository;
import pe.edu.idat.EF_FloresRoman.Repository.PickingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class PickingDetalleService {
    @Autowired
    private PickingDetalleRepository pickingDetalleRepository;
    @Autowired
    private ListaRepository listaRepository;
    @Autowired
    private PickingRepository pickingRepository;
    public PickingDetalle registrarPickingDetalle(PickingDetalleRegistroDto dto) {
        Lista lista = listaRepository.findById(dto.getIdLista())
                .orElseThrow(() -> new InvalidPickingDetalleException("Lista no encontrada"));

        Picking picking = pickingRepository.findByEstado(dto.getEstado())
                .orElseThrow(() -> new InvalidPickingDetalleException("Estado no registrado en tabla picking"));
        PickingDetalle detalle = new PickingDetalle();
        detalle.setLista(lista);
        detalle.setPicking(picking);

        return pickingDetalleRepository.save(detalle);
    }
    public PickingDetalle actualizarPickingDetalle(Long id, PickingDetalleRegistroDto dto) {
        PickingDetalle existente = pickingDetalleRepository.findById(id)
                .orElseThrow(() -> new InvalidPickingDetalleException("PickingDetalle no encontrado"));
        Lista lista = listaRepository.findById(dto.getIdLista())
                .orElseThrow(() -> new InvalidPickingDetalleException("Lista no encontrada"));
        Picking picking = pickingRepository.findByEstado(dto.getEstado())
                .orElseThrow(() -> new InvalidPickingDetalleException("Estado no válido"));
        existente.setLista(lista);
        existente.setPicking(picking);
        return pickingDetalleRepository.save(existente);
    }
    public void eliminarPickingDetalle(Long id) {
        PickingDetalle detalle = pickingDetalleRepository.findById(id)
                .orElseThrow(() -> new InvalidPickingDetalleException("No se encontró el detalle con ID: " + id));
        pickingDetalleRepository.delete(detalle);
    }
    public PickingDetalle buscarPickingDetallePorId(Long id) {
        return pickingDetalleRepository.findById(id)
                .orElseThrow(() -> new InvalidPickingDetalleException("No encontrado"));
    }
    public List<PickingDetalle> obtenerTodos() {
        return pickingDetalleRepository.findAll();
    }
}