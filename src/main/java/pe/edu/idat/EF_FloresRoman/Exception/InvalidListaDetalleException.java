package pe.edu.idat.EF_FloresRoman.Exception;
public class InvalidListaDetalleException extends RuntimeException {
    public InvalidListaDetalleException(String message) {
        super(message);
    }
    // Constructor con mensaje y la excepción original
    public InvalidListaDetalleException(String message, Throwable cause) {
        super(message, cause);
    }
}