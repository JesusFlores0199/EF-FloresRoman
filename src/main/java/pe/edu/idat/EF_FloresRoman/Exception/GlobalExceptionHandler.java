package pe.edu.idat.EF_FloresRoman.Exception;
import pe.edu.idat.EF_FloresRoman.Dto.GenericResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler {
    // Manejo para InvalidProductException
    @ExceptionHandler(InvalidProductException.class)
    public ResponseEntity<GenericResponseDto<String>> handleInvalidProductException(InvalidProductException ex) {
        return buildErrorResponse(ex.getMessage(), ex.getErrorCode(), HttpStatus.BAD_REQUEST);
    }
    // Manejo para InvalidListaException
    @ExceptionHandler(InvalidListaException.class)
    public ResponseEntity<GenericResponseDto<String>> handleInvalidListaException(InvalidListaException ex) {
        return buildErrorResponse(ex.getMessage(), ex.getErrorCode(), HttpStatus.BAD_REQUEST);
    }
    // Manejo para InvalidObraException
    @ExceptionHandler(InvalidObraException.class)
    public ResponseEntity<GenericResponseDto<String>> handleInvalidObraException(InvalidObraException ex) {
        return buildErrorResponse(ex.getMessage(), ex.getErrorCode(), HttpStatus.BAD_REQUEST);
    }
    // Manejo para InvalidClienteException
    @ExceptionHandler(InvalidClienteException.class)
    public ResponseEntity<GenericResponseDto<String>> handleInvalidClienteException(InvalidClienteException ex) {
        return buildErrorResponse(ex.getMessage(), ex.getErrorCode(), HttpStatus.BAD_REQUEST);
    }
    // Manejo para ResourceNotFoundException
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<GenericResponseDto<String>> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return buildErrorResponse(ex.getMessage(), ex.getErrorCode(), HttpStatus.NOT_FOUND);
    }
    // Manejo general de errores de servicio
    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<GenericResponseDto<String>> handleServiceException(ServiceException ex) {
        return buildErrorResponse("Error en el servicio: " + ex.getMessage(), ex.getErrorCode(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    // Manejo de errores generales
    @ExceptionHandler(Exception.class)
    public ResponseEntity<GenericResponseDto<String>> handleGeneralException(Exception ex) {
        return buildErrorResponse("Error inesperado: " + ex.getMessage(), "GENERIC_ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    // Método auxiliar para construir respuestas
    private ResponseEntity<GenericResponseDto<String>> buildErrorResponse(String mensaje, String codigo, HttpStatus status) {
        GenericResponseDto<String> response = new GenericResponseDto<>();
        response.setCorrecto(false);
        response.setMensaje(mensaje);
        response.setRespuesta("Código de error: " + codigo);
        return ResponseEntity.status(status).body(response);
    }
}