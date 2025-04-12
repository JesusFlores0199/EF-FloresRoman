package pe.edu.idat.EF_FloresRoman.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.EF_FloresRoman.Dto.ClienteRegistroDto;
import pe.edu.idat.EF_FloresRoman.Model.Cliente;
import pe.edu.idat.EF_FloresRoman.Service.ClienteService;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/clientes")
public class ClientesController {
    @Autowired
    private ClienteService clienteService;
    // GET - Listar todos los clientes
    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes() {
        return ResponseEntity.ok(clienteService.getAllClientes());
    }
    // GET - Obtener cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.getClienteById(id));
    }
    // POST - Registrar un nuevo cliente
    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody ClienteRegistroDto dto) {
        return ResponseEntity.ok(clienteService.registrarCliente(dto));
    }
    // PUT - Actualizar un cliente completo
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody ClienteRegistroDto dto) {
        return ResponseEntity.ok(clienteService.actualizarCliente(id, dto));
    }
    // PATCH - Actualizar parcialmente un cliente (solo nombreEmpresa)
    @PatchMapping("/{id}")
    public ResponseEntity<Cliente> patchCliente(@PathVariable Long id, @RequestBody Map<String, Object> camposActualizados) {
        Cliente cliente = clienteService.getClienteById(id);

        if (camposActualizados.containsKey("nombreEmpresa")) {
            cliente.setNombreEmpresa((String) camposActualizados.get("nombreEmpresa"));
        }

        Cliente actualizado = clienteService.actualizarCliente(cliente);
        return ResponseEntity.ok(actualizado);
    }
    // DELETE - Eliminar cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }
}