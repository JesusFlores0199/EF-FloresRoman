package pe.edu.idat.EF_FloresRoman.Dto;
public class UsuarioSeguridadDto {
    private Long id;
    private String username;
    private String token;
    private String mensajeError;
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}
    public String getToken() {return token;}
    public void setToken(String token) {this.token = token;}
    public String getMensajeError() {return mensajeError;}
    public void setMensajeError(String mensajeError) {this.mensajeError = mensajeError;}
}
