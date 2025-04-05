package pe.edu.idat.EF_FloresRoman.Service;
import pe.edu.idat.EF_FloresRoman.Dto.ObraRegistroDto;
import pe.edu.idat.EF_FloresRoman.Repository.ObrasRepository;
import pe.edu.idat.EF_FloresRoman.Repository.Projection.ObraProjection;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class ObrasService {
    private final ObrasRepository obrasRepository;

    public ObrasService(ObrasRepository obrasRepository) {
        this.obrasRepository = obrasRepository;
    }
    // Listar todas las obras
    public List<ObraProjection> obtenerTodasLasObras() {
        return obrasRepository.obtenerTodasLasObras();
    }
    // Obtener una obra por su ID
    public Optional<ObraProjection> obtenerObraPorId(Long id) {
        return obrasRepository.obtenerObraPorId(id);
    }
    // Registrar una nueva obra
    public void registrarObra(ObraRegistroDto obraRegistroDto) {
        try {
            obrasRepository.registrarObra(obraRegistroDto.getNomObra(), obraRegistroDto.getPiso());
        } catch (Exception e) {
            throw new RuntimeException("Error al registrar la obra: " + e.getMessage());
        }
    }
    // Actualizar una obra existente
    public void actualizarObra(ObraRegistroDto obraRegistroDto) {
        try {
            obrasRepository.actualizarObra(
                    obraRegistroDto.getId(),
                    obraRegistroDto.getNomObra(),
                    obraRegistroDto.getPiso()
            );
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar la obra: " + e.getMessage());
        }
    }
    // Eliminar una obra por su ID
    public void eliminarObra(Long id) {
        try {
            obrasRepository.eliminarObra(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar la obra: " + e.getMessage());
        }
    }
}