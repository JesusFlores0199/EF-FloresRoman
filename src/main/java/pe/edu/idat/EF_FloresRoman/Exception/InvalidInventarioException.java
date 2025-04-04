package pe.edu.idat.EF_FloresRoman.Exception;
public class InvalidInventarioException extends RuntimeException {
    private final String code;
    public InvalidInventarioException(String message, String code) {
        super(message);
        this.code = code;
    }
    public String getCode() {
        return code;
    }
}