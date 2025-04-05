package pe.edu.idat.EF_FloresRoman.Controller;
import pe.edu.idat.EF_FloresRoman.Dto.ListaRegistroDto;
import pe.edu.idat.EF_FloresRoman.Model.Lista;
import pe.edu.idat.EF_FloresRoman.Service.ListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/listas")
public class ListaController {
    private final ListaService listaService;
    @Autowired
    public ListaController(ListaService listaService) {
        this.listaService = listaService;
    }
    @GetMapping
    public List<Lista> getAllListas() {
        return listaService.getAllListas();
    }
    @GetMapping("/producto/{idProduct}")
    public List<Lista> obtenerListasPorProducto(@PathVariable Long idProduct) {
        return listaService.obtenerListasPorProducto(idProduct);
    }
    @GetMapping("/cantidad/{idProduct}")
    public Integer obtenerCantidadPorProducto(@PathVariable Long idProduct) {
        return listaService.obtenerCantidadPorProducto(idProduct);
    }
    @GetMapping("/{id}")
    public Lista getListaById(@PathVariable Long id) {
        return listaService.getListaById(id);
    }
    @PostMapping
    public Lista createLista(@RequestBody ListaRegistroDto listaRegistroDto) {
        return listaService.createLista(listaRegistroDto);
    }
    @PutMapping("/{id}")
    public Lista updateLista(@PathVariable Long id, @RequestBody ListaRegistroDto listaRegistroDto) {
        return listaService.updateLista(id, listaRegistroDto);
    }
    @DeleteMapping("/{id}")
    public void deleteLista(@PathVariable Long id) {listaService.deleteLista(id);
    }
}