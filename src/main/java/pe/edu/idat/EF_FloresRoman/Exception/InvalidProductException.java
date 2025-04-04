package pe.edu.idat.EF_FloresRoman.Exception;
public class InvalidProductException extends RuntimeException {
    private String errorCode;
    // Constructor con mensaje y código de error
    public InvalidProductException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    public String getErrorCode() {
        return errorCode;
    }
}