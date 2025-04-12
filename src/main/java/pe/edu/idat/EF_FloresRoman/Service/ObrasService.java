package pe.edu.idat.EF_FloresRoman.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.idat.EF_FloresRoman.Dto.ObraRegistroDto;
import pe.edu.idat.EF_FloresRoman.Model.Obra;
import pe.edu.idat.EF_FloresRoman.Repository.ObrasRepository;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ObrasService {
    private final ObrasRepository obrasRepository;
    public List<Obra> getAllObras() {
        return obrasRepository.findAll();
    }
    public Obra getObraById(Long id) {
        return obrasRepository.findById(id).orElseThrow(() -> new RuntimeException("Obra no encontrada"));
    }
    public Obra registrarObra(ObraRegistroDto dto) {
        Obra obra = new Obra();
        obra.setNomObra(dto.getNomObra());
        obra.setPiso(dto.getPiso());
        return obrasRepository.save(obra);
    }
    public Obra actualizarObra(Long id, ObraRegistroDto dto) {
        Obra obra = getObraById(id);
        obra.setNomObra(dto.getNomObra());
        obra.setPiso(dto.getPiso());
        return obrasRepository.save(obra);
    }
    public Obra actualizarObra(Obra obra) {
        return obrasRepository.save(obra);
    }
    public void eliminarObra(Long id) {
        obrasRepository.deleteById(id);
    }
}