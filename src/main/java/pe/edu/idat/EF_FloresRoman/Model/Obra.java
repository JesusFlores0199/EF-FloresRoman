package pe.edu.idat.EF_FloresRoman.Model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "obra")
@Getter
@Setter
public class Obra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idObra;
    @Column(nullable = false)
    private String nomObra;
    @Column(nullable = false)
    private Integer piso;
    // Getters y Setters
    public Long getIdObra() {return idObra;}
    public void setIdObra(Long idObra) {this.idObra = idObra;}
    public String getNomObra() {return nomObra;}
    public void setNomObra(String nomObra) {this.nomObra = nomObra;}
    public Integer getPiso() {return piso;}
    public void setPiso(Integer piso) {this.piso = piso;}
}