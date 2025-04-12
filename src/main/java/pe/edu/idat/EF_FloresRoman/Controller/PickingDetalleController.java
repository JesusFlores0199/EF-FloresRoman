package pe.edu.idat.EF_FloresRoman.Controller;
import org.springframework.security.access.prepost.PreAuthorize;
import pe.edu.idat.EF_FloresRoman.Dto.PickingDetalleRegistroDto;
import pe.edu.idat.EF_FloresRoman.Model.PickingDetalle;
import pe.edu.idat.EF_FloresRoman.Service.PickingDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/picking-detalle")
public class PickingDetalleController {
    @Autowired
    private PickingDetalleService service;
    @PreAuthorize("hasAnyRole('ADMIN', 'FINANZA')")
    @PostMapping
    public PickingDetalle registrar(@RequestBody PickingDetalleRegistroDto dto) {
        return service.registrarPickingDetalle(dto);
    }
    @PreAuthorize("hasAnyRole('ADMIN', 'FINANZA')")
    @PutMapping("/{id}")
    public PickingDetalle actualizar(@PathVariable Long id, @RequestBody PickingDetalleRegistroDto dto) {
        return service.actualizarPickingDetalle(id, dto);
    }
    @PreAuthorize("hasAnyRole('ADMIN', 'FINANZA')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminarPickingDetalle(id);
    }
    @PreAuthorize("hasAnyRole('ADMIN', 'FINANZA')")
    @GetMapping("/{id}")
    public PickingDetalle buscarPorId(@PathVariable Long id) {
        return service.buscarPickingDetallePorId(id);
    }
    @PreAuthorize("hasAnyRole('ADMIN', 'FINANZA')")
    @GetMapping
    public List<PickingDetalle> listar() {
        return service.obtenerTodos();
    }
}