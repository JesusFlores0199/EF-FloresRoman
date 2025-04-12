package pe.edu.idat.EF_FloresRoman.Exception;
public class ResourceNotFoundException extends RuntimeException {
    private String errorCode;

    public ResourceNotFoundException(String message, String errorCode) {
        super(message);this.errorCode = errorCode;}
    public String getErrorCode() {return errorCode;}
}