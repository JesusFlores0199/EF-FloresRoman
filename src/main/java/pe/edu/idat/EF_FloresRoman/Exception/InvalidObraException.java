package pe.edu.idat.EF_FloresRoman.Exception;
public class InvalidObraException extends RuntimeException {
    private final String errorCode;
    public InvalidObraException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    public String getErrorCode() {
        return errorCode;
    }
}