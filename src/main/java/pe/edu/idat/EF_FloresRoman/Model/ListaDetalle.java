package pe.edu.idat.EF_FloresRoman.Model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Table(name = "lista_detalle")
public class ListaDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_empresa")
    private String nombreEmpresa;
    @Column(name = "nom_obra")
    private String nomObra;
    @Column(name = "piso")
    private String piso;
    @ManyToOne
    @JoinColumn(name = "id_tabla_list")
    private Lista lista;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate fecha;
    @Column(name = "costo_unitario")
    private BigDecimal costoUnitario;
    @Column(name = "costo_total")
    private BigDecimal costoTotal;
    // Getters and setters
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getNombreEmpresa() {return nombreEmpresa;}
    public void setNombreEmpresa(String nombreEmpresa) {this.nombreEmpresa = nombreEmpresa;}
    public String getNomObra() {return nomObra;}
    public void setNomObra(String nomObra) {this.nomObra = nomObra;}
    public String getPiso() {return piso;}
    public void setPiso(String piso) {this.piso = piso;}
    public Lista getLista() {return lista;}
    public void setLista(Lista lista) {this.lista = lista;}
    public LocalDate getFecha() {return fecha;}
    public void setFecha(LocalDate fecha) {this.fecha = fecha;}
    public BigDecimal getCostoUnitario() {return costoUnitario;}
    public void setCostoUnitario(BigDecimal costoUnitario) {this.costoUnitario = costoUnitario;}
    public BigDecimal getCostoTotal() {return costoTotal;}
    public void setCostoTotal(BigDecimal costoTotal) {this.costoTotal = costoTotal;}
}