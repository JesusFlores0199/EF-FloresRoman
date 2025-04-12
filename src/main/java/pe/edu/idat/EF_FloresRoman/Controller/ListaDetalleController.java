package pe.edu.idat.EF_FloresRoman.Controller;
import pe.edu.idat.EF_FloresRoman.Dto.ListaDetalleDto;
import pe.edu.idat.EF_FloresRoman.Dto.ListaDetalleRegistroDto;
import pe.edu.idat.EF_FloresRoman.Model.ListaDetalle;
import pe.edu.idat.EF_FloresRoman.Service.ListaDetalleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/listadetalle")
@RequiredArgsConstructor
public class ListaDetalleController {
    private final ListaDetalleService service;
    @PostMapping
    public ListaDetalle registrar(@RequestBody ListaDetalleRegistroDto dto) {
        return service.registrarListaDetalle(dto);
    }
    @PutMapping("/{id}")
    public ListaDetalle actualizar(@PathVariable Long id, @RequestBody ListaDetalleRegistroDto dto) {
        return service.actualizarListaDetalle(id, dto);
    }
    @GetMapping
    public List<ListaDetalleDto> listarTodos() {
        return service.obtenerTodos();
    }
    @GetMapping("/{id}")
    public ListaDetalle obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminarListaDetalle(id);
    }
}