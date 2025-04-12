package pe.edu.idat.EF_FloresRoman.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@PreAuthorize("hasAnyRole('ADMIN', 'INGENIERIA', 'FINANZAS', 'VENDEDOR')")
@RestController
@RequestMapping("api/v1/demo")
@CrossOrigin(origins = {
        "http://front-admin.idat.pe",
        "http://front-docentes.idat.pe"
})
public class DemoController {
    @GetMapping("/saludo")
    public ResponseEntity<String> saludo() {
        return new ResponseEntity<>("Respuesta REST", HttpStatus.OK);
    }
}