package pe.edu.idat.EF_FloresRoman.Service;
import pe.edu.idat.EF_FloresRoman.Dto.ClienteRegistroDto;
import pe.edu.idat.EF_FloresRoman.Repository.ClienteRepository;
import pe.edu.idat.EF_FloresRoman.Repository.Projection.ClienteProjection;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    public List<ClienteProjection> obtenerTodosLosClientes() {
        return clienteRepository.obtenerTodosLosClientes();
    }
    public Optional<ClienteProjection> obtenerClientePorId(Integer id) {
        return clienteRepository.obtenerClientePorId(id);
    }
    public void registrarCliente(ClienteRegistroDto clienteRegistroDto) {
        clienteRepository.registrarCliente(clienteRegistroDto.getNombreEmpresa());
    }
    public void actualizarCliente(ClienteRegistroDto clienteRegistroDto) {
        clienteRepository.actualizarCliente(clienteRegistroDto.getId(), clienteRegistroDto.getNombreEmpresa());
    }
    public void eliminarCliente(Integer id) {
        clienteRepository.eliminarCliente(id);
    }
}