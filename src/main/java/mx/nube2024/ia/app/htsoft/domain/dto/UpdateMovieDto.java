package mx.nube2024.ia.app.htsoft.domain.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

/*esta es una clase inmutable record, es decir nunca va a cambiar*/
public record UpdateMovieDto(

        @NotBlank(message = "El titulo es obligatorio")
        String titulo,
        @PastOrPresent(message = "La fecha de lanzamiento debe ser anterior a la fecha actual")
        LocalDate releaseDate,
        Double rating
        ) {

}
