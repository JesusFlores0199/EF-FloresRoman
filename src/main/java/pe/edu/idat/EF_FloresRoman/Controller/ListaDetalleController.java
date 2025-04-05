package pe.edu.idat.EF_FloresRoman.Controller;
import pe.edu.idat.EF_FloresRoman.Dto.ListaDetalleDto;
import pe.edu.idat.EF_FloresRoman.Model.ListaDetalle;
import pe.edu.idat.EF_FloresRoman.Service.ListaDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/listaDetalle")
public class ListaDetalleController {
    private final ListaDetalleService listaDetalleService;
    @Autowired
    public ListaDetalleController(ListaDetalleService listaDetalleService) {
        this.listaDetalleService = listaDetalleService;
    }
    @PostMapping
    public ResponseEntity<ListaDetalle> createListaDetalle(@RequestBody ListaDetalleDto listaDetalleDto) {
        ListaDetalle savedListaDetalle = listaDetalleService.createListaDetalle(listaDetalleDto);
        return new ResponseEntity<>(savedListaDetalle, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ListaDetalle> updateListaDetalle(@PathVariable Long id, @RequestBody ListaDetalleDto listaDetalleDto) {
        ListaDetalle updatedListaDetalle = listaDetalleService.updateListaDetalle(id, listaDetalleDto);
        return ResponseEntity.ok(updatedListaDetalle);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteListaDetalle(@PathVariable Long id) {
        listaDetalleService.deleteListaDetalle(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ListaDetalle> getListaDetalleById(@PathVariable Long id) {
        ListaDetalle listaDetalle = listaDetalleService.getListaDetalleById(id);
        return ResponseEntity.ok(listaDetalle);
    }
    @GetMapping
    public ResponseEntity<List<ListaDetalle>> getAllListaDetalles() {
        List<ListaDetalle> listaDetalles = listaDetalleService.getAllListaDetalles();
        return ResponseEntity.ok(listaDetalles);
    }
}