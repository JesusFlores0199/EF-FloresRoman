package pe.edu.idat.EF_FloresRoman.Exception;
public class InvalidPickingException extends RuntimeException {
    private final String errorCode;
    public InvalidPickingException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    public String getErrorCode() {
        return errorCode;
    }
}