package pe.edu.idat.EF_FloresRoman.Controller;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.EF_FloresRoman.Dto.ObraRegistroDto;
import pe.edu.idat.EF_FloresRoman.Model.Obra;
import pe.edu.idat.EF_FloresRoman.Service.ObrasService;
import java.util.List;
@RestController
@RequestMapping("/obras")
@RequiredArgsConstructor
public class ObrasController {
    private final ObrasService obrasService;

    @GetMapping
    public List<Obra> listarObras() {
        return obrasService.getAllObras();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Obra> obtenerObraPorId(@PathVariable Long id) {
        return ResponseEntity.ok(obrasService.getObraById(id));
    }
    @PostMapping
    public ResponseEntity<Obra> registrarObra(@RequestBody ObraRegistroDto dto) {
        return ResponseEntity.ok(obrasService.registrarObra(dto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Obra> actualizarObra(@PathVariable Long id, @RequestBody ObraRegistroDto dto) {
        return ResponseEntity.ok(obrasService.actualizarObra(id, dto));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Obra> actualizarObraParcial(@PathVariable Long id, @RequestBody Obra obra) {
        Obra obraExistente = obrasService.getObraById(id);
        if (obra.getNomObra() != null) obraExistente.setNomObra(obra.getNomObra());
        if (obra.getPiso() != null) obraExistente.setPiso(obra.getPiso());
        return ResponseEntity.ok(obrasService.actualizarObra(obraExistente));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarObra(@PathVariable Long id) {
        obrasService.eliminarObra(id);
        return ResponseEntity.noContent().build();
    }
}