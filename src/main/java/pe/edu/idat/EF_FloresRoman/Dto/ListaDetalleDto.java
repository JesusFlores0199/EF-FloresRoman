package pe.edu.idat.EF_FloresRoman.Dto;
import java.math.BigDecimal;
import java.time.LocalDate;
public class ListaDetalleDto {
    private Long idlistadetalle;
    private String nombreEmpresa;
    private String nomObra;
    private String piso;
    private Long idLista;  // Relacion con Lista
    private LocalDate fecha;  // Cambiar a LocalDate
    private BigDecimal costoUnitario;
    private Integer cantidad;
    // Getters and setters
    public Long getId() {return idlistadetalle;}
    public void setId(Long id) {this.idlistadetalle = id;}
    public String getNombreEmpresa() {return nombreEmpresa;}
    public void setNombreEmpresa(String nombreEmpresa) {this.nombreEmpresa = nombreEmpresa;}
    public String getNomObra() {return nomObra;}
    public void setNomObra(String nomObra) {this.nomObra = nomObra;}
    public String getPiso() {return piso;}
    public void setPiso(String piso) {this.piso = piso;}
    public Long getIdLista() {return idLista;}
    public void setIdLista(Long idLista) {this.idLista = idLista;}
    public LocalDate getFecha() {return fecha;}  // Cambiar a LocalDate
    public void setFecha(LocalDate fecha) {this.fecha = fecha;}  // Cambiar a LocalDate
    public BigDecimal getCostoUnitario() {return costoUnitario;}
    public void setCostoUnitario(BigDecimal costoUnitario) {this.costoUnitario = costoUnitario;}
    public Integer getCantidad() {return cantidad;}
    public void setCantidad(Integer cantidad) {this.cantidad = cantidad;}
}