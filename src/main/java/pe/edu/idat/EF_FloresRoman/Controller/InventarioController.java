package pe.edu.idat.EF_FloresRoman.Controller;
import pe.edu.idat.EF_FloresRoman.Dto.InventarioRegistroDto;
import pe.edu.idat.EF_FloresRoman.Service.InventarioService;
import pe.edu.idat.EF_FloresRoman.Model.Inventario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/inventarios")
public class InventarioController {
    private final InventarioService inventarioService;
    @Autowired
    public InventarioController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }
    // Registrar inventario
    @PostMapping
    public void registrarInventario(@RequestBody InventarioRegistroDto inventarioDto) {
        inventarioService.registrarInventario(inventarioDto);
    }
    // Actualizar inventario
    @PutMapping("/{id}")
    public Inventario actualizarInventario(@PathVariable Long id, @RequestBody InventarioRegistroDto inventarioRegistroDto) {
        return inventarioService.actualizarInventario(id, inventarioRegistroDto);
    }
    // Obtener todos los inventarios
    @GetMapping
    public List<Inventario> getAllInventarios() {
        return inventarioService.getAllInventarios();
    }
    // Obtener inventario por ID
    @GetMapping("/{id}")
    public Inventario getInventarioById(@PathVariable Long id) {
        return inventarioService.getInventarioById(id);
    }
    // Eliminar inventario
    @DeleteMapping("/{id}")
    public void deleteInventario(@PathVariable Long id) {
        inventarioService.deleteInventario(id);
    }
}