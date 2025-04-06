package pe.edu.idat.EF_FloresRoman;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class EfFloresRomanApplication {
	public static void main(String[] args) {
		SpringApplication.run(EfFloresRomanApplication.class, args);
	}
}
//Cliente → Representa la entidad JPA.
//ClienteDto → Para transferir datos.
//ClienteRegistroDto → Para registrar clientes.
//ClienteRepository → Interactúa con la base de datos.
//ClienteProjection → Permite obtener datos específicos.
//ClienteService → Contiene la lógica de negocio.
//ClientesController → Expone los endpoints REST.
