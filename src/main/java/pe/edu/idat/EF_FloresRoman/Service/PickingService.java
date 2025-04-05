package pe.edu.idat.EF_FloresRoman.Service;
import pe.edu.idat.EF_FloresRoman.Dto.PickingRegistroDto;
import pe.edu.idat.EF_FloresRoman.Repository.PickingRepository;
import pe.edu.idat.EF_FloresRoman.Repository.Projection.PickingProjection;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class PickingService {
    private final PickingRepository pickingRepository;
    public PickingService(PickingRepository pickingRepository) {
        this.pickingRepository = pickingRepository;
    }
    // Listar todos los pickings
    public List<PickingProjection> obtenerTodosLosPickings() {
        return pickingRepository.obtenerTodosLosPickings();
    }
    // Obtener un picking por su ID
    public Optional<PickingProjection> obtenerPickingPorId(Integer id) {
        return pickingRepository.obtenerPickingPorId(id);
    }
    // Registrar un picking
    public void registrarPicking(PickingRegistroDto pickingRegistroDto) {
        try {
            pickingRepository.registrarPicking(
                    pickingRegistroDto.getEstado(),
                    pickingRegistroDto.getFecha().toString(),
                    pickingRegistroDto.getHora()
            );
        } catch (Exception e) {
            throw new RuntimeException("Error al registrar el picking: " + e.getMessage());
        }
    }
    // Actualizar un picking
    public void actualizarPicking(PickingRegistroDto pickingRegistroDto) {
        try {
            pickingRepository.actualizarPicking(
                    pickingRegistroDto.getId(),
                    pickingRegistroDto.getEstado(),
                    pickingRegistroDto.getFecha().toString(),
                    pickingRegistroDto.getHora()
            );
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar el picking: " + e.getMessage());
        }
    }
    // Eliminar un picking
    public void eliminarPicking(Integer id) {
        try {
            pickingRepository.eliminarPicking(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el picking: " + e.getMessage());
        }
    }
}
//listarPicking() → Retorna una lista con todos los registros de Picking.
//obtenerPickingXid(Integer id) → Busca un Picking específico por su ID.
//guardarPicking(Picking picking) → Guarda o actualiza un Picking en la base de datos.
//eliminarPicking(Integer id) → Elimina un Picking por su ID.