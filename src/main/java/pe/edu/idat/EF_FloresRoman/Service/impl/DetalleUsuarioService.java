package pe.edu.idat.EF_FloresRoman.Service.impl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.idat.EF_FloresRoman.Model.Rol;
import pe.edu.idat.EF_FloresRoman.Model.Usuario;
import pe.edu.idat.EF_FloresRoman.Service.IUsuarioService;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Service
public class DetalleUsuarioService implements UserDetailsService {
    private final IUsuarioService iUsuarioService;
    public DetalleUsuarioService(IUsuarioService iUsuarioService) {
        this.iUsuarioService = iUsuarioService;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Obtén el usuario a través del servicio IUsuarioService
        Usuario usuario = iUsuarioService.obtenerUsuarioxNomusuario(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado con el nombre de usuario: " + username);
        }
        // Retorna un objeto UserDetails que Spring Security usará
        return getUserDetails(usuario, getAuthorities(usuario.getRoles()));
    }
    public List<GrantedAuthority> getAuthorities(Set<Rol> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Rol rol : roles) {
            // Asigna roles con el prefijo "ROLE_"
            authorities.add(new SimpleGrantedAuthority("ROLE_" + rol.getNomrol()));
        }
        return authorities;
    }
    private UserDetails getUserDetails(Usuario usuario, List<GrantedAuthority> authorities) {
        // Crea un objeto UserDetails con la información del usuario y sus roles
        return new User(
                usuario.getUsername(),
                usuario.getPassword(),
                usuario.getActivo(),
                true, // No expirado
                true, // Credenciales no expiradas
                true, // Cuenta no bloqueada
                authorities // Las autoridades/roles del usuario
        );
    }
}