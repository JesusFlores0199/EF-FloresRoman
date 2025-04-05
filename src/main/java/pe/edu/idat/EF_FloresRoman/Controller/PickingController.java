package pe.edu.idat.EF_FloresRoman.Controller;
import pe.edu.idat.EF_FloresRoman.Dto.PickingRegistroDto;
import pe.edu.idat.EF_FloresRoman.Service.PickingService;
import pe.edu.idat.EF_FloresRoman.Repository.Projection.PickingProjection;
import pe.edu.idat.EF_FloresRoman.Dto.GenericResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/picking")
public class PickingController {
    private final PickingService pickingService;
    public PickingController(PickingService pickingService) {
        this.pickingService = pickingService;
    }
    // Listar todos los registros de picking
    @GetMapping("/listar")
    public ResponseEntity<List<PickingProjection>> obtenerTodosLosPickings() {
        List<PickingProjection> pickings = pickingService.obtenerTodosLosPickings();
        return ResponseEntity.ok(pickings);
    }
    // Obtener un picking por su ID
    @GetMapping("/{id}")
    public ResponseEntity<PickingProjection> obtenerPickingPorId(@PathVariable Integer id) {
        return pickingService.obtenerPickingPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    // Registrar un nuevo picking
    @PostMapping("/registrar")
    public ResponseEntity<GenericResponseDto<String>> registrarPicking(@RequestBody PickingRegistroDto pickingRegistroDto) {
        pickingService.registrarPicking(pickingRegistroDto);
        GenericResponseDto<String> response = new GenericResponseDto<>();
        response.setCorrecto(true);
        response.setMensaje("Picking registrado exitosamente.");
        return ResponseEntity.ok(response);
    }
    // Actualizar un picking existente
    @PutMapping("/actualizar")
    public ResponseEntity<GenericResponseDto<String>> actualizarPicking(@RequestBody PickingRegistroDto pickingRegistroDto) {
        pickingService.actualizarPicking(pickingRegistroDto);
        GenericResponseDto<String> response = new GenericResponseDto<>();
        response.setCorrecto(true);
        response.setMensaje("Picking actualizado exitosamente.");
        return ResponseEntity.ok(response);
    }
    // Eliminar un picking por su ID
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<GenericResponseDto<String>> eliminarPicking(@PathVariable Integer id) {
        pickingService.eliminarPicking(id);
        GenericResponseDto<String> response = new GenericResponseDto<>();
        response.setCorrecto(true);
        response.setMensaje("Picking eliminado exitosamente.");
        return ResponseEntity.ok(response);
    }
}