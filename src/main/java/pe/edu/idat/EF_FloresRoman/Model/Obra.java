package pe.edu.idat.EF_FloresRoman.Model;
import jakarta.persistence.*;
@Entity
@Table(name = "obra")
public class Obra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idObra;
    @Column(nullable = false)
    private String nomObra;
    @Column(nullable = false)
    private Integer piso;
    // Getters y Setters
    public Integer getIdObra() {return idObra;}
    public void setIdObra(Integer idObra) {this.idObra = idObra;}
    public String getNomObra() {return nomObra;}
    public void setNomObra(String nomObra) {this.nomObra = nomObra;}
    public Integer getPiso() {return piso;}
    public void setPiso(Integer piso) {this.piso = piso;}
}