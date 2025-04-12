package pe.edu.idat.EF_FloresRoman.Security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import pe.edu.idat.EF_FloresRoman.Service.impl.DetalleUsuarioService;
@EnableWebSecurity
@EnableMethodSecurity
@Configuration
public class SecurityConfig {
    private final DetalleUsuarioService detalleUsuarioService;
    // Constructor para inyectar DetalleUsuarioService
    public SecurityConfig(DetalleUsuarioService detalleUsuarioService) {
        this.detalleUsuarioService = detalleUsuarioService;
    }
    // Configuración del SecurityFilterChain
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable) // Deshabilitar CSRF (Cross-Site Request Forgery) o falsificación de petición en sitios cruzados
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET, "/api/v1/auth/login") // Permitir acceso al login sin autenticación
                        .permitAll()
                        .anyRequest().authenticated() // Requiere autenticación para cualquier otra solicitud
                )
                .authenticationProvider(getAuthenticationProvider()) // Configuración de autenticación con el proveedor definido abajo
                .addFilterBefore(new FiltroJWTAuthorization(), UsernamePasswordAuthenticationFilter.class); // Agregar filtro JWT antes del filtro estándar
        return http.build(); // Retorna la configuración construida
    }
    // Bean para el codificador de contraseñas (BCrypt)
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Codificador para la contraseña
    }
    // Bean para el proveedor de autenticación (DaoAuthenticationProvider)
    @Bean
    public AuthenticationProvider getAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder()); // Establecer el codificador de contraseñas
        daoAuthenticationProvider.setUserDetailsService(detalleUsuarioService); // Configurar el servicio que carga los detalles del usuario
        return daoAuthenticationProvider; // Retorna el proveedor de autenticación
    }
    // Bean para el AuthenticationManager
    @Bean
    public AuthenticationManager getAuthenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager(); // Retorna el AuthenticationManager de la configuración
    }
}