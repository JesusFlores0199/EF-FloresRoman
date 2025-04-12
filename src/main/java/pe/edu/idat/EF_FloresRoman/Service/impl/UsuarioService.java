package pe.edu.idat.EF_FloresRoman.Service.impl;
import org.springframework.stereotype.Service;
import pe.edu.idat.EF_FloresRoman.Model.Usuario;
import pe.edu.idat.EF_FloresRoman.Repository.UsuarioRepository;
import pe.edu.idat.EF_FloresRoman.Service.IUsuarioService;
@Service
public class UsuarioService implements IUsuarioService {
    private final UsuarioRepository usuarioRepository;
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    @Override
    public Usuario obtenerUsuarioxNomusuario(String username) {
        return usuarioRepository.findByUsername(username);
    }
}