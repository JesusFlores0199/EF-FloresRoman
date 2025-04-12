package pe.edu.idat.EF_FloresRoman.Model;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Table(name = "lista_detalle")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListaDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "obra_id")
    private Obra obra;
    @ManyToOne
    @JoinColumn(name = "id_tabla_list")
    private Lista lista;
    @Column(name = "fecha")
    private LocalDate fecha;
    @Column(name = "costo_unitario")
    private BigDecimal costoUnitario;
    @Column(name = "costo_total")
    private BigDecimal costoTotal;
}