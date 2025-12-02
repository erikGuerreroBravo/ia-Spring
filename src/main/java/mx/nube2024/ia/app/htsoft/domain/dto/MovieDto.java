package mx.nube2024.ia.app.htsoft.domain.dto;


import java.time.LocalDate;

/*esta es una clase inmutable record, es decir nunca va a cambiar*/
public record MovieDto(
        String title,
        Integer duration,
        String genere,
        LocalDate releaseDate,
        Double rating
        ) {

}
