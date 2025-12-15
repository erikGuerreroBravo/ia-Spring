package mx.nube2024.ia.app.htsoft.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import mx.nube2024.ia.app.htsoft.domain.dto.MovieDto;
import mx.nube2024.ia.app.htsoft.domain.dto.SuggestRequestDto;
import mx.nube2024.ia.app.htsoft.domain.dto.UpdateMovieDto;
import mx.nube2024.ia.app.htsoft.domain.service.MovieService;
import mx.nube2024.ia.app.htsoft.domain.service.htsoftAIService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@Tag(name = "Controlador de Peliculas",description = "EndPoint de Peliculas con inteligencia artificial")
public class MovieController {

    private final MovieService movieService;
    private final htsoftAIService aiService;
    public MovieController(MovieService movieService, htsoftAIService aiService) {
        this.movieService = movieService;
        this.aiService = aiService;
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> getAll()
    {
        //casteamos el resultado al tipo de objeto que se necesita transformar
        List<MovieDto> movies= this.movieService.getAll();
        return ResponseEntity.ok(movies);
    }
    @GetMapping("/{id}")
    @Operation(
            summary = "Endpoint que obtiene una pelicula por identificador.",
            description = "Esta endpoint se encarga de consultar todas las peliculas por identidficador.",
            responses = {
                    @ApiResponse(responseCode = "200",description = "Pelicula encontrada"),
                    @ApiResponse(responseCode = "404", description = "Pelicula no encontrada")
            }

    )
    public ResponseEntity<MovieDto> getById(@PathVariable Long id){
        MovieDto movieDto= this.movieService.getById(id);
        if(movieDto == null)
        {
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(movieDto);
    }
    @PostMapping
    public ResponseEntity<MovieDto> add(@RequestBody MovieDto movieDto)
    {
        /*el cuerpo de la respuesta es lo que regrese el movieService*/
        return ResponseEntity.status(HttpStatus.CREATED).body(this.movieService.add(movieDto));
    }
    //este metodo se encarga de aplicar la inteligencia artificial para promover peliculas, via IA
    public ResponseEntity<String> generateMoviesSuggestion(@RequestBody SuggestRequestDto suggestRequestDto) {
        return ResponseEntity.ok(this.aiService.generateMoviesSuggestion(suggestRequestDto.userPreferences()));

    }

    //se emplea la notacion valid para validar una entidad.
    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> update(@PathVariable Long id, @RequestBody @Valid UpdateMovieDto updateMovieDto )
    {
        return ResponseEntity.ok(this.movieService.update(id,updateMovieDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id)
    {
        this.movieService.delete(id);
        return ResponseEntity.ok().build();
    }

}
