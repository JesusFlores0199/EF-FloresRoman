package pe.edu.idat.EF_FloresRoman.Exception;
public class InvalidListaException extends RuntimeException {
    private final String errorCode;
    public InvalidListaException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    public String getErrorCode() {
        return errorCode;
    }
}