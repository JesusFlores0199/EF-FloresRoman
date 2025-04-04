package pe.edu.idat.EF_FloresRoman.Exception;
public class ServiceException extends RuntimeException {
    private String errorCode;
    // Constructor con mensaje y código de error
    public ServiceException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    public String getErrorCode() {
        return errorCode;
    }
}