package pe.edu.idat.EF_FloresRoman.Service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface IClienteService extends UserDetailsService {

    @Override
    default UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
