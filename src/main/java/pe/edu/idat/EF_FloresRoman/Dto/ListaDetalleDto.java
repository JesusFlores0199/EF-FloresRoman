package pe.edu.idat.EF_FloresRoman.Dto;
import java.math.BigDecimal;
import java.time.LocalDate;
public interface ListaDetalleDto {
    Long getId();
    String getNombreEmpresa();   // De Cliente
    String getNomObra();         // De Obra
    String getPiso();            // De Obra
    Long getListaId();     // De Lista
    LocalDate getFecha();
    BigDecimal getCostoUnitario();
    BigDecimal getCostoTotal();
}