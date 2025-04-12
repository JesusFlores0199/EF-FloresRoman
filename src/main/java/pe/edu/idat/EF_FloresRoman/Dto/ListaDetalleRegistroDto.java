package pe.edu.idat.EF_FloresRoman.Dto;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ListaDetalleRegistroDto {
    private Long clienteId;
    private Long obraId;
    private Long listaId;
    private LocalDate fecha;
    private BigDecimal costoUnitario;
    private BigDecimal costoTotal;
}