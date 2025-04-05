package pe.edu.idat.EF_FloresRoman.Controller;
import pe.edu.idat.EF_FloresRoman.Dto.ObraRegistroDto;
import pe.edu.idat.EF_FloresRoman.Service.ObrasService;
import pe.edu.idat.EF_FloresRoman.Repository.Projection.ObraProjection;
import pe.edu.idat.EF_FloresRoman.Dto.GenericResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/obras")
public class ObrasController {
    private final ObrasService obrasService;
    public ObrasController(ObrasService obrasService) {
        this.obrasService = obrasService;
    }
    // Listar todas las obras
    @GetMapping("/listar")
    public ResponseEntity<List<ObraProjection>> obtenerTodasLasObras() {
        List<ObraProjection> obras = obrasService.obtenerTodasLasObras();
        return ResponseEntity.ok(obras);
    }
    // Obtener una obra por su ID
    @GetMapping("/{id}")
    public ResponseEntity<ObraProjection> obtenerObraPorId(@PathVariable Long id) {
        return obrasService.obtenerObraPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    // Registrar una nueva obra
    @PostMapping("/registrar")
    public ResponseEntity<GenericResponseDto<String>> registrarObra(@RequestBody ObraRegistroDto obraRegistroDto) {
        obrasService.registrarObra(obraRegistroDto);
        GenericResponseDto<String> response = new GenericResponseDto<>();
        response.setCorrecto(true);
        response.setMensaje("Obra registrada exitosamente.");
        return ResponseEntity.ok(response);
    }
    // Actualizar una obra existente
    @PutMapping("/actualizar")
    public ResponseEntity<GenericResponseDto<String>> actualizarObra(@RequestBody ObraRegistroDto obraRegistroDto) {
        obrasService.actualizarObra(obraRegistroDto);
        GenericResponseDto<String> response = new GenericResponseDto<>();
        response.setCorrecto(true);
        response.setMensaje("Obra actualizada exitosamente.");
        return ResponseEntity.ok(response);
    }
    // Eliminar una obra por su ID
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<GenericResponseDto<String>> eliminarObra(@PathVariable Long id) {
        obrasService.eliminarObra(id);
        GenericResponseDto<String> response = new GenericResponseDto<>();
        response.setCorrecto(true);
        response.setMensaje("Obra eliminada exitosamente.");
        return ResponseEntity.ok(response);
    }
}