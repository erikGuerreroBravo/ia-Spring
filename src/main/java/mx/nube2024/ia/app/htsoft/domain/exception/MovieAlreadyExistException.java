package mx.nube2024.ia.app.htsoft.domain.exception;

public class MovieAlreadyExistException extends RuntimeException{
    public MovieAlreadyExistException(String movieTitle) {
        super("La pelicula "+ movieTitle + " ya existe");
    }
}
