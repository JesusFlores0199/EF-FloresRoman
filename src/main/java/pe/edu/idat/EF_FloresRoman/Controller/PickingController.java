package pe.edu.idat.EF_FloresRoman.Controller;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.EF_FloresRoman.Dto.PickingRegistroDto;
import pe.edu.idat.EF_FloresRoman.Model.Picking;
import pe.edu.idat.EF_FloresRoman.Service.PickingService;
import java.util.List;
@RestController
@RequestMapping("/pickings")
@RequiredArgsConstructor
public class PickingController {
    private final PickingService pickingService;
    @GetMapping
    public List<Picking> listarPickings() {
        return pickingService.getAllPickings();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Picking> obtenerPickingPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pickingService.getPickingById(id));
    }
    @PostMapping
    public ResponseEntity<Picking> registrarPicking(@RequestBody PickingRegistroDto dto) {
        return ResponseEntity.ok(pickingService.registrarPicking(dto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Picking> actualizarPicking(@PathVariable Long id, @RequestBody PickingRegistroDto dto) {
        return ResponseEntity.ok(pickingService.actualizarPicking(id, dto));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Picking> actualizarPickingParcial(@PathVariable Long id, @RequestBody Picking picking) {
        Picking PickingExistente = pickingService.getPickingById(id);
        if (picking.getEstado() != null) PickingExistente.setEstado(picking.getEstado());
        return ResponseEntity.ok(pickingService.actualizarPicking(PickingExistente));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPicking(@PathVariable Long id) {
        pickingService.eliminarPicking(id);
        return ResponseEntity.noContent().build();
    }
}