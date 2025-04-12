package pe.edu.idat.EF_FloresRoman.Controller;
import org.springframework.security.access.prepost.PreAuthorize;
import pe.edu.idat.EF_FloresRoman.Dto.GenericResponseDto;
import pe.edu.idat.EF_FloresRoman.Dto.ProductoRegistroDto;
import pe.edu.idat.EF_FloresRoman.Service.ProductoService;
import pe.edu.idat.EF_FloresRoman.Repository.Projection.ProductProjection;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/productos")
public class ProductoController {
    private final ProductoService productoService;
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }
    // Listar todos los productos
    @PreAuthorize("hasAnyRole('ADMIN', 'INGENIERO')")
    @GetMapping("/listar")
    public ResponseEntity<List<ProductProjection>> obtenerTodosLosProductos(
            @RequestParam(required = false) Long unitsInStock) {
        List<ProductProjection> productos = productoService.obtenerTodosLosProductos(unitsInStock);
        return ResponseEntity.ok(productos);
    }
    // Obtener un producto por su ID
    @PreAuthorize("hasAnyRole('ADMIN', 'INGENIERO')")
    @GetMapping("/{id}")
    public ResponseEntity<ProductProjection> obtenerProductoPorId(@PathVariable Integer id) {
        List<ProductProjection> productos = productoService.obtenerTodosLosProductos(null);
        return productos.stream()
                .filter(producto -> producto.getIdProduct().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    // Registrar un nuevo producto
    @PreAuthorize("hasAnyRole('ADMIN', 'INGENIERO')")
    @PostMapping("/registrar")
    public ResponseEntity<GenericResponseDto<String>> registrarProducto(@Valid @RequestBody ProductoRegistroDto productoRegistroDto, BindingResult result) {
        GenericResponseDto<String> response = new GenericResponseDto<>();
        if (result.hasErrors()) {
            response.setCorrecto(false);
            response.setMensaje("Error de validación");
            response.setMensajeError(result.getAllErrors().toString());
            return ResponseEntity.badRequest().body(response);
        }
        try {
            productoService.registrarProducto(productoRegistroDto);
            response.setCorrecto(true);
            response.setMensaje("Producto registrado exitosamente.");
            response.setRespuesta("Registro exitoso");
        } catch (Exception e) {
            response.setCorrecto(false);
            response.setMensaje("Error al registrar el producto.");
            response.setMensajeError(e.getMessage());
        }
        return ResponseEntity.ok(response);
    }
    // Actualizar un producto existente
    @PreAuthorize("hasAnyRole('ADMIN', 'INGENIERO')")
    @PutMapping("/actualizar")
    public ResponseEntity<GenericResponseDto<String>> actualizarProducto(@RequestBody ProductoRegistroDto productoRegistroDto) {
        GenericResponseDto<String> response = new GenericResponseDto<>();
        try {
            productoService.actualizarProducto(productoRegistroDto);
            response.setCorrecto(true);
            response.setMensaje("Producto actualizado exitosamente.");
            response.setRespuesta("Actualización exitosa");
        } catch (Exception e) {
            response.setCorrecto(false);
            response.setMensaje("Error al actualizar el producto.");
            response.setMensajeError(e.getMessage());
        }
        return ResponseEntity.ok(response);
    }
    // Eliminar un producto por su ID
    @PreAuthorize("hasAnyRole('ADMIN', 'INGENIERO')")
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<GenericResponseDto<String>> eliminarProducto(@PathVariable Long id) {
        GenericResponseDto<String> response = new GenericResponseDto<>();
        try {
            productoService.eliminarProducto(id);
            response.setCorrecto(true);
            response.setMensaje("Producto eliminado exitosamente.");
            response.setRespuesta("Eliminación exitosa");
        } catch (Exception e) {
            response.setCorrecto(false);
            response.setMensaje("Error al eliminar el producto.");
            response.setMensajeError(e.getMessage());
        }
        return ResponseEntity.ok(response);
    }
}