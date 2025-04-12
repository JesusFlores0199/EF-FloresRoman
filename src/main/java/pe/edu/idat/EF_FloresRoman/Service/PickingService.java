package pe.edu.idat.EF_FloresRoman.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.idat.EF_FloresRoman.Dto.PickingRegistroDto;
import pe.edu.idat.EF_FloresRoman.Model.Picking;
import pe.edu.idat.EF_FloresRoman.Repository.PickingRepository;
import java.util.List;
@Service
@RequiredArgsConstructor
public class PickingService {
    private final PickingRepository pickingRepository;

    public List<Picking> getAllPickings() {
        return pickingRepository.findAll();
    }
    public Picking getPickingById(Long id) {
        return pickingRepository.findById(id).orElseThrow(() -> new RuntimeException("Picking no encontrado"));
    }
    public Picking registrarPicking(PickingRegistroDto dto) {
        Picking picking = new Picking();
        picking.setEstado(dto.getEstado());
        return pickingRepository.save(picking);
    }
    public Picking actualizarPicking(Long id, PickingRegistroDto dto) {
        Picking picking = getPickingById(id);
        picking.setEstado(dto.getEstado());
        return pickingRepository.save(picking);
    }
    public Picking actualizarPicking(Picking picking) {
        return pickingRepository.save(picking);
    }
    public void eliminarPicking(Long id) {
        pickingRepository.deleteById(id);
    }
}
//listarPicking() → Retorna una lista con todos los registros de Picking.
//obtenerPickingXid(Integer id) → Busca un Picking específico por su ID.
//guardarPicking(Picking picking) → Guarda o actualiza un Picking en la base de datos.
//eliminarPicking(Integer id) → Elimina un Picking por su ID.