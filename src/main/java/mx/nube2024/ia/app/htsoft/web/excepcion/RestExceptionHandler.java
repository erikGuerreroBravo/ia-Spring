package mx.nube2024.ia.app.htsoft.web.excepcion;

import mx.nube2024.ia.app.htsoft.domain.exception.MovieAlreadyExistException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;


//clase encargada de capturar las a excepciones que ocurran en la peticion
@RestControllerAdvice
public class RestExceptionHandler
{
    @ExceptionHandler(MovieAlreadyExistException.class)
    public ResponseEntity<Error> handleException(MovieAlreadyExistException ex){
    //creamos nuestro mensaje de error
        Error error= new Error("movie-already-existss",ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Error>> handleException(MethodArgumentNotValidException ex)
    {
         List<Error> errors = new ArrayList<>();
         ex.getBindingResult().getFieldErrors().forEach(error->{
             errors.add(new Error(error.getField(),error.getDefaultMessage()));
         });
         return ResponseEntity.badRequest().body(errors);
    }
    @ExceptionHandler(Exception.class)
   public ResponseEntity<Error> handleException(Exception ex){
        Error error = new Error("Error Desconocido",ex.getMessage());
        return ResponseEntity.internalServerError().body(error);
    }

}
