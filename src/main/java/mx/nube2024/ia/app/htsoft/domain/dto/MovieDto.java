package mx.nube2024.ia.app.htsoft.domain.dto;


import mx.nube2024.ia.app.htsoft.domain.Genero;

import java.time.LocalDate;

/*esta es una clase inmutable record, es decir nunca va a cambiar*/
public record MovieDto(
        Long id,
        String titulo,
        Integer duration,
        Genero genere,
        LocalDate releaseDate,
        Double rating
        ) {

}
