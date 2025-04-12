package pe.edu.idat.EF_FloresRoman.Dto;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ObraRegistroDto {
    private Long id;
    private String nomObra;
    private Integer piso;
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getNomObra() {return nomObra;}
    public void setNomObra(String nomObra) {this.nomObra = nomObra;}
    public Integer getPiso() {return piso;}
    public void setPiso(Integer piso) {this.piso = piso;}
}