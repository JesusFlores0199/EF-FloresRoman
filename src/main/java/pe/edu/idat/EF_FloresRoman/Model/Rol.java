package pe.edu.idat.EF_FloresRoman.Model;
import jakarta.persistence.*;
@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idrol;
    private String nomrol;
    public Long getIdrol() {
        return idrol;
    }
    public void setIdrol(Long idrol) {
        this.idrol = idrol;
    }
    public String getNomrol() {
        return nomrol;
    }
    public void setNomrol(String nomrol) {
        this.nomrol = nomrol;
    }
}