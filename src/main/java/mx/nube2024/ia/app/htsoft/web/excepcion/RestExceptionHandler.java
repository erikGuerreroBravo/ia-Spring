package mx.nube2024.ia.app.htsoft.web.excepcion;

import mx.nube2024.ia.app.htsoft.domain.exception.MovieAlreadyExistException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


//clase encargada de capturar las a excepciones que ocurran en la peticion
@RestControllerAdvice
public class RestExceptionHandler
{
    @ExceptionHandler(MovieAlreadyExistException.class)
    public ResponseEntity<Error> handleException(Exception ex){
    //creamos nuestro mensaje de error
        Error error= new Error("movie-already-existss",ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }
}
