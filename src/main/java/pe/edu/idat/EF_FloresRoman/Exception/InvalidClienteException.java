package pe.edu.idat.EF_FloresRoman.Exception;
public class InvalidClienteException extends RuntimeException {
    private final String errorCode;
    public InvalidClienteException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    public String getErrorCode() {
        return errorCode;
    }
}