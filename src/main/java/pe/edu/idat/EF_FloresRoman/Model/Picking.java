package pe.edu.idat.EF_FloresRoman.Model;
import jakarta.persistence.*;
@Entity
@Table(name = "picking")
public class Picking {
    private Integer id;
    private String estado;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
}