package pe.edu.idat.EF_FloresRoman.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.idat.EF_FloresRoman.Dto.ClienteRegistroDto;
import pe.edu.idat.EF_FloresRoman.Model.Cliente;
import pe.edu.idat.EF_FloresRoman.Repository.ClienteRepository;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    // Listar todos los clientes
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    // Obtener cliente por ID
    public Cliente getClienteById(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));
    }
    // Registrar nuevo cliente
    public Cliente registrarCliente(ClienteRegistroDto dto) {
        Cliente cliente = new Cliente();
        cliente.setNombreEmpresa(dto.getNombreEmpresa());
        return clienteRepository.save(cliente);
    }

    // Actualizar cliente completo
    public Cliente actualizarCliente(Long id, ClienteRegistroDto dto) {
        Cliente cliente = getClienteById(id);
        cliente.setNombreEmpresa(dto.getNombreEmpresa());
        return clienteRepository.save(cliente);
    }

    // Actualizar parcialmente (desde PATCH)
    public Cliente actualizarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Eliminar cliente
    public void eliminarCliente(Long id) {
        Cliente cliente = getClienteById(id);
        clienteRepository.delete(cliente);
    }
}