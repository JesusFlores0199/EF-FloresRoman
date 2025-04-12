package pe.edu.idat.EF_FloresRoman.Repository;
import org.springframework.stereotype.Repository;
import pe.edu.idat.EF_FloresRoman.Model.ListaDetalle;
import pe.edu.idat.EF_FloresRoman.Dto.ListaDetalleDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
@Repository
public interface ListaDetalleRepository extends JpaRepository<ListaDetalle, Long> {
    @Query("SELECT ld.id AS id, " +
            "ld.cliente.nombreEmpresa AS nombreEmpresa, " +
            "ld.obra.nomObra AS nomObra, " +
            "ld.obra.piso AS piso, " +
            "ld.lista.id AS listaId, " +
            "ld.fecha AS fecha, " +
            "ld.costoUnitario AS costoUnitario, " +
            "ld.costoTotal AS costoTotal " +
            "FROM ListaDetalle ld")
    List<ListaDetalleDto> findAllProjected();
}