package pe.edu.idat.EF_FloresRoman.Model;
import jakarta.persistence.*;
import java.util.Set;
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Column(name = "username")
    private String username;
    private String password;
    private Boolean activo;
    @ManyToMany(cascade = CascadeType.MERGE,
            fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol",
            joinColumns = @JoinColumn(name = "idusuario"),
            inverseJoinColumns = @JoinColumn(name = "idrol"))
    private Set<Rol> roles;
    // Getters y setters
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public Set<Rol> getRoles() {return roles;}
    public void setRoles(Set<Rol> roles) {this.roles = roles;}
    public Boolean getActivo() {return activo;}
    public void setActivo(Boolean activo) {this.activo = activo;}
}