package mx.nube2024.ia.app.htsoft.domain.dto;


import java.time.LocalDate;

/*esta es una clase inmutable record, es decir nunca va a cambiar*/
public record UpdateMovieDto(

        String title,
        LocalDate releaseDate,
        Double rating
        ) {

}
