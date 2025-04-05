package pe.edu.idat.EF_FloresRoman.Controller;
import pe.edu.idat.EF_FloresRoman.Dto.ClienteRegistroDto;
import pe.edu.idat.EF_FloresRoman.Service.ClienteService;
import pe.edu.idat.EF_FloresRoman.Repository.Projection.ClienteProjection;
import pe.edu.idat.EF_FloresRoman.Dto.GenericResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/clientes")
public class ClientesController {
    private final ClienteService clienteService;
    public ClientesController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    // Listar todos los clientes
    @GetMapping("/listar")
    public ResponseEntity<List<ClienteProjection>> obtenerTodosLosClientes() {
        List<ClienteProjection> clientes = clienteService.obtenerTodosLosClientes();
        return ResponseEntity.ok(clientes);
    }
    // Obtener un cliente por su ID
    @GetMapping("/{id}")
    public ResponseEntity<ClienteProjection> obtenerClientePorId(@PathVariable Integer id) {
        return clienteService.obtenerClientePorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    // Registrar un nuevo cliente
    @PostMapping("/registrar")
    public ResponseEntity<GenericResponseDto<String>> registrarCliente(@RequestBody ClienteRegistroDto clienteRegistroDto) {
        clienteService.registrarCliente(clienteRegistroDto);
        GenericResponseDto<String> response = new GenericResponseDto<>();
        response.setCorrecto(true);
        response.setMensaje("Cliente registrado exitosamente.");
        return ResponseEntity.ok(response);
    }
    // Actualizar un cliente existente
    @PutMapping("/actualizar")
    public ResponseEntity<GenericResponseDto<String>> actualizarCliente(@RequestBody ClienteRegistroDto clienteRegistroDto) {
        clienteService.actualizarCliente(clienteRegistroDto);
        GenericResponseDto<String> response = new GenericResponseDto<>();
        response.setCorrecto(true);
        response.setMensaje("Cliente actualizado exitosamente.");
        return ResponseEntity.ok(response);
    }
    // Eliminar un cliente por su ID
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<GenericResponseDto<String>> eliminarCliente(@PathVariable Integer id) {
        clienteService.eliminarCliente(id);
        GenericResponseDto<String> response = new GenericResponseDto<>();
        response.setCorrecto(true);
        response.setMensaje("Cliente eliminado exitosamente.");
        return ResponseEntity.ok(response);
    }
}